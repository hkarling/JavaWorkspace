package exceptionEx;

/**
 * Exception이란: 예기치 못한 예외가 발생하여 프로그램이 강제 종료되는것을 미리 예측하여 예방하는 것.
 * - 예외의 종류	 1) 체크Exception : 컴파일할때 반드시 예외처리를 해야한다. 
 *					2) 비체크 Exception : 실행할때 발생하는 예외로 예외처리를 선택적으로 할 수 있다. (RuntimeException)
 */

public class ExceptionExam {

	public static void main(String[] args) {

		System.out.println("---------- 메인시작 ----------");

		try {

			String data = args[0];
			System.out.println("data = " + data);

			int no = Integer.parseInt(data);
			System.out.println("변환값: " + no);

			int result = 100 / no;
			System.out.println("나눈 결과: " + result);

		} catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {

			// 예외가 발생했을때 해야할 일을 작성
			// ex변수를 출력하면, '예외클래스:예외메시지' 형식으로 출력된다.
			System.out.println("실행할때 인수를 넣어라. ex: " + ex);

		} catch (NumberFormatException ex) {

			System.out.println("숫자.. 넣으라고.. ex: " + ex.getMessage());

			// catch블럭을 여러개 작성할 때는 sub exception부터 작성한다.
		} catch (Exception ex) {
			
			System.out.println("예외발생..");
			ex.printStackTrace(); // 예외의 정보를 가장 디테일하게 출력. 배포시에는 제거한다.
		
			// finally 는 exception 블록이 없더라도 실행은 된다.
		} finally {
			
			System.out.println("finally 블록: 예외발생 여부와 상관없이 무조건 실행");
		}

		System.out.println("---------- 메인 끝 ----------");
	}
}
