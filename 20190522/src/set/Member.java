package set;

public class Member {
	private String id;
	private String name;
	private int age;

	public Member() {

	}

	public Member(String id, String name, int age) {
		this.id = id;
		this.name = name;
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
		builder.append("Member [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		System.out.println("Member의 hashCode 호출");
		
		return id.hashCode();//super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Member의 equals 호출");
		if(obj instanceof Member) {
			Member member = (Member)obj;
			if(id.equals(member.getId()))
				return true;
		}
		return super.equals(obj);
	}
}
