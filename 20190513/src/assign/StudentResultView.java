package assign;

public class StudentResultView {

    // 전체출력
    public static void printAll(Student[] students) {
        System.out.println("\n***** Student LIST(" + StudentService.count + ")*****");
        for (int i = 0; i < StudentService.count; i++) {
            System.out.print("번호: " + students[i].getStudentNumber() + "\t");
            System.out.print("이름: " + students[i].getName() + "\t");
            System.out.print("나이: " + students[i].getAge() + "\t");
            System.out.println("주소: " + students[i].getAddress());
        }
    }
    // 부분출력
    public static void printSingle(Student student) {
        System.out.println("\n***** Student #" + StudentService.count + " *****");
        System.out.print("번호: " + student.getStudentNumber() + "\t");
        System.out.print("이름: " + student.getName() + "\t");
        System.out.print("나이: " + student.getAge() + "\t");
        System.out.println("주소: " + student.getAddress());
    }
    // 메시지
    
    public static void printMessage(String message) {
        System.out.println(message);
    }
}