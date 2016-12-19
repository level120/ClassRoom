package report3;

import java.util.Scanner;

public class Reservation {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		final int MOVIE=5, SEAT=20;
		boolean[][] state=new boolean[MOVIE][SEAT];
		
		while(true) {
			System.out.print("예약현황 보기 1, 무시 0 : ");
			int select=scan.nextInt();
			
			if(select==1)	view(state, MOVIE, SEAT);	// 자리 예약후 바로 재출력 되는 것을 방지
			
			System.out.print("영화와 자리순으로 입력 : ");
			int selectMovie=scan.nextInt();
			
			if(selectMovie<0)	break;	// -1 입력시 종료
			
			int selectSeat=scan.nextInt();
			
			if(selectMovie>5 || selectSeat>20 || selectSeat<0) {	// 입력값 예외 처리
				System.out.println("올바르지 않은 선택입니다.\n");
				continue;
			}
			
			if(Token(state, selectMovie, selectSeat))		// 예약 함수 호출(boolean형 반환)
				System.out.println("정상적으로 예약되었습니다.");
			else
				System.out.println("이미 선택된 자리입니다.");
			System.out.println();
		}
		System.out.println("종료합니다.");
		scan.close();
	}
	
	//자리 예약 함수(성공시 true, 실패시 false 반환)
	static boolean Token(boolean[][] state, int inputMovie, int inputSeat) {
		if(!state[inputMovie-1][inputSeat-1]) {
			state[inputMovie-1][inputSeat-1]=true;
			return true;
		}
		else return false;
	}
	
	// 예약현황 출력 함수
	static void view(boolean[][] state, int MOVIE, int SEAT) {
		for(int i=0; i<MOVIE; i++) {
			System.out.println("────"+(i+1)+"편─────────────────────────────────────────────────────────────────────────────────");
			System.out.print("No    : ");
			for(int j=0; j<SEAT; j++)
				System.out.printf("%3d%c", j+1, ((j!=19)?' ':'\n'));
			System.out.print("State : ");
			for(int j=0; j<SEAT; j++)
				System.out.printf("%3d%c", state[i][j]?1:0, ((j!=19)?' ':'\n'));
			System.out.println("────────────────────────────────────────────────────────────────────────────────────────\n");
		}
	}
}