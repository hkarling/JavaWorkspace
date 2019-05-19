package loop;

class WhileExam01 {
	public static void main(String[] args) {

		// 1 ~ 100까지 한줄로 출력

		int i = 1;

		while (i <= 100) {
			System.out.print(i + " ");
			i++;
		}
		System.out.println();

		// 1~100까지 10x10으로 출력 (while 안에 if)

		i = 1;

		while (i <= 100) {

			System.out.print(i + " ");

			if (i % 10 == 0)
				System.out.println();
			i++;
		}

		// 1~100까지 10x10 출력 (while 안에 while)

		i = 1;
		while (i <= 100) {
			int j = 0;
			while (j < 10) {
				System.out.print(i + " ");
				j++;
				i++;
			}
			System.out.println();
		}
	}
}