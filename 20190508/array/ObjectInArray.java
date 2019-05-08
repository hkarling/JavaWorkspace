//ObjectInArray.java
class ObjectOne {
	public int a;
}

public class ObjectInArray {
	// 메인 메소드에서
	public static void main(String[] args) {
		// ObjectOne 타입을 5개 까지 저장하는 배열을 선언하고
		ObjectOne[] objectOnes = new ObjectOne[5];

		// 5개의 ObjectOne객체를 생성하세요.
		for (int i = 0; i < 5; i++)
			objectOnes[i] = new ObjectOne();
		
		// 각 객체가 갖고있는 전역변수 출력
		System.out.println("----- 각 객체의 전역변수 -----");
		for (ObjectOne obj : objectOnes)
			System.out.println("전역변수: " + obj.a);
		// 각 객체의 주소값 출력
		System.out.println("----- 각 객체의 주소값 -----");
		for (ObjectOne obj : objectOnes)
			System.out.println("주소값: " + obj);

		// 각각의 ObjectOne객체가 서로 다른 a의 값을 갖도록 a의 값을 변경하세요.
		for (int i = 0; i < 5; i++) {
			objectOnes[i].a = (int) (Math.random() * 10);
		}
		// 각 ObjectOne 객체의 a를 출력하세요
		System.out.println("----- 각 객체의 전역변수 -----");
		for (ObjectOne obj : objectOnes)
			System.out.println("전역변수: " + obj.a);
	}
}
