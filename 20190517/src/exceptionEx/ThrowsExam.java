package exceptionEx;

class Test {
	
	public void aa(int i) {
		System.out.println("Test의 aa(int i) 호출.");

//		try {

		this.bb(i);

//		} catch (ArithmeticException e) {
//			e.printStackTrace();
//		}

		System.out.println("Test의 aa(int i) 호출끝.");
	}

	public void bb(int i) {
		System.out.println("Test의 bb(int i) 호출.");
		int re;
		try {
			re = 100 / i;
		} finally {
			System.out.println("무조건 실행해라.");
		}
		System.out.println("나눈결과: " + re);
		System.out.println("Test의 bb(int i) 호출끝.");
	}
}

//////////////////////////////////////////////////////////////////////

public class ThrowsExam {

	public static void main(String[] args) {
		Test t = new Test();
		try {
			t.aa(0);
		} catch (ArithmeticException e) {
			System.out.println("오류발생했음: " + e);
		}
		System.out.println("----- 메인 끝 -----");
	}
}
