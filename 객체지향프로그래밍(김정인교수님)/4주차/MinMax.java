package report2;

import java.util.Random;

public class MinMax {
	public static void main(String[] args) {
		Random r=new Random();
		int n1 = r.nextInt(100)+1;
		int n2 = r.nextInt(100)+1;
		int min, max;
		if(n1>n2) {
			max=n1;
			min=n2;
		}
		else {
			max=n2;
			min=n1;
		}
		System.out.println("Max : "+max);
		System.out.println("Min : "+min);
	}
}