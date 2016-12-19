package report3;

import java.util.Random;

public class CrapsGame {
	public static void main(String[] args) {
		Random r=new Random();

		final int ROUND=15;		// 게임 실행 횟수 설정
		int win=0, lose=0;		// 승패 기록 변수

		for(int i=0; i<ROUND; i++) {
			System.out.printf("%3d\t",  i+1);

			int n1=r.nextInt(6)+1;
			int n2=r.nextInt(6)+1;

			System.out.printf("%d(%d+%d) ", n1+n2, n1, n2);

			if((n1+n2)==7 || (n1+n2)==11) {
				System.out.println("Won");		// 승리 처리
				win++;
			}
			else if((n1+n2)==2 || (n1+n2)==3 || (n1+n2)==12) {
				System.out.println("Lost");		// 패배 처리
				lose++;
			}
			else {
				int memory=n1+n2;
				System.out.print("---- ");
				
				while(true) {		// 특별한 조건이 없기에 무한루프로 구성	
					n1=r.nextInt(6)+1;
					n2=r.nextInt(6)+1;
					System.out.printf("%d(%d+%d) ", n1+n2, n1, n2);
					if((n1+n2)==memory) {
						System.out.println(" Won");
						win++;		// 승리 처리
						break;		// 합이 처음나온 값과 동일할 때 break
					}
					if((n1+n2)==7) {
						System.out.println(" Lost");
						lose++;		// 패배 처리
						break;		// 합이 7일때 break
					}
				}
			}
		}
		System.out.println("Count of Won Games is "+win);
		System.out.println("Count of Lost Games is "+lose);
	}
}