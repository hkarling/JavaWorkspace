package stdtManager;

import java.util.ArrayList;
import java.util.List;

public class StudentListService {
	
	static List<Student> list = new ArrayList<>();
	
	public StudentListService() {

	}

	public StudentListService(Object[][] data) {
		for(Object[] row : data) {
			Student student = new Student((String)row[0], (String)row[1], (int)row[2], (String)row[3]);
			list.add(student);
		}
	}

	/** 
	 * 추가하기
	 * @return true: 추가성공, false: 추가실패
	 */
	public boolean insert(Student student) {
		boolean flag = false;
		for(Student std: list) {
			if(std.getId().equals(student.getId())) {
				flag = true;
				break;
			}
		}
		if(flag) {
			list.add(student);
			return true;	
		} else {
			return false;
		}
	}
	
	/** id에 해당하는 학생 정보 찾기 */
	public Student searchById(String id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id))
				return list.get(i);
		}
		return null;
	}
	
	/** 전체검색 */
	public List<Student> selectAll() {
		return list;
	}
	
	/** 
	 * id에 해당하는 학생 삭제하기
	 * @return true: 삭제성공, false: 삭제실패
	 */
	
	public boolean delete(String id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/** id에 해당하는 학생정보 수정하기 */
	public boolean update(Student student) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(student.getId())) {
				list.get(i).setAge(student.getAge());
				list.get(i).setName(student.getName());
				return true;
			}
		}
		return false;
	}
}
