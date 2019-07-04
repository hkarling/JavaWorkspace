package ex0430.casting;

class CastingExam {

	// 실행을 위해서 반드시 필요한 메인메소드
	public static void main(String[] args) {
		byte b1;
		byte b2, b3;
		int i1 = 7;
		System.out.println("int i1=" + i1);

		b1 = (byte) i1;// 4byte를 byte공간에 담을수 없다.- 형변환필요
		System.out.println("byte b1=" + b1);

		b2 = 20;
		System.out.println("byte b2=" + b2);

		b3 = (byte) (b2 + b1);// 연산을 하면 최소한 4byte공간이필요하기때문에 byte끼리 연산결과는 int된다.

		System.out.println("byte b3=" + b3);

		long lo = 56897L;
		System.out.println("long lo=" + lo);

		// int i4 = (int)(lo+i1);
		int i4 = (int) lo + i1;
		System.out.println("int i4=" + i4);

		boolean boo;
		boo = false; // 논리형은 반드시 true or false의 값만 허용한다.

		System.out.println("boolean boo=" + boo);

		double d = 4.67e-3;// 0.00467
		System.out.println("double d=" + d);

		float f1 = lo; // long < float < double
		System.out.println("float f1=" + f1);

		float f2 = (float) d;
		System.out.println("float f2=" + f2);

		char c1, c2, c3;
		c1 = '\u0041';
		System.out.println("char c1=" + c1);

		b2 = (byte) c1;
		System.out.println("byte b2=" + b2);

		c2 = 'A'; // 가 + 2 => 갂
		System.out.println("char c2=" + c2);

		c3 = (char) (c2 + 2); // '가' + 2 "가"+2
		System.out.println("char c3=" + c3);

	}// 메인메소드

}// 클래스끝