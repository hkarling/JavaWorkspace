/**
 * 이름: 윤참솔
 * 날짜: 4월 30일
 * 주제: 별찍기
 */
class Star {
	public static void main(String[] args){
		
		for (int i = 1 ; i <= 5 ; i++) {
			for (int j = 0; j < i ; j++) {
				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println("****************************");

		for (int i = 5 ; i > 0 ; i--) {
			for (int j = 0 ; j < i ; j++) {
				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println("****************************");

		for (int i = 1 ; i <= 5 ; i++) {
			for (int j = 0 ; j < 5-i ; j++) {
				System.out.print("  ");
			}
			for (int j = 0; j < i ; j++) {
				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println("****************************");

		for (int i = 5 ; i > 0 ; i--) {
			for (int j = 5 ; j > i ; j--) {
				System.out.print("  ");
			}
			for (int j = 0 ; j < i ; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}
}