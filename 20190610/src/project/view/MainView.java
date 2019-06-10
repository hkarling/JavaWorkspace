package project.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import project.controller.ShopController;

public class MainView {

	private static Scanner sc = new Scanner(System.in);
	private static ShopController controller = new ShopController();

	public void printMainMenu() {
		while (true) {
			System.out.println("/n********** 메 뉴 **********");
			System.out.println("1. 상품리스트");
			System.out.println("2. 상품찾기 by name");
			System.out.println("3. 수량수정 by id");
			System.out.println("4. 상품삭제 by id");
			System.out.println("5. 종료");

			System.out.print("입력: ");
			String input = sc.next();

			if (input.equals("1")) {
				controller.displayAll();
			} else if (input.equals("2")) {
				System.out.print("상품명: ");
				input = sc.next();
				controller.selectProductByName(input);
			} else if (input.equals("3")) {
				try {
					System.out.print("수량을 바꿀 제품 id: ");
					int input1 = sc.nextInt();
					System.out.print("바꿀 수량 : ");
					int input2 = sc.nextInt();
					controller.updateQuantity(input1, input2);
				} catch (InputMismatchException e) {
					ResultView.printMessage(e.getMessage());
				}
			} else if (input.equals("4")) {
				try {
					System.out.print("삭제할 제품의 id: ");
					int input1 = sc.nextInt();
					controller.deleteProduct(input1);
				} catch (InputMismatchException e) {
					ResultView.printMessage(e.getMessage());
				}
			} else if (input.equals("5")) {
				System.out.println("캄사.");
				System.exit(0);
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	public static void main(String[] args) {
		new MainView().printMainMenu();
	}

	/*
	 * private static void login() { System.out.print("아이디: "); String id =
	 * sc.next(); // currentUser = ShopController.login(id);
	 * 
	 * }
	 * 
	 * // 손님용 public static void printCustomerMenu() { while (true) {
	 * System.out.println(" ~~~ 님 환영합니다. 남은 마일리지: ~~~~~");
	 * System.out.println("********** 메 뉴 **********");
	 * System.out.print("1. 상품 리스트"); System.out.print("2. 구매");
	 * System.out.print("3. 개인정보수정"); System.out.print("4. 마일리지 등록");
	 * System.out.print("5. 탈퇴"); System.out.println("6. 종료");
	 * 
	 * System.out.print("입력: "); String input = sc.next();
	 * 
	 * if (input.equals("1")) {
	 * 
	 * } else if (input.equals("2")) {
	 * 
	 * } else if (input.equals("3")) {
	 * 
	 * } else if (input.equals("4")) {
	 * 
	 * } else if (input.equals("5")) {
	 * 
	 * } else if (input.equals("6")) {
	 * 
	 * } } }
	 * 
	 * // 주인용 public static void printOwnerMenu() {
	 * System.out.println("쥔장 환영함 -_-");
	 * System.out.println("********** 메 뉴 **********");
	 * System.out.println("1. 상품리스트"); System.out.println("2. 상품찾기 by name");
	 * System.out.println("3. 수량수정 by id"); System.out.println("4. 상품삭제 by id");
	 * System.out.println("5. 종료");
	 * 
	 * }
	 */
}
