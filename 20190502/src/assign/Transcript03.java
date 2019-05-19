package assign;

import java.util.Scanner;

class Transcript03 {

	// 1) 국어, 영어, 수학 점수를 인수받아 총점을 구하여 총점을 리턴하는 메소드 작성 (접근제한자 private)
	private int total(int korean, int english, int math) {
		return korean + english + math;
	}

	// 2) 총점과 과목수를 인수로받아 평균을 구하여 평균을 리턴하는 메소드 작성 (접근제한자 private)
	private double average(int total, int subject) {
		return (total * 100 / 3) / 100.0;
	}

	// 3) 평균을 인수로 받아 등급을 구하여 등급을 리턴해주는 메소드 작성한다(접근제한자 private)
	private char grade(double average) {
		char ch = 'F';
		if (average >= 90)
			ch = 'A';
		else if (average >= 80)
			ch = 'B';
		else if (average >= 70)
			ch = 'C';
		else if (average >= 60)
			ch = 'D';

		return ch;
	}

	// 4) 이름, 국어, 영어, 수학 점수를 인수로 받아 총점, 평균, 등급 을 구하여 그 결과를 화면에 출력하는 메소드를 선언하세요.
	// (접근제한자 public, 총점과 평균, 등급은 이미 만들어진 1), 2) ,3) 메소드를 호출하여 그 결과를 통해 얻어온다)
	public void display(int korean, int english, int math) {

		int total = this.total(korean, english, math);
		double average = this.average(total, 3);
		char grade = this.grade(average);

		System.out.println("총점: " + total);
		System.out.println("평균: " + average);
		System.out.println("등급: " + grade);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수: ");
		int korean = sc.nextInt();
		System.out.print("수학 점수: ");
		int math = sc.nextInt();
		System.out.print("영어 점수: ");
		int english = sc.nextInt();

		sc.close();

		Transcript03 obj = new Transcript03();

		obj.display(korean, english, math);

	}
}

/*
 * 1. 성적구하는 기능을 담당하는 클래스
 * 
 * 1) 국어, 영어, 수학 점수를 인수받아 총점을 구하여 총점을 리턴하는 메소드 작성 (접근제한자 private)
 * 
 * 2) 총점과 과목수를 인수로받아 평균을 구하여 평균을 리턴하는 메소드 작성 (접근제한자 private)
 * 
 * 3) 평균을 인수로 받아 등급을 구하여 등급을 리턴해주는 메소드 작성한다(접근제한자 private)
 * 
 * 4) 이름, 국어, 영어, 수학 점수를 인수로 받아 총점, 평균, 등급 을 구하여 그 결과를 화면에 출력하는 메소드를 선언하세요.
 * (접근제한자 public, 총점과 평균 , 등급은 이미 만들어진 1) , 2) ,3) 메소드를 호출하여 그 결과를 통해 얻어온다)
 * 
 * ---------------------------------------------
 * 
 * 2. 메인 메소드가 있는 클래스를 선언한다. 메인 메소드를 작성하여 그 안에서 위의 1에서 만든 메소드중 성적을 출력하는 메소드를 호출하여
 * 성적결과를 확인한다. 조건) 국어,영어,수학 ,이름은 키보드 입력을 받는다.
 * 
 * -------------------------------------------
 * 
 * nextInt() -> nextInt() -> next() -- 정상 nextInt() -> nextInt() -> nextLine()
 * -- 비정상동작 nextLine() -> nextLine() -> nextLine() -- 정상
 */