package report3;

public class ScoreTable {
	public static void main(String[] args) {
		
		// 입력값 초기화
		int[][] inputData={{67, 78, 90, 0, 0, 1},
						   {90, 77, 67, 0, 0, 1},
						   {88, 65, 88, 0, 0, 1},
						   {56, 89, 80, 0, 0, 1},
						   {87, 95, 97, 0, 0, 1}};
		String[][] name={{"이름", "국어", "영어", "수학", "합계", "평균", "석차"},
						 {"홍길동", "임꺽정", "어우동", "황진이", "전우치"}};
		
		// 합계를 저장할 배열
		int[] sum=new int[4];
		
		// inputData 4번 index 합계와 sum 배열을 입력하는 반복문
		for(int i=0; i<5; i++) {
			for(int j=0; j<3; j++) {
				inputData[i][3]+=inputData[i][j];
				sum[j]+=inputData[i][j];
			}
			sum[3]+=inputData[i][3];
		}
		
		// inputData 6번 index 석차를 구하는 반복문
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++)
				if(inputData[i][3]<inputData[j][3])
					inputData[i][5]++;
		}
		
		// 종합 출력문
		for(String i:name[0])
			System.out.print(i+"\t");
		System.out.println();
		
		for(int i=0; i<5; i++) {
			System.out.print(name[1][i]+'\t');
			for(int j=0; j<4; j++)
				System.out.printf("%3d\t",  inputData[i][j]);
			System.out.printf("%.2f\t",  inputData[i][3]/(double)3.0);
			System.out.printf("%3d\n",  inputData[i][5]);
		}
		System.out.print("합계\t");
		
		for(int i:sum)
			System.out.printf("%4d\t", i);
		System.out.printf("%.2f\n", sum[3]/(double)3.0);
	}
}