class SwitchExam02 {
	public static void main(String[] args) {
		// 난수를 1~12사이를 발생하고
		// 발생한 숫자에 해당하는 월일 마지막일을 구한다.
		// ex) 5월은 5월 31일까지입니다.

		/*
			31일: 1, 3, 5, 7, 8, 10, 12
			30일: 4, 6, 9, 11
			28일: 2
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
		System.out.println(random + "월은 " + random + "월 " + days + "일까지 입니다.");

		//////////////////////////////////////////////////
		// 위의 switch문을 if문으로 변경하시오.

		if (random == 2)
			days = 28;
		else if (random == 4 || random == 6 || random == 9 || random == 11)
			days = 30;
		else
			days = 31;
		
		System.out.println(random + "월은 " + random + "월 " + days + "일까지 입니다.");
	}
}