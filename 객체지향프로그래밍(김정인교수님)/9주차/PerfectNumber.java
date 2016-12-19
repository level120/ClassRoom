class PerfectNumber {
	private final int LIMIT = 17;				// 소수를 찾는 구간(1~LIMIT+1)
	private int[] prime=new int[LIMIT];			// 찾은 소수를 저장하는 배열
	private int[] mersenPrime=new int[LIMIT];	// 메르센 소수를 저장할 배열	 
	private long startTime, endTime;			// 각각 시작시간, 종료시간

	PerfectNumber(){
		startTimer();		// 시작 시간 측정
		primeSearch();		// 에라토스테네스의 체를 이용하여 prime 구하기
		mersennePrime();	// 메르센 소수를 찾는 함수 
		printNumber();		// 완전수 출력
		endTimer();			// 종료 시간 측정 및 프로그램 구동 시간 출력
	}

	void startTimer(){
		startTime = System.currentTimeMillis();
	}

	void endTimer(){
		endTime = System.currentTimeMillis();
		System.out.println("실행시간 : "+(endTime-startTime)+"ms");	// 단위는 밀리세컨드(1/1000초)
	}

	void primeSearch(){
		int[] tmp = new int[LIMIT];
		for(int i=0; i<tmp.length; i++){			// 배열 초기화(2~LIMIT+1까지의 숫자로 채움)
			tmp[i]=i+2;
		}
		for(int i=0, idx=0; i<tmp.length; i++){		// 에라토스테네스의 체(O(NlgN))
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
			long s = (1<<prime[i])-1;				// 메르센 소수 찾기(O(n^2))
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
		System.out.print("100억 이하의 완전수 : ");
		for(int i=0; mersenPrime[i]!=0; i++)
			System.out.print((long)Math.pow(2, mersenPrime[i]-1)*((long)Math.pow(2, mersenPrime[i])-1)+" ");
		System.out.println();
	}

	public static void main(String[] args){
		new PerfectNumber();
	}
}