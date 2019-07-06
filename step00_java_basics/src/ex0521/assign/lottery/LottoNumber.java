package ex0521.assign.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class LottoNumber {
	
	private List<Integer> list = new ArrayList<Integer>();
	
	public LottoNumber() {
		this.saveNumbers();	// 숫자저장 메소드호출
		this.sortNumbers();	// 정렬 메소드호출
		this.printNumbers();	// 출력 메소드호출
	}
	
	/** 
	 * 중복체크하는 메소드
	 * @param int 새로 생성된 숫자
	 * @return boolean true: 새로운 숫자, false: 있는 숫
	 */
    // 1) 중복체크 하는 메소드: 인수로 '입력할 숫자'와 '넣을 장소'를 받아온다
    private boolean checkDuplicate(int newNumber) {
    	if(!list.contains(newNumber))
    		return true;
    	else
    		return false;
    }

    /**
     * 숫자 6개를 배열방에 저장하는 메소드
     * @return void
     */
    public void saveNumbers() {

    	Random random = new Random();

    	while(list.size() < 6) {
    		int i = random.nextInt(45) + 1;
    		if(this.checkDuplicate(i))
    			list.add(i);
    	}
    }

    /** 배열방의 값을 내림차순으로 정렬하는 메소드
     * @return void
     */
    private void sortNumbers() {
    	Collections.sort(list);
    }

    /**
     * 배열의 값을 화면에 출력하는 메소드
     * @return void
     */
    public void printNumbers() {
    	System.out.println("로또번호: " + this.list);
    }

    // 메인메서드
    public static void main(String[] args) {

    	new LottoNumber();
    }
}
