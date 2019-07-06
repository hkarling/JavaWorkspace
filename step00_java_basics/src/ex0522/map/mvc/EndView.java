package ex0522.map.mvc;

import java.util.Iterator;
import java.util.Map;

public class EndView {

	/**
	 * 전체출력
	 * 
	 * @param map
	 */
	public static void printAll(Map<String, Person> map) {

		System.out.println("********** Map 정보 (" + map.size() + ") **********");

//		for(Map.Entry<String, Person> entry : map.entrySet()) {
//			System.out.println(entry.getValue());
//		}

		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			Person person = map.get(it.next());
			System.out.println(person);
		}
	}

	/**
	 * key에 해당하는 정보 출력 [Person인 경우 이름만 출력, Student 경우는 이름과 총점 출력
	 * 
	 * @param person
	 */
	public static void printSearch(Person person) {

		if (person instanceof Student) {
			Student student = (Student) person;
			System.out.println("Person [이름:" + student.getName() + ", 총점:" + student.getSum() + "]");
		} else {
			System.out.println("Person [이름:" + person.getName() + "]");
		}
	}

	/**
	 * 성공 여부 메시지출력
	 * 
	 * @param message
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}
}
