class IfExam01 {
	//실행을 위해서 필요한 메인메소드작성
	public static void main(String[] args) {
		// 임의의 정수형 변수를 선언하고 값을 할당한다.
		int a = (int)(Math.random()*6);
		
		// 선언한 변수의 값이 짝수인지 홀수인지 출력한다.
		if (a%2 == 0) { // 숫자를 2로 나눈 나머지가 0이면
			System.out.println(a + "는 짝수입니다.");
		} else {
			System.out.println(a + "는 홀수입니다.");
		}
	}
}