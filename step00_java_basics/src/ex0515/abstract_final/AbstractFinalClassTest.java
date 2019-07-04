package ex0515.abstract_final;
//Error 를 수정하고 이유를 주석으로 처리하세요.

final class FinalClassExam { // 상속은 안되고 생성은 됨
	final int i = -999999;
}

abstract class AbstractClassExam { // 상속은 가능 생성이 안됨
	abstract String abstractMethodExam(int i, String s);

	final int finalMethodExam(int i, int j) {	//재정의 안됨.
		return i + j;
	}
}

class Sample01 extends AbstractClassExam {
	String abstractMethodExam(int i, String s) {
		System.out.println("return " + s + i);
		return s + i;
	}

	// 재정의 안됨.
//	int finalMethodExam(int i, int j) {
//		return i * j;
//	}

}

// Final클래스 상속불가
//class Sample02 extends FinalClassExam {
//}

class Sample03 extends AbstractClassExam {
	String abstractMethodExam(int i, String s) {
		return s + i;
	}
	
	// abstract 클래스를 상속받을때는 모든 abstract 메소드를 재정의 해야한다.
	//abstract String abstractMethodExam(int i, String s);

	void sampleMethod03() {
		System.out.println("void sampleMethod03() 호출 됨");
	}
}

class AbstractFinalClassTest {
	public static void main(String args[]) {
//		AbstractClassExam ace = new AbstractClassExam();	// 객체생성불가
		FinalClassExam fce = new FinalClassExam();
//		fce.i = 100000;	// final 변수변경불
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		aceS01.abstractMethodExam(700, "_999");
	}
}
