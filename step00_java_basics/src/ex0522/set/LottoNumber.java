package ex0522.set;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoNumber {
	
	Set<Integer> list = new TreeSet<>();
	
	public LottoNumber() {
		// 번호 6개 세팅
		Random rand = new Random();
		while(list.size() < 6) {
			int i = rand.nextInt(45) + 1;
			list.add(i);
		}
		System.out.println("로또번호: " + list);
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++)
			new LottoNumber();
	}
}
