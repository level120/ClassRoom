package report2;

import java.util.Random;

public class Dices {
	public static void main(String[] args) {
		Random r = new Random();
		
		int[] chk=new int[11];		// count�� ���� 4�� �迭 ���
		
		for(int i=0; i<12; i++) {
			/*
			if(i!=0 && i%20==0)		// 20ȸ �б���(�� ���ڸ�ŭ ����� new line)
				System.out.println();
			 */
			int dice1=r.nextInt(6)+1;
			int dice2=r.nextInt(6)+1;
			
			chk[dice1+dice2-2]+=1;	// index�� 0���� ���������� -2
			
			System.out.printf("%3d",dice1+dice2);
		}
		System.out.println("\n");
		for(int i=0; i<11; i++)
			System.out.printf("%2d:%d ",i+2, chk[i]);
	}
}