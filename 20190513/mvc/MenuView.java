import java.util.Scanner;

public class MenuView {
    Scanner sc = new Scanner(System.in); // 키보드 입력 준비
    ElectronicsController controller = new ElectronicsController();

    public void printMenu() {
        while (true) {
            System.out.println("********** 메뉴 **********");
            System.out.println("1. 등록");
            System.out.println("2. 전체검색");
            System.out.println("3. 부분검색");
            System.out.println("4. 수정하기");
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
                    System.exit(0); // 프로그램 종료
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택하쇼.");
            } // switch end
        } // while end
    } // method end

    /**
     * 등록할때 필요한 정보 입력받는 메소드
     */
    public void inputInsert() {
        // 모델번호
        System.out.println("모델번호: ");
        int modelNo = sc.nextInt();
        
        System.out.println("모델이름: ");
        String modelName = sc.next();
        
        System.out.println("모델가격: ");
        int modelPrice = sc.nextInt();
        
        System.out.println("모델설명: ");
        String modelDetail = sc.next();

        Electronics electronics = new Electronics(modelNo, modelName, modelPrice, modelDetail);
        controller.insert(electronics);
    }

    /**
     * 부분검색할 필요 정보 입력받는 메소드
     */
    public static void inputSearch() {

    }

    /**
     * 수정할때 필요한 정보 입력받는 메소드
     */
    public static void inputUpdate() {

    }

}