package mvc;

/**
 * 사용자 요청에 해당하는 결과를 화면에 출력하는 클래스
 */
public class EndView {
    /**
     * 전체출력
     */
    public static void printAll(Electronics[] data) {
        System.out.println("\n***** Electronics LIST(" + ElectronicsService.count + ")*****");
        for (int i = 0; i < ElectronicsService.count; i++) {
            // System.out.print("모델번호: " + data[i].getModelNo() + "\t");
            // System.out.print("모델이름: " + data[i].getModelName() + "\t");
            // System.out.print("모델가격: " + data[i].getModelPrice() + "\t");
            // System.out.println("모델설명: " + data[i].getModelDetail());
            System.out.println(data[i]);       
        }
    }

    /**
     * 부분출력
     */
    public static void printSearchByModelNo(Electronics data) {
        System.out.println("\n***** Electronics #" + data.getModelNo() + " *****");
        System.out.print("모델번호: " + data.getModelNo() + "\t");
        System.out.print("모델이름: " + data.getModelName() + "\t");
        System.out.print("모델가격: " + data.getModelPrice() + "\t");
        System.out.println("모델설명: " + data.getModelDetail());
    }

    /**
     * 등록, 수정에 따른 성공, 실패 출력
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }
}