package ex0502.assign;

class Star {
	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println("****************************");

		for (int i = 1; i <= 5; i++) {
			for (int j = i; j <= 5; j++) {
				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println("****************************");

		for (int i = 1; i <= 5; i++) {
			for (int j = i; j < 5; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println("****************************");

		/*
		 * Row: 1 2 3 4 5 spa: 0 1 2 3 4 Row-1 sta: 5 4 3 2 1 5-Row
		 */
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print("  ");
			}
			for (int j = i; j <= 5; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}
}