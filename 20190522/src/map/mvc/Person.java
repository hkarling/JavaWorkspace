package map.mvc;
/**
 * Person 클래스
 * @author hkarling
 * @since 2019/05/22
 */
public class Person {
	private String id;
	private String name;
	private int age;

	public Person() {

	}
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
		
	}
	public Person(String id, String name, int age) {
		this(id, name);
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		builder.append("Person\t[");
		builder.append(id);
		builder.append(", ");
		builder.append(name);
		builder.append(", ");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
}
