package project.view;

import java.util.Scanner;

public class MainView {
    private Scanner sc = new Scanner(System.in);

    public String login() {
        System.out.println("********** 로그인 **********");
        System.out.print("아이디: ");
        String input = sc.next();

        return input;
    }
}
