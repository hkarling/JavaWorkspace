package lab;
/**
 * 사용자 예외처리 클래
 */
@SuppressWarnings("serial")
public class TooYoungException extends Exception {
	
	// 예외처리 횟수 담아놓을 변수
	public static int count = 0;
	
	// 생성자 
	public TooYoungException() {
		super("애들은 가라");
		count++;
	}
}