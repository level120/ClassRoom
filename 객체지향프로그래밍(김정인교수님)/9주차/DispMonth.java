import java.util.Scanner;

class DispMonth {
	private int[] cal=new int[37]; // �迭 �ε��� ������ �������� �������� ����(�ִ� 6���� ���� �ʴ´ٴ� ���� ����)
	
	DispMonth(int m, int d){	// �����ִ� ������ ����
		defaultData(m,d);		// ���� �� �ٷ� ����
		printCal();
	}
	
	void defaultData(int m, int d){
		for(int i=0; i<d; i++)
			cal[m+i-1]=i+1;
	}

	void printCal(){
		System.out.println("SUN MON TUE WED THU FRI SAT");
		for(int i=0; i<cal.length; i++){
			if(i%7==0&&i!=0)
				System.out.println();
			if(cal[i]==0)
				System.out.print("    ");
			else
				System.out.printf("%3d ",cal[i]);
		}
	}
	
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int m=s.nextInt(), d=s.nextInt();
		s.close();
		new DispMonth(m,d);
	}
}