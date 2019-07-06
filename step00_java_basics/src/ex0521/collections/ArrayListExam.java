package ex0521.collections;
import java.util.ArrayList;

class ArrayListExam extends ArrayList {

	// 전역 Variable Object 타입1개, int 타입 1개;
	Object obj ;
	int var1 ;
	
	/** Constructor */
	public ArrayListExam() {
		
		/** 기본 생성자는 10개의 공간을 가진 리스트를 생성한다. */
		super(5);
		
	}

////////////////////// METHOD //////////////////////
	/* 
	 * 이름: addInt, 리턴타입: 없음, 인수: int 1개, 하는일: 인수로 받은 정수를 객체로 만들어 list에 추가.
	 */
	void addInt(int i) {
		this.add(new Integer(i));
	}

	/*
	 * 이름: addFloat, 리턴타입: 없음, 인수: float 1개, 하는일 : 인수로 받은 실수를 객체로 만들어 list에 추가.
	 */
	void addFloat(float f) {
		this.add(new Float(f));
	}
	/*
	 * 이름: addString, 리턴타입: 없음, 인수: String 1개, 하는일 : 인수로 받은 String 을 list에 추가.
	 */
	void addString(String str) {
		this.add(str);
	}
	/*
	 * 이름: printList, 리턴타입: 없음, 인수: 없음,
	 * 하는일: 정수형 전역변수에 현재 list에 들어있는 객체의 개수 입력한 후 전역변수 출력.
	 * 		 List에 저장된 각 객체를 맴버변수에 저장한후 출력
	 */
	void printList() {
		var1 = this.size();
		System.out.println("총 갯수는 : " + var1);

//		for(int i = 0; i < var1; i++) {
//			obj = this.get(i);
//			System.out.print(obj + "\t");
//		}

		for (Object obj : this)
			System.out.print(obj + "\t");
		
		System.out.println();
	}

	public static void main(String args[]) {
		ArrayListExam list = new ArrayListExam();
		String s = new String("newString");
		list.addInt(5);
		list.addFloat(5.5F);
		list.addString(s);
		list.printList();
	}
}

/*
 * 실행결과
 * list에 들어있는 객체의 총 개수는=3 5 5.5 newString
 */