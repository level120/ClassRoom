package report2;

public class Over50000 {
	public static void main(String[] args) {
		int ans=0, sum=1;
		while(sum<50001)	// sum<=50000 �� ���� �ǹ�
			sum*=++ans;		// sum=sum*ans;	ans=ans+1; �� ���� �ǹ�
		System.out.println(ans+" �Դϴ�.");
	}
}