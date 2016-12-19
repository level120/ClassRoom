package report3;

import java.util.Scanner;

public class Reservation {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		final int MOVIE=5, SEAT=20;
		boolean[][] state=new boolean[MOVIE][SEAT];
		
		while(true) {
			System.out.print("������Ȳ ���� 1, ���� 0 : ");
			int select=scan.nextInt();
			
			if(select==1)	view(state, MOVIE, SEAT);	// �ڸ� ������ �ٷ� ����� �Ǵ� ���� ����
			
			System.out.print("��ȭ�� �ڸ������� �Է� : ");
			int selectMovie=scan.nextInt();
			
			if(selectMovie<0)	break;	// -1 �Է½� ����
			
			int selectSeat=scan.nextInt();
			
			if(selectMovie>5 || selectSeat>20 || selectSeat<0) {	// �Է°� ���� ó��
				System.out.println("�ùٸ��� ���� �����Դϴ�.\n");
				continue;
			}
			
			if(Token(state, selectMovie, selectSeat))		// ���� �Լ� ȣ��(boolean�� ��ȯ)
				System.out.println("���������� ����Ǿ����ϴ�.");
			else
				System.out.println("�̹� ���õ� �ڸ��Դϴ�.");
			System.out.println();
		}
		System.out.println("�����մϴ�.");
		scan.close();
	}
	
	//�ڸ� ���� �Լ�(������ true, ���н� false ��ȯ)
	static boolean Token(boolean[][] state, int inputMovie, int inputSeat) {
		if(!state[inputMovie-1][inputSeat-1]) {
			state[inputMovie-1][inputSeat-1]=true;
			return true;
		}
		else return false;
	}
	
	// ������Ȳ ��� �Լ�
	static void view(boolean[][] state, int MOVIE, int SEAT) {
		for(int i=0; i<MOVIE; i++) {
			System.out.println("��������"+(i+1)+"������������������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.print("No    : ");
			for(int j=0; j<SEAT; j++)
				System.out.printf("%3d%c", j+1, ((j!=19)?' ':'\n'));
			System.out.print("State : ");
			for(int j=0; j<SEAT; j++)
				System.out.printf("%3d%c", state[i][j]?1:0, ((j!=19)?' ':'\n'));
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");
		}
	}
}