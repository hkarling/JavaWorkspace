package assign;

class Questions {
	public static void main(String[] args) {

		/**
		 * for문을 이용하여 1 ~ 100까지의 정수 중에서 3의 배수의 총합을 구하세요. 결과 => 3의 배수의 합 : 1683
		 */
		System.out.println("1. for문을 이용하여 1 ~ 100까지의 정수 중에서 3의 배수의 총합을 구하세요.\n");

		int result = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0)
				result += i;
		}

		System.out.println("3의 총합 = " + result + "\n");

		/**
		 * Math.random()메소드를 이용해서 두개의 주사위를 던졌을 때 나오는 눈을 (눈1,눈2) 형태로 출력하고 눈의 합이 5이면 실행을
		 * 멈춘다. (난수는 2개 발생 / 1 ~ 6) 결과 => (2,4) (3,1) (3,2)
		 */
		System.out.println("2. Math.random()메소드를 이용해서 두개의 주사위를 던졌을 때 나오는 눈을 (눈1,눈2) 형태로 출력하고 눈의 합이 5이면 실행을 멈춘다.\n");

		for (;;) {
			int a = (int) (Math.random() * 6 + 1);
			int b = (int) (Math.random() * 6 + 1);

			System.out.println("[ " + a + ", " + b + " ]");

			if (a + b == 5)
				break;
		}

		/**
		 * 중첩 for문을 이용하여 방정식 4x + 5y = 60의 모든 해를 구해서 (x,y)형태로 출력하세요. 단, x와y는 10 이하의 자연수
		 * 이다. 결과 => (5,8) (10,4)
		 */
		System.out.println("\n3. 중첩 for문을 이용하여 방정식 4x + 5y = 60의 모든 해를 구해서 (x,y)형태로 출력하세요. 단, x와y는 10 이하의 자연수 이다.\n");

		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if ((x * 4 + y * 5) == 60)
					System.out.println("(" + x + ", " + y + ")");
			}
		}
		/**
		 * 2중 for문을 이용하여 구구단을 출력. 2 * 1 = 2 3 * 1 = 3 ... 9 * 1 = 9 2 * 2 = 4 3 * 2 = 6
		 * ... ... 2 * 9 = 18
		 */
		System.out.println("\n4. 2중 for문을 이용하여 구구단을 출력\n");

		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.print(j + " * " + i + " = " + (i * j) + "\t");
			}
			System.out.println();
		}

	}
}