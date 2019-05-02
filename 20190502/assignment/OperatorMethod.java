import java.util.Scanner;
/**
 * 이름: 윤참솔
 * 날짜: 5월 2일
 * 주제: 연산기호 메소드
 */

class OperatorMethod {
	static void oper(int i, int j, char ch) {
		
		double result = 0;

		switch (ch){
			case '+':
				result = i + j;
				break;
			case '-':
				result = i - j;
				break;
			case '*':
				result = i * j;
				break;
			case '/':
				if(j != 0)
					result = i / j;
				break;
		}
		System.out.println(i + " " + ch + " " + j + " = " + result);
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 숫자: ");
		int i = sc.nextInt();
		
		System.out.print("두첫번째 숫자: ");
		int j = sc.nextInt();

		System.out.print("연산기호: ");
		char ch = sc.next().charAt(0);

		if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
			oper(i, j, ch);
		else
			System.out.println("연산기호를 제대로 입력해라.");

	}
}

/*
	문제 :	두개의 정수와 연산기호(+, -,*,/,%)를 전달 받아서(인수) 전달된 연산기호에 따라 두수를 연산하여 
			결과를 출력하는 메소드와 이메소드를호출하는 메인메소드를 정의해보세요.
			(조건 : 연산기호가 (+, -,*,/,%) 이외의 값이 들어오면 오류메시지 출력한다. )
			조건 ) 인수로 전달 될 두수와 기호는 키보드입력으로 받아서 전달한다.
*/