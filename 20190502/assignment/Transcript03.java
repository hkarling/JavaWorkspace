import java.util.Scanner;
/**
 * �̸�: ������
 * ��¥: 5�� 2��
 * ����: �������ϱ�
 */
class Transcript03 {

	// 1) ����, ����, ���� ������ �μ��޾� ������ ���Ͽ� ������ �����ϴ� �޼ҵ� �ۼ� (���������� private)
	private int total(int korean, int english, int math) {
		return korean + english + math;
	}

	// 2) ������ ������� �μ��ι޾� ����� ���Ͽ� ����� �����ϴ� �޼ҵ� �ۼ� (���������� private)
	private double average(int total, int subject) {
		return (total * 100 / 3) /100.0;
	}
	
	// 3) ����� �μ��� �޾� ����� ���Ͽ� ����� �������ִ� �޼ҵ� �ۼ��Ѵ�(���������� private)
	private char grade(double average) {
		char ch = 'F';
		if (average >= 90)
			ch = 'A';
		else if (average >= 80)
			ch = 'B';
		else if (average >= 70)
			ch = 'C';
		else if (average >= 60)
			ch = 'D';

		return ch;
	}

	// 4) �̸�, ����, ����, ���� ������ �μ��� �޾� ����, ���, ��� �� ���Ͽ� �� ����� ȭ�鿡 ����ϴ� �޼ҵ带 �����ϼ���.
	//    (���������� public, ������ ���, ����� �̹� ������� 1), 2) ,3) �޼ҵ带 ȣ���Ͽ� �� ����� ���� ���´�)
	public void display(int korean, int english, int math) {

		int total = this.total(korean, english, math);
		double average = this.average(total, 3);
		char grade = this.grade(average);

		System.out.println("����: " + total);
		System.out.println("���: " + average);
		System.out.println("���: " + grade);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ����: ");
		int korean = sc.nextInt();
		System.out.print("���� ����: ");
		int math = sc.nextInt();
		System.out.print("���� ����: ");
		int english = sc.nextInt();
		
		sc.close();

		Transcript03 obj = new Transcript03();

		obj.display(korean, english, math);

	}
}



/*
	1. �������ϴ� ����� ����ϴ� Ŭ���� 

		1) ����, ����, ���� ������ �μ��޾� ������ ���Ͽ� ������ �����ϴ� �޼ҵ� �ۼ� (���������� private)

		2) ������ ������� �μ��ι޾� ����� ���Ͽ� ����� �����ϴ� �޼ҵ� �ۼ� (���������� private)

		3) ����� �μ��� �޾� ����� ���Ͽ� ����� �������ִ� �޼ҵ� �ۼ��Ѵ�(���������� private)
	   
		4) �̸�, ����, ����, ���� ������ �μ��� �޾� ����, ���, ��� �� ���Ͽ� �� ����� ȭ�鿡 ����ϴ� �޼ҵ带 �����ϼ���.
		   (���������� public, ������ ��� , ����� �̹� ������� 1) , 2) ,3) �޼ҵ带 ȣ���Ͽ� �� ����� ���� ���´�)

	---------------------------------------------

	2. ���� �޼ҵ尡 �ִ� Ŭ������ �����Ѵ�.
	   ���� �޼ҵ带 �ۼ��Ͽ� �� �ȿ���
	   ���� 1���� ���� �޼ҵ��� ������ ����ϴ� �޼ҵ带 ȣ���Ͽ� ��������� Ȯ���Ѵ�.
	   ����) ����,����,���� ,�̸��� Ű���� �Է��� �޴´�.

	-------------------------------------------

	nextInt()	->	nextInt()	-> next()		--	����
	nextInt()	->	nextInt()	-> nextLine()	--	��������
	nextLine()	->	nextLine()	-> nextLine()	--	����
*/