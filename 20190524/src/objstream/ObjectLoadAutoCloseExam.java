package objstream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * 1.7버전에서 AutoClosable 추가 : IO, network, JDBC 등 항상 close()를 해줘야하는 부분을 자동 리소스 닫기
 * 기능을 추가했다 (AutoClosable 구현)
 * 
 * @author hkarling
 *
 */
public class ObjectLoadAutoCloseExam {

	public ObjectLoadAutoCloseExam() {

		/** 파일에 있는 데이터를 역직렬화해서 읽기 */

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/text.txt"))) {

			Student st1 = (Student) ois.readObject();
			Student st2 = (Student) ois.readObject();
			List<Student> list = (List<Student>) ois.readObject();

			System.out.println("st1 = " + st1);
			System.out.println("st2 = " + st2);
			System.out.println("list = " + list);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ObjectLoadAutoCloseExam();
	}

}
