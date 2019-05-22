package set;

import java.util.HashSet;
import java.util.Set;

public class MemberSetTest {

	Set<Member> set = new HashSet<>();
	
	public MemberSetTest() {
		
		/** Set은 중복 체크: hashCode() -> equals() */
		set.add(new Member("AAA", "가가가", 20));
		set.add(new Member("BBB", "나나나", 30));
		set.add(new Member("AAA", "다다다", 40));		
		set.add(new Member("AAA", "가가가", 20));
		
		System.out.println("총 갯수: " + set.size());
	}
	
	public static void main(String[] args) {
		new MemberSetTest();
	}
}
