import java.util.Arrays;
import java.util.Scanner;

class SecondSmaller {
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int[] num=new int[100];						// �Է¹��� ���ڸ� ����
		String n=s.next();							// ���ԽĿ� �̿��� String�� ����
		int idx=0, check=-1;
		while(!n.equals("0")){						// 0�� �ƴҶ����� �ݺ�
			if(n.matches("\\d+") && n.length()<8){	// ���Խ� ���
				check=Integer.parseInt(n);			// ���ڷ� ��ȯ
				if(check>0&&check<101)
					num[idx++]=check;
				else
					System.out.println("Error : �����ʰ�(������ : 1~100)");			// ����(1)
			}
			else
				System.out.println("���ڿ� �Ǵ� �Է��� ���� ������ Ů�ϴ�.");			// ����(2)
			n=s.next();
		}
		s.close();
		for(int i=0; i<idx; i++)
			System.out.print(num[i]+" ");
		Arrays.sort(num,0,idx);				// �������� ����
		System.out.println("������ �ι�°�� ���� ���ڴ� "+num[1]);
	}
}