package report2;

public class Dividend {
	public static void main(String[] args) {
		double k=100.0;	// ���ڱ�
		double m=1.21;	// ���� �ۼ�Ʈ
		
		while(k<5001) { // k<=5000 �� �ǹ̰� ����
			System.out.println("���ڱ� : "+(int)k+" ����\t"+"���� : "+(int)(k*m)+" ����");
			k+=100.0;
		}
	}
}