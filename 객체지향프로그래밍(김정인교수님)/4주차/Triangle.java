package report2;

import java.util.Scanner;

public class Triangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("1~20������ ���ڸ� �Է��ϼ���(0:����): ");
		int Tcase = scan.nextInt();
		while(Tcase != 0) {
			if(Tcase<0 || Tcase>20)
				System.out.println("1~20�� ������ ������ϴ�.");
			else{
				// print display method
				TriangleUp(Tcase);
				TriangleUpReverse(Tcase);
				TriangleDown(Tcase);
				TriangleDownReverse(Tcase);
			}
			System.out.print("1~20������ ���ڸ� �Է��ϼ���(0:����): ");
			Tcase = scan.nextInt();
		}
		System.out.print("���α׷��� �����մϴ�.");
		scan.close();
	}

	static void TriangleUp(int Tcase) {
		// �������� �ﰢ��
		System.out.println("��������");
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
		// �󿪹��� �ﰢ��
		System.out.println("�󿪹���");
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
		// �������� �ﰢ��
		System.out.println("��������");
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
		// �Ͽ����� �ﰢ��
		System.out.println("�Ͽ�����");
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