package ex0524.objstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectSaveExam {

	public ObjectSaveExam() {
		
		/** 객체를 직렬화해서 파일에 저장 */
		Student st1 = new Student("AAAA", 21);
		Student st2 = new Student("BBBB", 22);
		
		List<Student> list = new ArrayList<>();
		list.add(new Student("CCCC", 24));
		list.add(new Student("DDDD", 23));
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("src/text.txt"));
			oos.writeObject(st1);
			oos.writeObject(st2);
			oos.writeObject(list);
			System.out.println("저장이 완료되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {

		new ObjectSaveExam();
	}
}
