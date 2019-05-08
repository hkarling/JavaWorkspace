//TwoDmArrayExam.java

class TwoDmArray {
	// String을 저장하는 twoDmArray 배열선언
	String[][] arrStr = new String[2][3];

	// 메소드 make2DmArray
	public void arrAllocate() {
		// twoDmArray 배열에 값을 할당
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				arrStr[i][j] = "(" + i + ", " + j + ")";
			}
		}
	}

	// 메소드 print2DmArray
	// twoDmArray 배열의 값을 주어진형식으로 출력
	public void arrPrint() {
		for (String[] arrStrings : arrStr) {
			for (String str : arrStrings) {
				System.out.print(str + "  ");
			}
			System.out.println();
		}
	}
}

public class TwoDmArrayExam {
	// main메소드에서
	public static void main(String[] args) {
		// TwoDmArray객체생성
		TwoDmArray obj = new TwoDmArray();

		// TwoDmArray객체의 make2DmArray메소드 호출
		obj.arrAllocate();

		// TwoDmArray객체의 print2DmArray메소드 호출
		obj.arrPrint();
	}
}
