package ex0522.map.mvc;

public class Student extends Person {

	private int kor;
	private int eng;
	private int math;
	private int sum;

	public Student() {

	}
	
	public Student(String id, String name, int kor, int eng, int math) {
		this(id, name, -1, kor, eng, math);
	}

	public Student(String id, String name, int age, int kor, int eng, int math) {
		super(id, name, age);
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor + eng + math;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		this.sum = this.kor + this.eng + this.math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		this.sum = this.kor + this.eng + this.math;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		this.sum = this.kor + this.eng + this.math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student\t[");
		builder.append(this.getId());
		builder.append(", ");
		builder.append(this.getName());
		builder.append(", ");
		builder.append(this.getAge());
		builder.append(", ");
		builder.append(kor);
		builder.append(", ");
		builder.append(eng);
		builder.append(", ");
		builder.append(math);
		builder.append(", ");
		builder.append(sum);
		builder.append("]");
		return builder.toString();
	}
}
