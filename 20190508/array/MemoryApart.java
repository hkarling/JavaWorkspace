class MultiArray {
	// 정수형 2차원 배열 8*9
	int[][] timesTable = new int[9][8];

	// 메소드이름 :array99
	public void array99() {
		// for loop 를 사용하여 배열에 곱한 (구구단) 결과 저장
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 8; j++) {
				timesTable[i][j] = (i + 1) * (j + 2);
			}
		}
		// 배열에 결과를 꺼내출력
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 8; j++)
				System.out.print((j + 2) + " * " + (i + 1) + " = " + timesTable[i][j] + "\t");
			System.out.println();
		}
	}
}

public class MemoryApart {
	// main메소드에서
	public static void main(String[] args) {
		// MultiArray객체의 array99메소드호출
		MultiArray obj = new MultiArray();
		obj.array99();
	}
}
