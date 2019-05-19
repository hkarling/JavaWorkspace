package assign;

public class Transcript {
    public static void main(String[] args) {

        String name = "아무개";

        int korean = 90;
        int english = 90;
        int math = 89;

        int total = korean + english + math;
        double average = (total * 100 / 3) / 100.0;
        char grade = (average >= 90) ? 'A' : 'F';

        System.out.println("Name: " + name);
        System.out.println("Korean: " + korean + "\tEnglish: " + english + "\tMath: " + math);
        System.out.println("Total: " + total + "\tAverage: " + average + "\tGrade: " + grade);
    }
}