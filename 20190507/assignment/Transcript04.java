
/**
 * 이름: 윤참솔
 * 날짜: 5월 7일
 * 주제: 성적구하기 4일차
 */
import java.util.Scanner;

/*
 * 1. 성적구하는 기능을 담당하는 클래스 
 */
class Calculation {
	// 1) 국어, 영어, 수학 점수를 인수받아 총점을 구하여 총점을 리턴하는 메소드 작성
	private int total(int korean, int english, int math) {
		return korean + english + math;
	}

	// 2) 총점과 과목수를 인수로받아 평균을 구하여 평균을 리턴하는 메소드 작성
	private double average(int total, int subjects) {
		return (total * 100 / subjects) / 100.0;
	}

	// 3) 평균을 인수로 받아 등급을 구하여 등급을 리턴해주는 메소드 작성
	private char grade(double average) {

		char result = 'F';

		if (average >= 90)
			result = 'A';
		else if (average >= 80)
			result = 'B';
		else if (average >= 70)
			result = 'C';
		else if (average >= 60)
			result = 'D';

		return result;
	}

	// 4) 이름, 국어, 영어, 수학 점수를 인수로 받아 총점, 평균, 등급을 구하여 그 결과를
	// 화면에 출력하는 메소드를 선언하세요.
	public void display(String name, int korean, int english, int math) {

		int total = this.total(korean, english, math);
		double average = this.average(total, 3);
		char grade = this.grade(average);

		System.out.println("\n----- 결과 -----");
		System.out.println("이름: " + name);
		System.out.println("국어: " + korean + "\t영어: " + english + "\t수학: " + math);
		System.out.println("총점: " + total + "\t평균: " + average + "\t등급: " + grade);
	}
}

/*
 * 2. 메인 메소드가 있는 클래스를 선언한다. 메인 메소드를 작성하여 그 안에서 위의 1에서 만든 메소드 중 성적을 출력하는 메소드를
 * 호출하여 성적결과를 확인한다. 조건) 국어, 영어, 수학, 이름은 키보드 입력을 받는다.
 */
class Transcript04 {
	public static void main(String[] args) {

		int korean;
		int english;
		int math;
		String name;

		Scanner sc = new Scanner(System.in);

		System.out.print("이름: ");
		name = sc.next();
		System.out.print("국어: ");
		korean = sc.nextInt();
		System.out.print("영어: ");
		english = sc.nextInt();
		System.out.print("수학: ");
		math = sc.nextInt();

		sc.close();

		Calculation obj = new Calculation();
		obj.display(name, korean, english, math);
	}
}