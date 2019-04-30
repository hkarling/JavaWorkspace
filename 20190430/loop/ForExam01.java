class ForExam01 {
	public static void main(String[] args) {

		// 1. 1~100���� ���ٷ� ���;
		
		for(int i = 1 ; i <= 100 ; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();

		// 2. �빮�� A~Z���� ���ٷ� ���;

		for(int i = 0 ; i < 26 ; i++) {
			System.out.print((char)('A' + i) + " ");
		}

		System.out.println();
		
		for(char c = 'A' ; c <= 'Z'; c++) {
			System.out.print(c + " ");
		}

		System.out.println();

		// 3. 1~10������ ���� ���;
		
		int result = 0;
		
		for(int i = 1 ; i <= 10 ; i++) {
			result += i;
		}
		
		System.out.println("1~10 ��: " + result);

		// 4. 1~100���� 10�� 10���� ���;
		
		for (int i = 1 ; i <= 100 ; i++) {
			
			System.out.print(i + " ");
			
			if(i%10 == 0 && i != 100)
				System.out.println();
		}
	}
}