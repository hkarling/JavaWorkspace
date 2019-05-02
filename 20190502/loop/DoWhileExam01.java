class DoWhileExam01 {
	// ������ ���� ���θ޼ҵ� �ۼ�
	public static void main(String[] args){
		
		// 1. 1 ~ 100���� �� �ٷ� ���		
		System.out.println("1. 1 ~ 100���� �� �ٷ� ���");
		int i = 1;
		do {
			System.out.print(i + " ");
			i++;
		} while (i <= 100);		
		System.out.println();

		// 2. A ~ Z���� �� �ٷ� ���
		System.out.println("\n2. A ~ Z���� �� �ٷ� ���");
		char c = 'A';
		do {
			System.out.print(c + " ");
			c++;
		} while (c <= 'Z');
		System.out.println();

		// 3. 1~ 100���� 10�� 10���� ��� (do-while�� �ȿ� if�� �̿�)
		System.out.println("\n3. 1~ 100���� 10�� 10���� ��� (do-while�� �ȿ� if�� �̿�)");
		i = 1;
		do {
			System.out.print(i + "\t");
			if(i%10 == 0)
				System.out.println();
			i++;
		} while (i <= 100);

		// 4. 1 ~ 100���� 10�� 10���� ��� (do-while�� �ȿ� do-while��)	
		System.out.println("\n4. 1 ~ 100���� 10�� 10���� ��� (do-while�� �ȿ� do-while��)");
		i = 0;
		do {
			do {
				i++;
				System.out.print(i+ " ");
			} while (i%10 != 0);
			
			System.out.println();
		} while (i < 100);


		// 5. ������
		System.out.println("\n5. ������");
		i = 1; //��
		do {
			int j = 2; //��
			do {
				System.out.print(j + " * " + i + " = " + (i*j) + "\t" );
				j++;
			} while (j<=9);

			System.out.println();
			i++;
		} while (i<=9);
	}
}