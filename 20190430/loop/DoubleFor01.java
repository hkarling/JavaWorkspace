class DoubleFor01 {
	public static void main(String[] args) {
		
		for (int i = 0 ; i <= 5 ; i++) {		// 0 ~ 5 �ݺ�
			
			for (int j = 0 ; j < 3 ; j++) {		// 0, 1, 2 �ݺ�
			
				System.out.print(i + " ");
			}
			
			System.out.println();
		}

		System.out.println("1~100���� ��� 10x10");
		
		for (int i = 0 ; i < 10 ; i++) {

			for (int j = 1; j <= 10 ; j++){

				System.out.print(String.format("%02d ",i*10 + j));
			}

			System.out.println();
		}
	}
}