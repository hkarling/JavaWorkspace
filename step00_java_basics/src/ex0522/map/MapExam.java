package ex0522.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * HashMap 데모
 * @author hkarling
 * @since 2019/05/22
 */
public class MapExam extends HashMap<Integer, String> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8105976559225357626L;



	MapExam() {
		super.put(111, "AAA");
		super.put(112, "BBB");
		super.put(113, "CCC");
		super.put(114, "DDD");
		super.put(115, "EEE");
		super.put(111, "FFF");
		super.put(117, "GGG");
		
		System.out.println(this);
		
		// 맵에 있는 모든 키의 정보를 가져온다.
		Set<Integer> keySet = super.keySet();
		Iterator<Integer> it = keySet.iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			String str = super.get(key);
			System.out.println(key + " : " + str);
		}
				
	}
	
	

	public static void main(String[] args) {
		new MapExam();
	}

}
