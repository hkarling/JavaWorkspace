package assign;

import java.util.Scanner;

public class StudentMenuView {
    Scanner sc = new Scanner(System.in);
    StudentController controller = new StudentController();

    public StudentMenuView() {
        printMenu();
    }

    public void printMenu() {
        while (true) {
            System.out.println("\n********** 메뉴 **********");
            System.out.print("1. 등록\t");
            System.out.print("2. 전체검색\t");
            System.out.print("3. 부분검색\t");
            System.out.print("4. 수정하기\t");
            System.out.println("9. 종료");
            int no = sc.nextInt();

            switch (no) {
            case 1:
                inputInsert();
                break;
            case 2:
                controller.printAll();
                break;
            case 3:
                inputSearch();
                break;
            case 4:
                inputUpdate();
                break;
            case 9:
                System.exit(0);
                break; // 프로그램 종료
            default:
                System.out.println("잘못된 선택입니다. 다시 선택하쇼.");
            } // switch end
        } // while end
    } // method end

    public void inputInsert() {
        System.out.print("번호? ");
        int studentNumber = sc.nextInt();
        System.out.print("이름? ");
        String name = sc.next();
        System.out.print("나이? ");
        int age = sc.nextInt();
        System.out.print("주소? ");
        String address = sc.next();

        Student student = new Student(studentNumber, name, age, address);
        controller.insert(student);
    }

    public void inputSearch() {
        System.out.print("학생번호? ");
        int input = sc.nextInt();
        controller.searchById(input);
    }

    public void inputUpdate() {
        System.out.print("번호? ");
        int studentNumber = sc.nextInt();
        System.out.print("변경 나이? ");
        int age = sc.nextInt();
        System.out.print("변경 주소? ");
        String address = sc.next();

        Student student = new Student(studentNumber, "", age, address);
        controller.update(student);
    }
}