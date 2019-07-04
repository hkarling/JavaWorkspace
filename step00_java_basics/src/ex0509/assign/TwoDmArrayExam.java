package ex0509.assign;

/**
 * 주제: 동호레이아웃 출력
 */
class TwoDmArray {
	// String을 저장하는 twoDmArray 배열선언
	String[][] arrStr = new String[10][];

	// 메소드 make2DmArray: twoDmArray 배열에 값을 할당
	public void make2DmArray() {
		for (int i = 0; i < 10; i++) {
			arrStr[i] = new String[i + 1];
			for (int j = 0; j < arrStr[i].length; j++) {
				arrStr[i][j] = (i + 1) + "동" + (j + 1) + "호";
				// arrStr[i][j] = String.format("%d동%2d호", (i + 1), (j + 1));
			}
		}
	}

	// 메소드 print2DmArray: twoDmArray 배열의 값을 주어진형식으로 출력
	public void print2DmArray() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("       "); // 빈 칸 출력
			}
			for (int j = i; j < 10; j++) {
				System.out.print(arrStr[j][i] + " "); // 행과 열을 바꿔서 출력
			}
			System.out.println();
		}
	}
}

public class TwoDmArrayExam {
	// main메소드에서
	public static void main(String[] args) {
		// TwoDmArray객체 생성
		TwoDmArray obj = new TwoDmArray();

		// TwoDmArray객체의 make2DmArray메소드 호출
		obj.make2DmArray();

		// TwoDmArray객체의 print2DmArray메소드 호출
		obj.print2DmArray();
	}
}
