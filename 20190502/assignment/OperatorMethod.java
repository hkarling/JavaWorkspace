import java.util.Scanner;
/**
 * �̸�: ������
 * ��¥: 5�� 2��
 * ����: �����ȣ �޼ҵ�
 */

class OperatorMethod {
	static void oper(int i, int j, char ch) {
		
		double result = 0;

		switch (ch){
			case '+':
				result = i + j;
				break;
			case '-':
				result = i - j;
				break;
			case '*':
				result = i * j;
				break;
			case '/':
				if(j != 0)
					result = i / j;
				break;
		}
		System.out.println(i + " " + ch + " " + j + " = " + result);
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù��° ����: ");
		int i = sc.nextInt();
		
		System.out.print("��ù��° ����: ");
		int j = sc.nextInt();

		System.out.print("�����ȣ: ");
		char ch = sc.next().charAt(0);

		if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
			oper(i, j, ch);
		else
			System.out.println("�����ȣ�� ����� �Է��ض�.");

	}
}

/*
	���� :	�ΰ��� ������ �����ȣ(+, -,*,/,%)�� ���� �޾Ƽ�(�μ�) ���޵� �����ȣ�� ���� �μ��� �����Ͽ� 
			����� ����ϴ� �޼ҵ�� �̸޼ҵ带ȣ���ϴ� ���θ޼ҵ带 �����غ�����.
			(���� : �����ȣ�� (+, -,*,/,%) �̿��� ���� ������ �����޽��� ����Ѵ�. )
			���� ) �μ��� ���� �� �μ��� ��ȣ�� Ű�����Է����� �޾Ƽ� �����Ѵ�.
*/