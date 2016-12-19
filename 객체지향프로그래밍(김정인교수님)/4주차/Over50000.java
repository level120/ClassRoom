package report2;

public class Over50000 {
	public static void main(String[] args) {
		int ans=0, sum=1;
		while(sum<50001)	// sum<=50000 와 같은 의미
			sum*=++ans;		// sum=sum*ans;	ans=ans+1; 과 같은 의미
		System.out.println(ans+" 입니다.");
	}
}