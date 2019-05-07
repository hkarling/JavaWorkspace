/**
 * �̸�: ������
 * ��¥: 5�� 7��
 * ����: �������ϱ� 4����
 */
import java.util.Scanner;

class Transcript04 {
	
	// 1) ����, ����, ���� ������ �μ��޾� ������ ���Ͽ� ������ �����ϴ� �޼ҵ� �ۼ�
	private int total(int korean, int english, int math) {
		return korean + english + math;
	}
	
	// 2) ������ ������� �μ��ι޾� ����� ���Ͽ� ����� �����ϴ� �޼ҵ� �ۼ�
	private double average(int total, int subjects) {
		return (total * 100 / subjects) / 100.0;
	}
	
	// 3) ����� �μ��� �޾� ����� ���Ͽ� ����� �������ִ� �޼ҵ� �ۼ�
	private char grade(double average) {
		
		char result = 'F';

		if (average >= 90)
			result = 'A';
		else if (average >= 80)
			result = 'B';
		else if (average >= 70)
			result = 'C';
		else if (average >= 60)
			result = 'D';

		return result;	
	}

	// 4) �̸�, ����, ����, ���� ������ �μ��� �޾� ����, ���, ����� ���Ͽ� �� �����
	//	  ȭ�鿡 ����ϴ� �޼ҵ带 �����ϼ���.
	public void display(String name, int korean, int english, int math) {

		int total		= this.total(korean, english, math);
		double average	= this.average(total, 3);
		char grade		= this.grade(average);
		
		System.out.println("\n----- ��� -----");
		System.out.println("�̸�: " + name);
		System.out.println("����: " + korean + "\t����: " + english + "\t����: " + math);
		System.out.println("����: " + total + "\t���: " + average + "\t���: " + grade);	
	}


/*
	2. ���� �޼ҵ尡 �ִ� Ŭ������ �����Ѵ�. ���� �޼ҵ带 �ۼ��Ͽ� �� �ȿ��� ���� 1����
	   ���� �޼ҵ� �� ������ ����ϴ� �޼ҵ带 ȣ���Ͽ� ��������� Ȯ���Ѵ�.
	   ����) ����, ����, ����, �̸��� Ű���� �Է��� �޴´�.
*/
	public static void main(String[] args){

		int korean;
		int english;
		int math;
		String name;

		Scanner sc = new Scanner(System.in);

		System.out.print("�̸�: ");
		name = sc.next();
		System.out.print("����: ");
		korean = sc.nextInt();
		System.out.print("����: ");
		english = sc.nextInt();
		System.out.print("����: ");
		math = sc.nextInt();
		
		sc.close();
		
		Transcript04 obj = new Transcript04();
		obj.display(name, korean, english, math);
	}
}