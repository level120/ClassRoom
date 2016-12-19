package report3;

import java.util.Scanner;

public class Salse {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		/*
		 	* SALSE		판매실적 개수
		 	* standard 	그래프 출력 최대 라인 수 (Begin 0)
		 */
		final int SALSE=12;
		int standard=0;
		int[] salse=new int[SALSE];
		
		System.out.print("input number 12 : ");
		for(int i=0; i<SALSE; i++) {
			salse[i]=scan.nextInt();		// salse 배열에 초기화
			if(salse[i]>standard)
				standard=salse[i];
		}
		scan.close();
		
		for(int i=standard; i>0; i--) {
			for(int j=0; j<SALSE; j++) {
				System.out.printf("%c\t",((salse[j]>=i)?'*':' '));	// i값보다 salse[j]값이 클 때만 * 출력(삼항연산자 사용)
			}
			System.out.println();
		}
		
		System.out.print("input number : ");
		for(int i:salse)
			System.out.print(i+" ");	// 처음 입력으로부터 50라인 떨어져 있기에 입력했던 값 재출력
	}
}