class IfExam01 {
	//������ ���ؼ� �ʿ��� ���θ޼ҵ��ۼ�
	public static void main(String[] args) {
		// ������ ������ ������ �����ϰ� ���� �Ҵ��Ѵ�.
		int a = (int)(Math.random()*6);
		
		// ������ ������ ���� ¦������ Ȧ������ ����Ѵ�.
		if (a%2 == 0) { // ���ڸ� 2�� ���� �������� 0�̸�
			System.out.println(a + "�� ¦���Դϴ�.");
		} else {
			System.out.println(a + "�� Ȧ���Դϴ�.");
		}
	}
}