package map.mvc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapStudentService {

	private Map<String, Person> map = new HashMap<>();

	/**
	 * 생성자에서 초기치 데이터 세팅하기
	 */
	public MapStudentService() {
		Random random = new Random();

		map.put("AAA", this.create("AAA", "가가가", 20));
		map.put("BBB", this.create("BBB", "나나나", 30));
		map.put("CCC", this.create("CCC", "다다다", 40, random.nextInt(101), random.nextInt(101), random.nextInt(101)));
		map.put("DDD", this.create("DDD", "라라라", 50, random.nextInt(101), random.nextInt(101), random.nextInt(101)));
		map.put("EEE", this.create("EEE", "마마마", 60, random.nextInt(101), random.nextInt(101), random.nextInt(101)));
	}

	/**
	 * Person or Student 객체를 생성해서 리턴해주는 메소드를 작성.
	 * 
	 * @param id, name, age, is
	 * @return Person, Student
	 */
	private Person create(String id, String name, int age, int... is) {
		if (is.length == 0) { // Person
			return new Person(id, name, age);
		} else { // Student
			return new Student(id, name, age, is[0], is[1], is[2]);
		}
	}

	/**
	 * 명단을 반환한다.
	 * 
	 * @return this.map
	 * @throws Exception
	 */
	public Map<String, Person> selectAll() throws Exception {

		if (map.isEmpty())
			throw new Exception("정보가 없습니다.");
		else
			return this.map;
	}

	/**
	 * key에 해당하는 정보검색: key해당하는 정보를 출력할 때 Person인경우는 이름만 출력, Student인경우는 이름과 총점 출력.
	 * 
	 * @param id
	 * @return
	 * @throws Exception EndView에서 없는경우는 "id는 없습니다." 예외발생
	 */
	public Person searchByKey(String id) throws Exception {

		if (map.containsKey(id))
			return map.get(id);
		else
			throw new Exception("[id:" + id + "]에 해당하는 정보가 없습니다.");
	}

	/**
	 * 등록 : key와 Person의 정보를 받아 등록하는 메소드.
	 * 
	 * @param person
	 * @throws Exception 등록이 실패하면(id중복체크!!) 예외발생시킨다.("등록되지 않았습니다.")
	 */
	public void insert(Person person) throws Exception {
		if (map.containsKey(person.getId())) {
			throw new Exception("등록되지 않았습니다.");
		} else {
			map.put(person.getId(), person);
		}
	}

	/**
	 * 삭제 : id에 해당하는 value
	 * 
	 * @param id
	 * @throws Exception 삭제되지 않으면 예외발생 (삭제되지 않았습니다.)
	 */
	public void delete(String id) throws Exception {

		/** map.remove(Object key)는 삭제가 성공하면 삭제되는 객체를 반환하고 삭제를 실패하면 null 리턴 */
		if (map.remove(id) == null)
			throw new Exception("[id:" + id + "]는 삭제되지 않았습니다.");
	}

	/**
	 * 수정하기: Person인경우 - 이름만 수정 Student인경우 - 이름, 국어, 영어, 수학 수정(총점 변경)
	 * 
	 * @param person
	 * @throws Exception 수정이 안된다면 예외발생
	 */
	public void update(Person person) throws Exception {
//		Person mapPerson = map.get(person.getId());
//		
//		if (mapPerson == null)
//			throw new Exception("-- [id:" + person.getId() + "]는 해당 정보가 존재하지 않습니다. --");
//
//		if (person.getClass() != map.get(person.getId()).getClass())
//			throw new Exception("-- 타입이 일치하지 않습니다. --");
//		
//		mapPerson.setName(person.getName());
//		
//		if (person instanceof Student) {
//			Student student = (Student) person;
//			((Student)mapPerson).setKor(student.getKor());
//			((Student)mapPerson).setEng(student.getEng());
//			((Student)mapPerson).setMath(student.getMath());
//			((Student) map.get(person.getId())).setKor(student.getKor());
//			((Student) map.get(person.getId())).setEng(student.getEng());
//			((Student) map.get(person.getId())).setMath(student.getMath());
//		}

		Person mapPerson = map.get(person.getId());
		if (mapPerson == null) {
			throw new RuntimeException(person.getId() + "없으므로 수정할 수 없습니다.");
		}

		if (person instanceof Student) {
			// 이름, 국어 ,영어,수학
			if (mapPerson instanceof Student) {
				Student uStudent = (Student) mapPerson;
				Student dStudent = (Student) person;

				uStudent.setName(dStudent.getName());
				uStudent.setKor(dStudent.getKor());
				uStudent.setEng(dStudent.getEng());
				uStudent.setMath(dStudent.getMath());

				int sum = uStudent.getKor() + uStudent.getEng() + uStudent.getMath();
				// 총점
				uStudent.setSum(sum);
			} else {
				throw new RuntimeException("타입 오류이므로 수정할 수 없습니다.");
			}

		} else {
			// 이름
			mapPerson.setName(person.getName());
		}
	}
	/**
	 * 출력 key에해당하는 정보 출력 [ Person인경우는 이름만 출력 Student인경우는 이름과 총점 출력 ]
	 */
}
