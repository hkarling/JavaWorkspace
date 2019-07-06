package ex0522.set;

import java.util.Iterator;
import java.util.TreeSet;

public class SetExam2 extends TreeSet<String> {

	public SetExam2() {
		//super(10);
	}
	public void addSet(String[] args) {
		for(String s : args) {
			boolean re = super.add(s);
			System.out.println(s + "의 추가결과: " + re );
		}
	}
	
	public void printSet() {
		System.out.println("총 갯수 : " + this.size());
		
		System.out.println("\n----- Iterator -----");
		/** Iterator는 모든 자료구조의 데이터를 추출(꺼내기)할 수 있도록 만들어놓은 표준 interface */
//		Iterator<String> it = super.iterator();
		Iterator<String> it = super.descendingIterator();
		
		while(it.hasNext()) {
			String str = it.next();	// 요소가 있는지 없는지 체크한다.
			System.out.print(str + ", ");	// 요소를 꺼낸다.
		}
		System.out.println("\n----- 개선된 for -----");
		
		for(String str : this)
			System.out.print(str + ", ");
		System.out.println("\n----- 그냥찍기 -----");
		System.out.println(this);
	}
	
	public static void main(String[] args) {
		SetExam2 se = new SetExam2();
		se.addSet(args);
		se.printSet();
	}
}
