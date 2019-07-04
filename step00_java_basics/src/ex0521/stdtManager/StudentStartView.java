package stdtManager;

import java.util.List;

public class StudentStartView {

	public static void main(String[] args) {
		
		Object data[][] = {
				{"AAA", "가가", 22, "서울" },
				{"BBB", "나나", 31, "대전" },
				{"CCC", "다다", 49, "대구" },
				{"DDD", "라라", 58, "부산" },
				{"EEE", "마마", 67, "광주" },
		};
		
		StudentListService service = new StudentListService(data);
		
		
		System.out.println("********** 학생 관리 **********");
		
		/** 등록하기 */
		System.out.println("***** 추가 *****");
		
		boolean result = service.insert(new Student("FFF", "바바", 12, "판교"));
		
		if(result)
			StudentEndView.printMessage("학생등록성공!");
		else
			StudentEndView.printMessage("학생등록실패!");
		
		/** 전체검색 */
		System.out.println("***** 전체데이터 *****");
		List<Student> list = service.selectAll();
		StudentEndView.printAll(list);
		
		/** 부분검색 */
		System.out.println("***** id:CCC 검색 *****");
		StudentEndView.printSingle(service.searchById("CCC"));
		
		/** 삭제하기 */
		System.out.println("***** id:BBB 삭제 *****");
		
		result = service.delete("BBB");
		
		if(result)
			StudentEndView.printMessage("학생삭제성공!");
		else
			StudentEndView.printMessage("학생삭제실패!");
		
		StudentEndView.printAll(service.selectAll());
		
		/** 수정하기 */
		System.out.println("***** id:AAA 수정하기 *****");
		result = service.update(new Student("AAA", "카카", 20));
		
		if(result)
			StudentEndView.printMessage("AAA수정성공!");
		else
			StudentEndView.printMessage("AAA수정실패!");
		
		StudentEndView.printAll(service.selectAll());
		
	}
}
