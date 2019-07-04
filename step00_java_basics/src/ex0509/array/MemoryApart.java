package ex0509.array;

class MultiArray {
	// 정수형 2차원 배열 8*9
	int[][] timesTable = new int[8][9];

	// 메소드이름 :array99
	public void array99() {
		// for loop 를 사용하여 배열에 곱한 (구구단) 결과 저장
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 9; j++) {
				timesTable[i][j] = (i + 2) * (j + 1);
			}
		}
		// 배열에 결과를 꺼내출력
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print((i + 2) + " * " + (j + 1) + " = " + timesTable[i][j] + "\t");
			System.out.println();
		}
	}
}

public class MemoryApart {
	// main메소드에서
	public static void main(String[] args) {
		// MultiArray객체의 array99메소드호출
		new MultiArray().array99();
	}
}
