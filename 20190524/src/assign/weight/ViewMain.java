package assign.weight;

import java.util.Scanner;

public class ViewMain {

	private WeightController controller = new WeightController();
	private static Scanner scanner = new Scanner(System.in);

	/** 생성자 */
	public ViewMain() {
		printMenu();
	}

	/** 초기화면 출력 메소드 */
	public void printMenu() {
		while (true) {

			System.out.println("\n다음 사항에 맞게 입력하여 주십시오.");
			System.out.println("\t몸무게 입력은 1 번");
			System.out.println("\t몸무게 검색은 2 번");
			System.out.println("\t몸무게 변경은 3 번");
			System.out.println("\t비밀번호 번경은 4 번");
			System.out.println("\t프로그램 종료는 5 번");
			System.out.println("을 입력한 후 Enter를 눌러주시오.");
			System.out.print("메뉴 선택: ");

			int selection = 0;
			
			/** 입력값이 숫자가 아닐때 예외처리를 하고 메뉴를 다시 출력합니다. */
			try {
				selection = scanner.nextInt();	
			} catch (Exception e) {
				scanner.next();
				System.out.println("잘못된 입력값입니다.");
				continue;
			}
			
			switch (selection) {
			case 1:
				printInsertMenu();
				break;
			case 2:
				printSearchMenu();
				break;
			case 3:
				printWeightUpdateMenu();
				break;
			case 4:
				printPasswordUpdateMenu();
				break;
			case 5:
				scanner.close();
				System.out.println("종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("다시입력하세요.");
			}

		}
	}
	
	public void printInsertMenu() {
		System.out.println("\n이름을 입력하여 주십시오.");
		System.out.print("이름: ");
		String name = scanner.next();
		
		System.out.println("\n몸무게를 입력하여 주십시오.");
		System.out.print("몸무게: ");
		String weight = scanner.next();
		
		System.out.println("\n비밀번호를 입력하여 주십시오.");
		System.out.print("비밀번호: ");
		String password = scanner.next();
		
		Person person = null;
		try {
			person = new Person(name, Integer.parseInt(weight), password);
		} catch (NumberFormatException e) {
			System.out.println("몸무게에 이상한거 넣지말죠.");
			printInsertMenu();	// 다시 불러라.
		}
		controller.insert(person);
	}
	
	/** 검색 메뉴 */
	public void printSearchMenu() {	
		controller.selectPerson(subMenuInfoInput());
	}
	
	/** 몸무게 변경 */
	public void printWeightUpdateMenu() {
		controller.updateWeight(subMenuInfoInput());
	}
	
	/** 비밀번호 변경 */
	public void printPasswordUpdateMenu() {
		controller.updatePassword(subMenuInfoInput());
	}
	
	/** 몇개의 서브메뉴에서 중복되는 부분을 묶는 메소드입니다. */
	private Person subMenuInfoInput() {
		System.out.println("\n이름을 입력하여 주십시오.");
		System.out.print("이름: ");
		String name = scanner.next();
		
		System.out.println("\n비밀번호를 입력하여 주십시오.");
		System.out.print("비밀번호: ");
		String password = scanner.next();
		
		return new Person(name, password);
	}
	
	/** 중간에 추가적으로 입력을 받기위한 메소드입니다. : 몸무게 */
	public static String weightInput() {
		System.out.println("\t변경할 몸무게를 입력하시오.");
		System.out.print("\t변경할 몸무게 : ");
		
		return scanner.next();
	}
	
	/** 중간에 추가적으로 입력을 받기위한 메소드입니다. : 몸무게 */
	public static String passwordInput() {
		System.out.println("\t변경할 패스워드를 입력하시오.");
		System.out.print("\t변경할 패스워드 : ");
		
		return scanner.next();
	}
}
