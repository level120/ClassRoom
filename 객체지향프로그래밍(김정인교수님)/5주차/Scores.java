package report3;

import java.util.Random;

public class Scores {
	public static void main(String[] args) {
		Random rand=new Random();
		
		int[] graph=new int[10];	// 그래프를 그리기 위한 배열
		
		for(int i=0; i<60; i++) {
			int num=rand.nextInt(100);	// 구간별 퍼센트를 나누기 위한 구문
			
			if(num<50)		graph[(rand.nextInt(20)+60)/10]++;	// 50% 에 해당하는 구간 내에서 랜덤하게 점수 부여
			else if(num<80)	graph[(rand.nextInt(20)+80)/10]++;	// 80%-50% 에 해당하는 구간 내에서 랜덤하게 점수 부여
			else if(num<95)	graph[(rand.nextInt(20)+40)/10]++;	// 95%-80% 에 해당하는 구간 내에서 랜덤하게 점수 부여
			else			graph[rand.nextInt(40)/10]++;		// 그 밖에 해당하는 구간(5%)내에서 랜덤하게 점수 부여
		}
		
		// 이하 for 문은 그래프 단순 출력 
		for(int i=0; i<10; i++) {
			System.out.printf("%2d - %3d score : ", i*10, (i+1)*10);
			for(int j=0; j<graph[i]; j++)
				System.out.print("* ");
			System.out.println();
		}
	}
}