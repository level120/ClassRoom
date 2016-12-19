package report3;

import java.util.Arrays;
import java.util.Scanner;

public class InputNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		final int SIZE=40;	// 배열의 크기를 40개로 제한

		int sum=0, tmp, idx=0;	// 각각 합계 변수, 입력값 임시 저장용 변수, 인덱스 
		int[] input=new int[SIZE];
		Arrays.fill(input, -1);	// 초기값 -1로 초기화
		
		System.out.print("Input number : ");
		while ((tmp=scan.nextInt())>-1) {
			input[idx++]=tmp;
			sum+=tmp;
			System.out.print("Input number : ");
		}
		scan.close();

		System.out.println("Sum is : "+sum);
		System.out.println("Mean is : "+sum/(double)idx);
		Arrays.sort(input);		// 배열 정렬
		
		System.out.print("Element is : ");
		for(int i:input) {
			if(i!=-1)
				System.out.print(i+" ");	// 배열의 값이 -1이 아닐때만 출력
		}
	}
}