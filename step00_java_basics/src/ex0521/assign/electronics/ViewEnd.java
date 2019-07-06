package ex0521.assign.electronics;

import java.util.List;

/**
 * 사용자 요청에 해당하는 결과를 화면에 출력하는 클래스
 */
public class ViewEnd {
    /**
     * 전체출력
     * @return void
     * @param List<Electronics> 모델들의 전체리스트를 받아온다.
     */
    public static void printAll(List<Electronics> list) {
        System.out.println("\n***** Electronics LIST(" + list.size() + ")*****");
        for (Electronics elec : list)
            System.out.println(elec);
    }

    /**
     * 부분출력
     * @return void
     * @param Electronics 출력할 모델의 정보를 받아온다.
     */
    public static void printSearchByModelNo(Electronics data) {
        System.out.println("\n***** Electronics #" + data.getModelNo() + " *****");
        System.out.println(data);
    }

    /**
     * 등록, 수정에 따른 성공, 실패 출력
     * @return void
     * @param String 출력할 메시지를 받는다.
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }
}