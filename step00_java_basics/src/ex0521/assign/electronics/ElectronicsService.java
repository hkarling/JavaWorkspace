package ex0521.assign.electronics;

import java.util.ArrayList;
import java.util.List;

/**
 * 비지니스로직을 담당. 싱글톤 실제 주요 기능 등록, 수정, 부분검색, 전체검색 기능 담당 클래스
 */
public class ElectronicsService {
	
	//** 싱글턴 객체를 저장하는 곳 */
	private static ElectronicsService instance;

	// 데이터의 영속성을 유지해줄 배열 필요.
	List<Electronics> list = new ArrayList<Electronics>();
	// 초기치
	String data[][] = { { "100", "에어컨", "250000", "삼성 무풍에어컨" }, { "200", "세탁기", "350000", "LG 세탁짱" },
			{ "300", "냉장고", "500000", "냉장고입니다." }, { "400", "전자렌지", "640000", "전자렌즈입니다." },
			{ "500", "밥통", "450000", "쿠쿠밥솥 최고!" } };

	private ElectronicsService() {
		// 데이터 초기화
		for (String[] row : data) {
			list.add(new Electronics(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]), row[3]));
		}
	}

	public static ElectronicsService getInstance() {
		if(instance == null)
			instance = new ElectronicsService();
		return instance;
	}

	/**
	 * 등록하기
	 * @return boolean - true: 등록성공, false: 중복모델번호가 있음.
	 * @param Electronics
	 */
	public boolean insert(Electronics electronics) {
		if (this.searchByModelNo(electronics.getModelNo()) != null)
			return false;
		else
			list.add(electronics);
		return true;
	}

	/**
	 * 전체검색
	 * @return List<Electronics>
	 */
	public List<Electronics> selectAll() {

		return list;
	}

	/**
	 * 조건검색 : 모델번호에 해당하는 전자제품 검색
	 * 
	 * @return Electronics
	 * @param modelNo
	 */
	public Electronics searchByModelNo(int modelNo) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getModelNo() == modelNo)
				return list.get(i);
		}
		return null;
	}

	/**
	 * 수정하기 - 모델 번호에 해당하는 이름, 가격, 설명 수정.
	 * 
	 * @return boolean - true: 수정성공, false: 수정실패
	 * @param Electronics 업데이트할 electronics 객체
	 */
	public boolean update(Electronics electronics) {
		Electronics elec = this.searchByModelNo(electronics.getModelNo());
		if (elec != null) {
			elec.setModelName(electronics.getModelName());
			elec.setModelPrice(electronics.getModelPrice());
			elec.setModelDetail(electronics.getModelDetail());

		}
		return false;
	}
}