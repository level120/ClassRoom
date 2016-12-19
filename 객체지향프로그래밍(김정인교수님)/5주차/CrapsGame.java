package report3;

import java.util.Random;

public class CrapsGame {
	public static void main(String[] args) {
		Random r=new Random();

		final int ROUND=15;		// ���� ���� Ƚ�� ����
		int win=0, lose=0;		// ���� ��� ����

		for(int i=0; i<ROUND; i++) {
			System.out.printf("%3d\t",  i+1);

			int n1=r.nextInt(6)+1;
			int n2=r.nextInt(6)+1;

			System.out.printf("%d(%d+%d) ", n1+n2, n1, n2);

			if((n1+n2)==7 || (n1+n2)==11) {
				System.out.println("Won");		// �¸� ó��
				win++;
			}
			else if((n1+n2)==2 || (n1+n2)==3 || (n1+n2)==12) {
				System.out.println("Lost");		// �й� ó��
				lose++;
			}
			else {
				int memory=n1+n2;
				System.out.print("---- ");
				
				while(true) {		// Ư���� ������ ���⿡ ���ѷ����� ����	
					n1=r.nextInt(6)+1;
					n2=r.nextInt(6)+1;
					System.out.printf("%d(%d+%d) ", n1+n2, n1, n2);
					if((n1+n2)==memory) {
						System.out.println(" Won");
						win++;		// �¸� ó��
						break;		// ���� ó������ ���� ������ �� break
					}
					if((n1+n2)==7) {
						System.out.println(" Lost");
						lose++;		// �й� ó��
						break;		// ���� 7�϶� break
					}
				}
			}
		}
		System.out.println("Count of Won Games is "+win);
		System.out.println("Count of Lost Games is "+lose);
	}
}