package report2;

import java.util.Scanner;

public class Factors {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		System.out.print("Input number : ");
		int n=scan.nextInt();
		
		scan.close();
		
		int k=0;	// 약수임을 확인하는 숫자
		
		while(k<n/2) {	// 입력받은 숫자의 반까지만 반복
			if(n%++k==0)	// 증가후 n과의 나머지연산값이 0과 같은지? 
				System.out.print(k+" ");
		}
		System.out.println(n);
	}
}