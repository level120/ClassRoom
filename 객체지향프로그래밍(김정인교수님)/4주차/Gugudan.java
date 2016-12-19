package report2;

public class Gugudan {
	public static void main(String[] args) {
		System.out.println("(1)구구단 출력하기"+"\n");
		GugudanAll();
		System.out.println();
		System.out.println("(2)3단씩 출력하기"+"\n");
		Gugudan3L();
		System.out.println();
		System.out.println("(3)4단씩 출력하기"+"\n");
		Gugudan4L();
	}

	// 아래 GugudanAll()은 (0.0) 부터 (10,10)까지 출력
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

	// 아래 Gugudan3L()은 3개 단 씩 끊어서 출력
	static void Gugudan3L() {
		for(int i=1; i<8; i+=3)
			GugudanDefault(i, 3);
	}

	// 아래 Gugudan4L()은 4개 단 씩 끊어서 출력
	static void Gugudan4L() {
		for(int i=2; i<7; i+=4)
			GugudanDefault(i, 4);
	}

	// 아래 GugudanDefault(int num, int len)은 len개의 라인을 끊어 출력하기 위한 Template 이다.
	static void GugudanDefault(int num, int len) {
		for(int i=1; i<10; i++) {
			for(int j=0; j<len; j++)
				System.out.printf("%d x %d = %2d%c", num+j, i, (num+j)*i, j!=len-1?'\t':'\n');
				// 이 문장의 마지막 %c에서는 삼항연산자 사용
		}
		System.out.println();
	}
}