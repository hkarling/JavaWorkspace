/**
 * 이름: 윤참솔
 * 날짜: 4월 30일
 * 주제: 성적구하기
 */
public class Transcript {
    public static void main(String[] args) {

        String name = "윤참솔";
        
        int korean = (int)(Math.random()*55+45);
        int english = (int)(Math.random()*55+45);
        int math = (int)(Math.random()*55+45);
        
        int total = korean + english + math;
        double average = (total * 100 / 3) / 100.0;
        char grade = 'F';

		switch((int)(average/10)){
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
		}

        System.out.println("이름: " + name);
        System.out.println("국어: " + korean + "\t영어: " + english + "\t수학: " + math);
        System.out.println("총점: " + total + "\t평균: " + average + "\t학점: " + grade);        
    }
}