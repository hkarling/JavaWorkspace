package improvements;

public class VariableArgsExam {

	public static void test(int ... i) {
		System.out.println("인수의 갯수: " + i.length);
		for(int index : i)
			System.out.print(index + "\t");
		System.out.println();
	}
	
	public static void test2(String str, int ... i) {
		
	}
	
	/** 
	 * Varargs는 매개변수 가장 마지막 인수로 사용해야한다. 
	 * 한 메소드의 인수로 여러 개를 쓸 수 없다.
	 * 
	 */
//	public static void test3(int ...is, String s) { }
	
	public static void main(String[] args) {
		test(4);
		test(4,5,6,7);
		test();
		
	}
}
