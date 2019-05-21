package ch09_5_2;

public class AnonymousExample {

	public static void main(String[] args) {

		Anonymous anon = new Anonymous();

		// 익명 객체 필드 사용
		anon.field.turnOn();

		// 익명 객체 로컬 변수 사용
		anon.method1();

		// 익명 객체 매개값 사용
		anon.method2(new RemoteControl() {

			@Override
			public void turnOn() {
				System.out.println("SmartTV를 켭니다.");
			}

			@Override
			public void turnOff() {
				System.out.println("SmartTV를 끕니다.");
			}
		});
	}

}
