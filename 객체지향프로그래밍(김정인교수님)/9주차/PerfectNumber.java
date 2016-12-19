class PerfectNumber {
	private final int LIMIT = 17;				// �Ҽ��� ã�� ����(1~LIMIT+1)
	private int[] prime=new int[LIMIT];			// ã�� �Ҽ��� �����ϴ� �迭
	private int[] mersenPrime=new int[LIMIT];	// �޸��� �Ҽ��� ������ �迭	 
	private long startTime, endTime;			// ���� ���۽ð�, ����ð�

	PerfectNumber(){
		startTimer();		// ���� �ð� ����
		primeSearch();		// �����佺�׳׽��� ü�� �̿��Ͽ� prime ���ϱ�
		mersennePrime();	// �޸��� �Ҽ��� ã�� �Լ� 
		printNumber();		// ������ ���
		endTimer();			// ���� �ð� ���� �� ���α׷� ���� �ð� ���
	}

	void startTimer(){
		startTime = System.currentTimeMillis();
	}

	void endTimer(){
		endTime = System.currentTimeMillis();
		System.out.println("����ð� : "+(endTime-startTime)+"ms");	// ������ �и�������(1/1000��)
	}

	void primeSearch(){
		int[] tmp = new int[LIMIT];
		for(int i=0; i<tmp.length; i++){			// �迭 �ʱ�ȭ(2~LIMIT+1������ ���ڷ� ä��)
			tmp[i]=i+2;
		}
		for(int i=0, idx=0; i<tmp.length; i++){		// �����佺�׳׽��� ü(O(NlgN))
			if(tmp[i]!=-1){
				prime[idx++]=tmp[i];
				for(int j=i+1; j<tmp.length; j++){
					if(tmp[j]%tmp[i]==0)
						tmp[j]=-1;
				}
			}
		}
	}

	void mersennePrime(){
		for(int i=0, idx=0; i<prime.length; i++){
			long s = (1<<prime[i])-1;				// �޸��� �Ҽ� ã��(O(n^2))
			long len = (long)Math.sqrt(s);
			boolean check = true;
			for(long j=2; j<=len; j++){
				if(s%j==0){
					check=false;
					break;
				}
			}
			if(check)
				mersenPrime[idx++]=prime[i];
		}
	}

	void printNumber(){
		System.out.print("100�� ������ ������ : ");
		for(int i=0; mersenPrime[i]!=0; i++)
			System.out.print((long)Math.pow(2, mersenPrime[i]-1)*((long)Math.pow(2, mersenPrime[i])-1)+" ");
		System.out.println();
	}

	public static void main(String[] args){
		new PerfectNumber();
	}
}