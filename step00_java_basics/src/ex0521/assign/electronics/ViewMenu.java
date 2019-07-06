package ex0521.assign.electronics;

import java.util.Scanner;

public class ViewMenu {
	Scanner sc = new Scanner(System.in); // 키보드 입력 준비
	ElectronicsController controller = new ElectronicsController();

	ViewMenu() {
		
		printMenu();
	}

	/**
	 * 기본 메뉴를 출력한다.
	 * @return void
	 */
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
				controller.selectAll();
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

	/**
	 * 등록을 선택하였을 때의 서브메뉴
	 */
	public void inputInsert() {
		System.out.print("모델번호: ");
		int modelNo = sc.nextInt();

		System.out.print("모델이름: ");
		String modelName = sc.next();

		System.out.print("모델가격: ");
		int modelPrice = sc.nextInt();

		System.out.print("모델설명: ");
		String modelDetail = sc.next();

		Electronics electronics = new Electronics(modelNo, modelName, modelPrice, modelDetail);
		controller.insert(electronics);
	}

	/**
	 * 부분검색을 선택하였을 때의 서브메뉴
	 */
	public void inputSearch() {
		System.out.print("모델번호: ");
		int modelNo = sc.nextInt();
		controller.searchByModelNo(modelNo);
	}

	/**
	 * 수정을 선택하였을 때의 서브메뉴
	 */
	public void inputUpdate() {
		System.out.print("수정할 모델번호: ");
		int modelNo = sc.nextInt();
		
		System.out.print("변경 모델이름: ");
		String modelName = sc.next();

		System.out.print("변경 모델가격: ");
		int modelPrice = sc.nextInt();

		System.out.print("변경 모델설명: ");
		String modelDetail = sc.next();

		Electronics electronics = new Electronics(modelNo, modelName, modelPrice, modelDetail);
		controller.update(electronics);
	}
}