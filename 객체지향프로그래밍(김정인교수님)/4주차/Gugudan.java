package report2;

public class Gugudan {
	public static void main(String[] args) {
		System.out.println("(1)������ ����ϱ�"+"\n");
		GugudanAll();
		System.out.println();
		System.out.println("(2)3�ܾ� ����ϱ�"+"\n");
		Gugudan3L();
		System.out.println();
		System.out.println("(3)4�ܾ� ����ϱ�"+"\n");
		Gugudan4L();
	}

	// �Ʒ� GugudanAll()�� (0.0) ���� (10,10)���� ���
	static void GugudanAll() {
		for(int i=0; i<10; i++) {
			System.out.print(i!=0?i:" ");
			for(int j=1; j<10; j++) {
				if(i==0)
					System.out.printf(" %3d ", j);
				else
					System.out.printf(" %3d ", i*j);
			}
			System.out.println();
		}
	}

	// �Ʒ� Gugudan3L()�� 3�� �� �� ��� ���
	static void Gugudan3L() {
		for(int i=1; i<8; i+=3)
			GugudanDefault(i, 3);
	}

	// �Ʒ� Gugudan4L()�� 4�� �� �� ��� ���
	static void Gugudan4L() {
		for(int i=2; i<7; i+=4)
			GugudanDefault(i, 4);
	}

	// �Ʒ� GugudanDefault(int num, int len)�� len���� ������ ���� ����ϱ� ���� Template �̴�.
	static void GugudanDefault(int num, int len) {
		for(int i=1; i<10; i++) {
			for(int j=0; j<len; j++)
				System.out.printf("%d x %d = %2d%c", num+j, i, (num+j)*i, j!=len-1?'\t':'\n');
				// �� ������ ������ %c������ ���׿����� ���
		}
		System.out.println();
	}
}