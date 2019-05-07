class Test {
	int a = 5;
	static int b = 10;

	public void aa() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(this.a);
		System.out.println(this.b);
	}
	public void bb() {
		aa();
		this.aa();
		dd();
		this.dd();
		Test.dd();
	}

	// static �� �ȿ��� this Ű���� ���Ұ�, non-static ���ٺҰ�.
	public static void cc() {
//		System.out.println(a);
		System.out.println(b);
//		System.out.println(this.a);
//		System.out.println(this.b);
	}
	public static void dd() {
//		aa();
//		this.aa();
		cc();
//		this.cc();
		Test.cc();
	}
}
///////////////////////////////


public class StaticExam {
	public static void main(String[] args) {
		
		// static ��������
		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();

		System.out.println("t1�ּ�: " + t1);
		System.out.println("t2�ּ�: " + t2);
		System.out.println("t3�ּ�: " + t3);

		System.out.println("--- non-static ���� ������ ---");
		System.out.println("t1.a = " + t1.a);
		System.out.println("t2.a = " + t2.a);
		System.out.println("t3.a = " + t3.a);

		t2.a = 100;

		System.out.println("--- non-static ���� ������ ---");
		System.out.println("t1.a = " + t1.a);	// 5
		System.out.println("t2.a = " + t2.a);	// 100
		System.out.println("t3.a = " + t3.a);	// 5
		
		//////////////////////////////////
		System.out.println("--- static ���� ������ ---");
		System.out.println("t1.b = " + t1.b);
		System.out.println("t2.b = " + t2.b);
		System.out.println("t3.b = " + t3.b);
		System.out.println("Test.b = " + Test.b);

		t2.b = 50;

		System.out.println("--- static ���� ������ ---");
		System.out.println("t1.b = " + t1.b);	// 50
		System.out.println("t2.b = " + t2.b);	// 50
		System.out.println("t3.b = " + t3.b);	// 50
		System.out.println("Test.b = " + Test.b);

	}
}