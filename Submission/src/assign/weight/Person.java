package assign.weight;

public class Person {
	private String name;
	private int weight;
	private String password;
	/**
	 * 
	 */
	public Person() {
	}
	/**
	 * @param name
	 * @param weight
	 * @param password
	 */
	public Person(String name, String password) {
		this.name = name;
		this.password = password;
	}
	/**
	 * @param name
	 * @param weight
	 * @param password
	 */
	public Person(String name, int weight, String password) {
		this(name, password);
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append("님의 몸무게는 ");
		builder.append(weight);
		builder.append("kg 입니다.");
		return builder.toString();
	}
}
