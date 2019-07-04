package stdtManager;

import java.util.List;

public class StudentEndView {

	/** 전체출력 */
	public static void printAll(List<Student> list) {
		for(Student student : list)
			System.out.println(student);
	}
	
	/** id 검색을 통한 학생정보 출력 */
	public static void printSingle(Student student) {
		System.out.println(student);
	}
	
	/** 성공여부 출력 */
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
}
