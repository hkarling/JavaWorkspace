/**
 * 이름: 윤참솔
 * 날짜: 5월 8일
 * 주제: 수업과제
 */
public class EncapsulationExam {
    private int password = 1234;
    private int weight = 80;

    // 몸무게 검색하는 메소드
    public void getWeight(int password) {
        if(this.isPassword(password))
            System.out.println("몸무게: " + weight);
        else
            System.out.println("비밀번호 불일치");
    }

    // 몸무게를 변경하는 메소드
    public void setWeight(int password, int weight) {
        if(this.isPassword(password))
            this.weight = weight;
    }
    // 비밀번호를 변경하는 메소드
    public void getPassword(int oldPassword, int newPassword) {
        if(this.isPassword(oldPassword))
            this.password = newPassword;
    }
    // 비밀번호를 체크하는 메소드
    private boolean isPassword(int password) {
        if(this.password == password)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        if(args.length == 0) {      // 실행시 인자가 없는 경우
            System.out.println("인수를 입력하시오.");
            System.exit(0);
        }
        EncapsulationExam obj = new EncapsulationExam();
        int selection = Integer.parseInt(args[0]);

        if(selection == 1) {            // args 첫 인자가 1인 경우
            obj.print();
            obj.setWeight(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            obj.print();
        } else if(selection == 2) {     // args 첫 인자가 2인 경우
            obj.getWeight(Integer.parseInt(args[1]));
        } else if(selection == 3) {     // args 첫 인자가 3인 경우
            obj.print();
            obj.getPassword(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            obj.print();
        } else {
            System.out.println("값을 제대로 입력하시오.");
        }
    }

    // 필드를 출력
    public void print(){
        System.out.println("비밀번호: " + this.password + "\t몸무게: " + this.weight);
    }
}