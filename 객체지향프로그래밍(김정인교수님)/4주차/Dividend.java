package report2;

public class Dividend {
	public static void main(String[] args) {
		double k=100.0;	// 투자금
		double m=1.21;	// 배당금 퍼센트
		
		while(k<5001) { // k<=5000 과 의미가 같음
			System.out.println("투자금 : "+(int)k+" 만원\t"+"배당금 : "+(int)(k*m)+" 만원");
			k+=100.0;
		}
	}
}