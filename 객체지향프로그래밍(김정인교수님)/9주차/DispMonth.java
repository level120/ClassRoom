import java.util.Scanner;

class DispMonth {
	private int[] cal=new int[37]; // 배열 인덱스 에러를 막기위해 여유공간 생성(최대 6일을 넘지 않는다는 것을 기준)
	
	DispMonth(int m, int d){	// 인자있는 생성자 생성
		defaultData(m,d);		// 받은 값 바로 대입
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