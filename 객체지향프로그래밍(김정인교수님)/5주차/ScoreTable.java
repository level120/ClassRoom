package report3;

public class ScoreTable {
	public static void main(String[] args) {
		
		// �Է°� �ʱ�ȭ
		int[][] inputData={{67, 78, 90, 0, 0, 1},
						   {90, 77, 67, 0, 0, 1},
						   {88, 65, 88, 0, 0, 1},
						   {56, 89, 80, 0, 0, 1},
						   {87, 95, 97, 0, 0, 1}};
		String[][] name={{"�̸�", "����", "����", "����", "�հ�", "���", "����"},
						 {"ȫ�浿", "�Ӳ���", "��쵿", "Ȳ����", "����ġ"}};
		
		// �հ踦 ������ �迭
		int[] sum=new int[4];
		
		// inputData 4�� index �հ�� sum �迭�� �Է��ϴ� �ݺ���
		for(int i=0; i<5; i++) {
			for(int j=0; j<3; j++) {
				inputData[i][3]+=inputData[i][j];
				sum[j]+=inputData[i][j];
			}
			sum[3]+=inputData[i][3];
		}
		
		// inputData 6�� index ������ ���ϴ� �ݺ���
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++)
				if(inputData[i][3]<inputData[j][3])
					inputData[i][5]++;
		}
		
		// ���� ��¹�
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
		System.out.print("�հ�\t");
		
		for(int i:sum)
			System.out.printf("%4d\t", i);
		System.out.printf("%.2f\n", sum[3]/(double)3.0);
	}
}