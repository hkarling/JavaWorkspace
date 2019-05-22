package map.mvc;

import java.util.Map;

public class MapStudentController {

	private static MapStudentService service = new MapStudentService();

	public static void selectAll() {
		try {
			Map<String, Person> map = service.selectAll();
			EndView.printAll(map);
		} catch (Exception e) {
//			e.printStackTrace();
			EndView.printMessage(e.getMessage());
		}
	}

	public static void searchById(String id) {

		try {
			Person person = service.searchByKey(id);
			EndView.printSearch(person);
		} catch (Exception e) {
//			e.printStackTrace();
			EndView.printMessage(e.getMessage());
		}

	}

	public static void insert(Person person) {
		try {
			service.insert(person);
			EndView.printMessage("[id:" + person.getId() + "]를 등록하였습니다.");
		} catch (Exception e) {
//			e.printStackTrace();
			EndView.printMessage(e.getMessage());
		}
	}

	public static void delete(String id) {
		try {
			service.delete(id);
			EndView.printMessage("[id:" + id + "]를 삭제하였습니다.");
		} catch (Exception e) {
//			e.printStackTrace();
			EndView.printMessage(e.getMessage());
		}
	}

	public static void update(Person person) {
		try {
			service.update(person);
			EndView.printMessage("[id:" + person.getId() + "]를 수정하였습니다.");
		} catch (Exception e) {
//			e.printStackTrace();
			EndView.printMessage(e.getMessage());
		}
	}

}
