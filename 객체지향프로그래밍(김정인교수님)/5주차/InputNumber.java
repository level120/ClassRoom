package report3;

import java.util.Arrays;
import java.util.Scanner;

public class InputNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		final int SIZE=40;	// �迭�� ũ�⸦ 40���� ����

		int sum=0, tmp, idx=0;	// ���� �հ� ����, �Է°� �ӽ� ����� ����, �ε��� 
		int[] input=new int[SIZE];
		Arrays.fill(input, -1);	// �ʱⰪ -1�� �ʱ�ȭ
		
		System.out.print("Input number : ");
		while ((tmp=scan.nextInt())>-1) {
			input[idx++]=tmp;
			sum+=tmp;
			System.out.print("Input number : ");
		}
		scan.close();

		System.out.println("Sum is : "+sum);
		System.out.println("Mean is : "+sum/(double)idx);
		Arrays.sort(input);		// �迭 ����
		
		System.out.print("Element is : ");
		for(int i:input) {
			if(i!=-1)
				System.out.print(i+" ");	// �迭�� ���� -1�� �ƴҶ��� ���
		}
	}
}