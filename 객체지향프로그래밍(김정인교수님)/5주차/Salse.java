package report3;

import java.util.Scanner;

public class Salse {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		/*
		 	* SALSE		�ǸŽ��� ����
		 	* standard 	�׷��� ��� �ִ� ���� �� (Begin 0)
		 */
		final int SALSE=12;
		int standard=0;
		int[] salse=new int[SALSE];
		
		System.out.print("input number 12 : ");
		for(int i=0; i<SALSE; i++) {
			salse[i]=scan.nextInt();		// salse �迭�� �ʱ�ȭ
			if(salse[i]>standard)
				standard=salse[i];
		}
		scan.close();
		
		for(int i=standard; i>0; i--) {
			for(int j=0; j<SALSE; j++) {
				System.out.printf("%c\t",((salse[j]>=i)?'*':' '));	// i������ salse[j]���� Ŭ ���� * ���(���׿����� ���)
			}
			System.out.println();
		}
		
		System.out.print("input number : ");
		for(int i:salse)
			System.out.print(i+" ");	// ó�� �Է����κ��� 50���� ������ �ֱ⿡ �Է��ߴ� �� �����
	}
}