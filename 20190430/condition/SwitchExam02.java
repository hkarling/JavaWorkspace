class SwitchExam02 {
	public static void main(String[] args) {
		// ������ 1~12���̸� �߻��ϰ�
		// �߻��� ���ڿ� �ش��ϴ� ���� ���������� ���Ѵ�.
		// ex) 5���� 5�� 31�ϱ����Դϴ�.

		/*
			31��: 1, 3, 5, 7, 8, 10, 12
			30��: 4, 6, 9, 11
			28��: 2
		*/

		int random = (int)(Math.random() * 12 + 1);
		int days = 0;

		switch (random) {
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			case 2:
				days = 28;
				break;
			default:
				days = 31;
		}
		System.out.println(random + "���� " + random + "�� " + days + "�ϱ��� �Դϴ�.");

		//////////////////////////////////////////////////
		// ���� switch���� if������ �����Ͻÿ�.

		if (random == 2)
			days = 28;
		else if (random == 4 || random == 6 || random == 9 || random == 11)
			days = 30;
		else
			days = 31;
		
		System.out.println(random + "���� " + random + "�� " + days + "�ϱ��� �Դϴ�.");
	}
}