package ex0508.array;

class ArrayExam {
	// 각int,double,char,boolean ,String type별로 총 5개씩 저장하는 배열을 생성하세요
	int[] arrInt = new int[5];
	double[] arrDouble = new double[5];
	char[] arrChar = new char[5];
	boolean[] arrBool = new boolean[5];
	String[] arrStr = new String[5];

	// 메소드 : printArrayValue01
	// 위의 배열들에 자동으로 초기화 된값을 출력하세요
	public void printArrayValue01() {

		// foreach 문법
		for (int i : arrInt) {
			System.out.print(i + " ");
		}

		System.out.println();

		for (int i = 0; i < 5; i++) {
			System.out.print(arrInt[i]);
			System.out.print("\t");
			System.out.print(String.format("%.5f", arrDouble[i]));
			System.out.print("\t");
			System.out.print(arrChar[i]);
			System.out.print("\t");
			System.out.print(arrBool[i]);
			System.out.print("\t");
			System.out.print(arrStr[i]);

			System.out.println();
		}
	}

	// 메소드 : printArrayValue02
	// 위의 5개의 배열에서 각각 적당한 값으로 data를 할당하세요.
	public void printArrayValue02() {

		// arrInt = { 2, 3, 4, 5, 6 } - 불가능
		// int arrInt[] = { 2, 3, 4, 5, 6 } - 지역변수
		// arrInt = new Int[] { 2, 3, 4, 5, 6 } - 새로운 배열주소 할당
		for (int i = 0; i < 5; i++) {
			arrInt[i] = (int) (Math.random() * 5);
			arrDouble[i] = Math.random() * 50 + 10;
			arrChar[i] = (char) (Math.random() * 26 + 65);
			if (Math.random() > .5)
				arrBool[i] = true;
			arrStr[i] = String.format("문자열:%d", i);
		}
	}

	// 메소드 : printArrayValue03
	// 새롭게 할당된값을 출력하세요
	public void printArrayValue03() {
		System.out.println("--- 값 변경 후 ---");
		this.printArrayValue01();
	}

	// 메인메소드에서
	// ArrayExam의 메소드들을 순서대로 호출하세요.
	public static void main(String[] args) {
		ArrayExam obj = new ArrayExam();
		obj.printArrayValue01();
		obj.printArrayValue02();
		obj.printArrayValue03();
	}
}