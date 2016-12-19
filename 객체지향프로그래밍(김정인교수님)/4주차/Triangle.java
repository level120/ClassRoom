package report2;

import java.util.Scanner;

public class Triangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("1~20사이의 숫자를 입력하세요(0:종료): ");
		int Tcase = scan.nextInt();
		while(Tcase != 0) {
			if(Tcase<0 || Tcase>20)
				System.out.println("1~20의 범위를 벗어났습니다.");
			else{
				// print display method
				TriangleUp(Tcase);
				TriangleUpReverse(Tcase);
				TriangleDown(Tcase);
				TriangleDownReverse(Tcase);
			}
			System.out.print("1~20사이의 숫자를 입력하세요(0:종료): ");
			Tcase = scan.nextInt();
		}
		System.out.print("프로그램을 종료합니다.");
		scan.close();
	}

	static void TriangleUp(int Tcase) {
		// 상정방향 삼각형
		System.out.println("상정방향");
		for(int i=1; i<Tcase+1; i++) {
			for(int j=0; j<Tcase; j++) {
				if(j<Tcase-i)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void TriangleUpReverse(int Tcase) {
		// 상역방향 삼각형
		System.out.println("상역방향");
		for(int i=0; i<Tcase; i++) {
			for(int j=0; j<Tcase; j++) {
				if(j>i)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void TriangleDown(int Tcase) {
		// 하정방향 삼각형
		System.out.println("하정방향");
		for(int i=0; i<Tcase; i++) {
			for(int j=0; j<Tcase; j++) {
				if(j<i)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void TriangleDownReverse(int Tcase) {
		// 하역방향 삼각형
		System.out.println("하역방향");
		for(int i=0; i<Tcase; i++) {
			for(int j=0; j<Tcase; j++) {
				if(j<Tcase-i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}