package report2;

import java.util.Scanner;

public class Factors {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		System.out.print("Input number : ");
		int n=scan.nextInt();
		
		scan.close();
		
		int k=0;	// ������� Ȯ���ϴ� ����
		
		while(k<n/2) {	// �Է¹��� ������ �ݱ����� �ݺ�
			if(n%++k==0)	// ������ n���� ���������갪�� 0�� ������? 
				System.out.print(k+" ");
		}
		System.out.println(n);
	}
}