package lab;
/**
 * 쇼핑몰 클래
 */
public class ShoppingMall {

	// 나이를 체크하는 메소드
	void checkAge(int age) throws TooYoungException {
		if(age < 18) {
			// 18세 이하면 예외처리를 던져라
			throw new TooYoungException();
		}
	}	
}