package objstream;

import java.io.Serializable;

/**
 * 객체를 직렬화하여 파일에 저장.
 * 1) 반드시 Serializable을 구현한 객체만 파일에 저장가능
 * 2) 생성자, 메소드는 직렬화 안된다.
 * 3) 필드직렬화 static, transient 키워드는 직렬화 대상에서 제외된다.
 * 
 * @author hkarling
 *
 */
public class Student implements Serializable {

	private String name;
	private int age;
	
	public Student() {
		
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
}
