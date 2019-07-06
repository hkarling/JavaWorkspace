package ex0517.exceptionEx;

class Student {
	private int age; // age의 값은 음수 안됨.

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws RuntimeException {
		if (age < 0) {
			// 예외 메시지를 출력.
			RuntimeException re = new RuntimeException(age + "는 0보다 작아서 안됨.");
//			Exception re = new Exception();
			throw re;
		} else {
			this.age = age;
		}
	}
}

public class ThrowExam {

	public static void main(String[] args) {
		System.out.println("----- 메인시작 -----");

		try {
			new Student().setAge(4);
			new Student().setAge(-1);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			
		}

		System.out.println("----- 메인  -----");
	}
}
