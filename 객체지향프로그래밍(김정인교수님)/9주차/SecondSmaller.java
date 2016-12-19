import java.util.Arrays;
import java.util.Scanner;

class SecondSmaller {
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int[] num=new int[100];						// 입력받은 숫자를 저장
		String n=s.next();							// 정규식에 이용할 String형 변수
		int idx=0, check=-1;
		while(!n.equals("0")){						// 0이 아닐때까지 반복
			if(n.matches("\\d+") && n.length()<8){	// 정규식 사용
				check=Integer.parseInt(n);			// 숫자로 변환
				if(check>0&&check<101)
					num[idx++]=check;
				else
					System.out.println("Error : 범위초과(허용범위 : 1~100)");			// 예외(1)
			}
			else
				System.out.println("문자열 또는 입력한 값의 범위가 큽니다.");			// 예외(2)
			n=s.next();
		}
		s.close();
		for(int i=0; i<idx; i++)
			System.out.print(num[i]+" ");
		Arrays.sort(num,0,idx);				// 오름차순 정렬
		System.out.println("숫자중 두번째로 작은 숫자는 "+num[1]);
	}
}