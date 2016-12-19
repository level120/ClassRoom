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

// [A-Za-z] �� �� �ϳ�
// \\w ���� ���ڸ�	\\W ���� ���ڸ� ������ ������
// \\d ���ڸ�		\\D ���ڸ� ������ ������
// . ��� ����
// ? �������� �ְ� ��� ��
// * �ݵ�� �ϳ� �̻� ����
// !i ��ҹ��� ���� ����
// | �Ǵ�(OR)
// {����} "����"��ŭ �ݺ�
// \\. �Ϲݹ��� ��(.) ������
