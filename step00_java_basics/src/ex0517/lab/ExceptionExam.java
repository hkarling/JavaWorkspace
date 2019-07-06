package ex0517.lab;

import java.util.Random;

/**
 * 실행 클래스
 */
public class ExceptionExam {

	public static void main(String[] args) {
		
		// 10회 반복
		for (int i = 0; i < 10; i++) {
			try {
				// 쇼핑몰 클래스의 메서드를 호출 (난수 발생)
				new ShoppingMall().checkAge(new Random().nextInt(55)+1);
				
				// 문제없으면 여기로 계속 이어진다.
				System.out.println("입장하신것을 환영합니다.");

			} catch (TooYoungException e) {
				// 예외가 발생하면 여기
				System.out.println(e.getMessage());
				// 예외처리 횟수 증가
				TooYoungException.count++;
			}
		}
		
		// 횟수 출력
		System.out.println("예외처리 갯수: " + TooYoungException.count);
	}
}