package report2;

public class Account {
	public static void main(String[] args) {
		int money = 1000;
		for(int i=0; i<20; i++)
			money +=(money*0.038);	// 복리 계산임으로 합에 또 합산
		System.out.println(money+" 만원");
	}
}