package ex0513.mvc;

/**
 * 메뉴를 출력하여 사용자가 선택을 하면 그 선택에 해당하는 필요한 정보를 받고 그에 따른 메소드를 호출해서 기능을 구현한다.
 */
public class StartView {

    public static void main(String[] args) {
        MenuView mv = new MenuView();
        mv.printMenu();
    }
} // class 끝