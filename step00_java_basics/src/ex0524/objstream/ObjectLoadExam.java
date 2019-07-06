package ex0524.objstream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectLoadExam {

	public ObjectLoadExam() {

		/** 파일에 있는 데이터를 역직렬화해서 읽기 */
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream("src/text.txt"));

			Student st1 = (Student) ois.readObject();
			Student st2 = (Student) ois.readObject();
			@SuppressWarnings("unchecked")
			List<Student> list = (List<Student>) ois.readObject();

			System.out.println("st1" + st1);
			System.out.println("st2" + st2);
			System.out.println("list = " + list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ObjectLoadExam();
	}

}
