class WhileExam01 {
	public static void main(String[] args){
		
		// 1 ~ 100���� ���ٷ� ���

		int i = 1;

		while(i <=100) { System.out.print(i+ " "); i++; } System.out.println();

		// 1~100���� 10x10���� ��� (while �ȿ� if)

		i = 1;

		while(i<=100) {

			System.out.print(i+ " ");
			
			if(i%10 == 0)
				System.out.println();
			i++;
		}
		
		// 1~100���� 10x10 ��� (while �ȿ� while)

		i = 1;
		while(i<=100) {
			int j = 0;
			while(j < 10){
				System.out.print(i+ " ");
				j++;
				i++;
			}
			System.out.println();
		}
	}
}