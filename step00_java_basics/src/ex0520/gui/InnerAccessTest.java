package ex0520.gui;

/**
 * Inner클래스의 형태 정리 - 선언 위치에 따라 3가지 1. 인스턴스 멤버클래스 2. 정적멤버클래스 3. 로컬 이너클래스(메소드 내부에
 * 선언)
 */
class Test {
	int a = 50;
	static int b = 10;
	int f = 7;
	
	public void testMethod() {

	}

	public static void testMethod2() {

	}

	/** 인스턴스멤버 클래스 : access modifier 모두 가능하다. */
	class InstanceInner {
		/** 내부클래스에선 static 멤버를 사용할 수 없다. */
		/** 내부클래스에선 static, non-static 모두 접근(호출)가능하다. */
		int a = 100;

		// static int b = 30;
		public void aa() {
			System.out.println(a);
			System.out.println(this.a);
			System.out.println(Test.this.a);
			System.out.println(b);
//			System.out.println(this.b);
			System.out.println(Test.this.b);

			testMethod();
			testMethod2();
		}

		// public void bb() { }
	}

	/** 정적멤버클래스 - static : access modifier 모두 가능하다 */
	/* private */ static class StaticInner {
		/** outer쪽의 non-static 접근(호출)불가, static만 가능하다. */
		int a = 5;
		static int c = 30;
		

		public void aa() {
			System.out.println(a);	// inner class의 a
			System.out.println(b);	// outer class의 static b

//			System.out.println(f);
			
			System.out.println(this.a);	// inner class의 a

//			System.out.println(Test.this.a);	// outer의 non-static a
			System.out.println(Test.b);	// outer의 static b
			
//			testMethod();	// non-static 접근불가 
			testMethod2();
		}

		public static void bb() {

		}
	}
	/** 로컬이너클래스 (메소드 내부에 선언) */
	public void ff() {
		/** access modifier, static 모두 사용불가. local variable 취급, 외부에서 사용불가 */
		class LocalInner {
//			int sum = 8;
			public void aa() {
				System.out.println(a);	// outer의 non-static 접근가능
				System.out.println(b);	// outer의 static 접근가능
			}
		}
		
		LocalInner localInner = new LocalInner();
		localInner.aa();
	}
}

////////////////////////////////////////////////////////////////////

public class InnerAccessTest {

	public static void main(String[] args) {

//		System.out.println("1. 인스턴스멤버 Inner클래스");
//		Test test = new Test();
//		Test.InstanceInner ti = test.new InstanceInner();
//
//		ti.aa();
		
//		System.out.println("2. 정적멤버 Inner클래스");
//		Test.StaticInner ts = new Test.StaticInner();
//		ts.aa();
		
		System.out.println("3. 로컬 Inner클래스");
		Test test = new Test();
		test.ff();
	}
}
