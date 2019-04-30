class DoubleFor01 {
	public static void main(String[] args) {
		
		for (int i = 0 ; i <= 5 ; i++) {		// 0 ~ 5 반복
			
			for (int j = 0 ; j < 3 ; j++) {		// 0, 1, 2 반복
			
				System.out.print(i + " ");
			}
			
			System.out.println();
		}

		System.out.println("1~100까지 출력 10x10");
		
		for (int i = 0 ; i < 10 ; i++) {

			for (int j = 1; j <= 10 ; j++){

				System.out.print(String.format("%02d ",i*10 + j));
			}

			System.out.println();
		}
	}
}