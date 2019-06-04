package dao.prepared;

import java.util.List;

/**
 * 요청결과 데이터를 화면에 출력하기
 */
public class EndView {

	/** 전체출력 */
	public static void printAll(List<EmpDTO> list) {
		for(EmpDTO obj : list) {
			System.out.println(obj);
		}
	}

	/** 사원번호에 해당하는 사원정보 출력 */
	public static void printSingle(EmpDTO employee) {
		System.out.println(employee);
	}

	/** 성공여부 메시지 출력 */
	public static void printMessage(String message) {
		System.out.println(message);
	}
}
