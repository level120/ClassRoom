package report3;

import java.util.Random;

public class Scores {
	public static void main(String[] args) {
		Random rand=new Random();
		
		int[] graph=new int[10];	// �׷����� �׸��� ���� �迭
		
		for(int i=0; i<60; i++) {
			int num=rand.nextInt(100);	// ������ �ۼ�Ʈ�� ������ ���� ����
			
			if(num<50)		graph[(rand.nextInt(20)+60)/10]++;	// 50% �� �ش��ϴ� ���� ������ �����ϰ� ���� �ο�
			else if(num<80)	graph[(rand.nextInt(20)+80)/10]++;	// 80%-50% �� �ش��ϴ� ���� ������ �����ϰ� ���� �ο�
			else if(num<95)	graph[(rand.nextInt(20)+40)/10]++;	// 95%-80% �� �ش��ϴ� ���� ������ �����ϰ� ���� �ο�
			else			graph[rand.nextInt(40)/10]++;		// �� �ۿ� �ش��ϴ� ����(5%)������ �����ϰ� ���� �ο�
		}
		
		// ���� for ���� �׷��� �ܼ� ��� 
		for(int i=0; i<10; i++) {
			System.out.printf("%2d - %3d score : ", i*10, (i+1)*10);
			for(int j=0; j<graph[i]; j++)
				System.out.print("* ");
			System.out.println();
		}
	}
}