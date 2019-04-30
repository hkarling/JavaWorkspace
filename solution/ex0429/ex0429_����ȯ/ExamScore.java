/**
 이름 : 오동환
 날짜 : 2019. 04. 29
 주제 : 성적구하기
*/

class ExamScore{
	public static void main(String args[]){
	
	    //변수선언과 동시에 값할당.
		String str = "Oh dong hwan";

		//변수선언
		int korean, english, math;
		int sum;
		double avr;
		char grade;

        //각각의 점수를 할당(대입)
		korean = 87;
		english = 91;
		math = 100; //
		
		//총점
		sum = korean + english + math;
		
		//평균구하기
		avr = sum/3.0; //92.6666667

		//소수점 3자리 표현
		avr = ( (int)(avr*100) ) /100.0;//92.66
		
		//삼항연산자
		grade = avr>=90 ? 'A':'F';
		
		
		
		System.out.println("Name :: "+str);
		System.out.println("Korean Score :: "+korean);
		System.out.println("English Score :: "+english);
		System.out.println("Math Score :: "+math);
		System.out.println("Sum :: "+sum);
		System.out.println("Average :: "+avr);
		System.out.println("Your Grade is :: "+grade);
	}	
}