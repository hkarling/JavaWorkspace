class StaticInitExam {
	int no;

	public static void main(String[] args) {
		System.out.println("**** Main ���� ****");
	}

	/**
	 * ���� ������ �ʱ�ȭ, ȯ�漳������ ����, DB�ε�, �����͵� �ε�	
	 */
	static {
		System.out.println("**** static ���: main �޼ҵ庸�� ���� ����ȴ� ****");
		//System.out.println(no);		// non-static ����� ���ٺҰ�
	}
}