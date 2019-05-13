/**
 * 비지니스로직을 담당. 싱글톤
 * 실제 주요 기능 등록, 수정, 부분검색, 전체검색 기능 담당 클래스
 */
public class ElectronicsService {
    // 데이터의 영속성을 유지해줄 배열 필요.   
    Electronics[] arrElectronics = new Electronics[100];
    
    // 실제 배열방에 데이터가 저장된 갯수를 체크할 변수 선언
    int count;  // 0

    /**
     * 등록하기
     * @return boolean - true: 등록성공, false: 등록실패
     */
    public boolean insert(Electronics electronics) {
        
        return true;
    }

    /**
     * 전체검색
     */
    public Electronics[] selectAll() {

        return null;
    }
    
    /**
     * 조건검색: 모델번호에 해당하는 전자제품 검색
     * @return Electronics
     * @param modelNo
     */ 
    public Electronics searchByModelNo(int modelNo) {
        
        return null;
    }
    /**
     * 수정하기 - 모델 번호에 해당하는 이름, 가격, 설명 수정.
     * @return boolean - true: 수정성공, false: 수정실패
     */
    public boolean update(Electronics electronics) {

        return true;
    }
    
}