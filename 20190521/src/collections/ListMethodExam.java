package collections;

import java.util.ArrayList;
import java.util.List;

public class ListMethodExam {

	/** 일일이 Type Casting을 하지 않기 위해서 <> 안에 타입을 선언한다. */
	List<String> list = new ArrayList<>(5);

	/** list에 데이터 추가 */
	public void addList(String[] data) {
		for (String str : data)
			list.add(str);
	}

	/** 모든 list의 항목 출력 */
	public void printList() {
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i) + "\t");
//		}
//		System.out.println();
//		
//		for(String str : list)
//			System.out.print(str + "\t");
//		System.out.println();
//		
		System.out.println(list);
	}

	/** list에 관련된 메소드 사용해보기 */
	public void methodTest() {

		/** 해당 인덱스에 컨텐츠를 추가한다 */
		list.add(2, "망해라");
		printList();

		/** 해당 인덱스에 컨텐츠를 대체한다 */
		list.set(1, "caca");
		printList();

		/** 리스트에 해당 항목이 존재하는지 확인한다 */
		System.out.println(list.contains("망해라"));
		System.out.println(list.contains("으아"));

		/** indexOf: 왼쪽에서부터 검색, lastIndexOf: 오른쪽에서부터 검색 */
		System.out.println("caca항목 앞에서부터 i = " + list.indexOf("caca"));
		System.out.println("caca항목 뒤에서부터 i = " + list.lastIndexOf("caca"));
		System.out.println("i = " + list.indexOf("asldkjf"));

		/** 리스트의 일부분을 추출 */
		List<String> subList = list.subList(2, 4);
		System.out.println("subList: " + subList);

		/** 항목의 제거 */
		list.remove(2);
		printList();
	}

	/** Main Method */
	public static void main(String[] args) {
		ListMethodExam obj = new ListMethodExam();
		obj.addList(args);
		obj.printList();

		obj.methodTest();

	}
}
