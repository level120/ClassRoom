package ch05;

import java.util.Scanner;

public class CheckTel {
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		String str=s.next();
		while(!str.equals("quit")) {
			if(str.matches("01[0169](-?|\\.)\\d{4}(-?|\\.)\\d{4}"))
				System.out.println("phone number");
			else if(str.matches("[0-2]\\d{3}(-|\\.)(0?[1-9]|1[0-2])(-|\\.)(0?[1-9]|[12][0-9]|3[01])\\.?"))
				System.out.println("date");
			else
				System.out.println("err");
			str=s.next();
		}
		s.close();
	}
}

// [A-Za-z] 이 중 하나
// \\w 문자 숫자만	\\W 문자 숫자를 제외한 나머지
// \\d 숫자만		\\D 숫자를 제외한 나머지
// . 모든 문자
// ? 있을수도 있고 없어도 됨
// * 반드시 하나 이상 존재
// !i 대소문자 구분 안함
// | 또는(OR)
// {숫자} "숫자"만큼 반복
// \\. 일반문자 점(.) 찍을때
