package loop;

class DoWhileExam01 {
	// 실행을 위한 메인메소드 작성
	public static void main(String[] args) {

		// 1. 1 ~ 100까지 한 줄로 출력
		System.out.println("1. 1 ~ 100까지 한 줄로 출력");
		int i = 1;
		do {
			System.out.print(i + " ");
			i++;
		} while (i <= 100);
		System.out.println();

		// 2. A ~ Z까지 한 줄로 출력
		System.out.println("\n2. A ~ Z까지 한 줄로 출력");
		char c = 'A';
		do {
			System.out.print(c + " ");
			c++;
		} while (c <= 'Z');
		System.out.println();

		// 3. 1~ 100까지 10행 10열로 출력 (do-while문 안에 if문 이용)
		System.out.println("\n3. 1~ 100까지 10행 10열로 출력 (do-while문 안에 if문 이용)");
		i = 1;
		do {
			System.out.print(i + "\t");
			if (i % 10 == 0)
				System.out.println();
			i++;
		} while (i <= 100);

		// 4. 1 ~ 100까지 10행 10열로 출력 (do-while문 안에 do-while문)
		System.out.println("\n4. 1 ~ 100까지 10행 10열로 출력 (do-while문 안에 do-while문)");
		i = 0;
		do {
			do {
				i++;
				System.out.print(i + " ");
			} while (i % 10 != 0);

			System.out.println();
		} while (i < 100);

		// 5. 구구단
		System.out.println("\n5. 구구단");
		i = 1; // 행
		do {
			int j = 2; // 열
			do {
				System.out.print(j + " * " + i + " = " + (i * j) + "\t");
				j++;
			} while (j <= 9);

			System.out.println();
			i++;
		} while (i <= 9);
	}
}