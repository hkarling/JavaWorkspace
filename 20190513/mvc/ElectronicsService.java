/**
 * 비지니스로직을 담당. 싱글톤
 * 실제 주요 기능 등록, 수정, 부분검색, 전체검색 기능 담당 클래스
 */
public class ElectronicsService {
    private static ElectronicsService instance = new ElectronicsService();
    
    // 데이터의   영속성을 유지해줄 배열 필요.   
    Electronics[] arrElectronics = new Electronics[100];
    
    // 실제 배열방에 데이터가 저장된 갯수를 체크할 변수 선언
    public static int count;  // 0
            

            
    // 초기치
    String data[][] = { { "100", "에어컨", "250000", "삼성 무풍에어컨" }, { "200", "세탁기", "350000", "LG 세탁짱" },
    { "300", "냉장고", "500000", "냉장고입니다." }, { "400", "전자렌지", "640000", "전자렌즈입니다." },
    { "500", "밥통", "450000", "쿠쿠밥솥 최고!" }};

    private    ElectronicsService() {    
        // 데이터 초기화
        for(String[] row : data) {
            arrElectronics[count++] = new Electronics(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]), row[3]);
        }
    }
  
    public static ElectronicsService getInstance() {
        return instance; 
    }
     
    /**   
     * 등록하기
     * @return boolean - true: 등록성공, false: 등록실패
     * @param electronics
     */
     
     public boolean insert(Electronics electronics) {
        if(count == arrElectronics.length)
            return false;
        arrElectronics[count++] = electronics;
        return true;
    }  
  
    /**  
     * 전체검색  
     */ 
    public Electronics[] selectAll() {
 
        return arrElectronics;
    } 
     
    /**
     * 조건검색 : 모델번호에 해당하는 전자제품 검색
     * @return  Electronics
     * @param modelNo
     */  
    public Electronics searchByModelNo(int modelNo) {
        for(int i = 0; i < count; i++) {
            if(arrElectronics[i].getModelNo() == modelNo)
                return arrElectronics[i];
        }
        return null;
    }
    /**
     * 수정하기 - 모델 번호에 해당하는 이름, 가격, 설명 수정.
     * @return boolean - true: 수정성공, false: 수정실패
     * @param electronics
     */
    public boolean update(Electronics electronics) {
        Electronics elec = this.searchByModelNo(electronics.getModelNo());
        if(elec != null) {
            elec.setModelName(electronics.getModelName());
            elec.setModelPrice(electronics.getModelPrice());
            elec.setModelDetail(electronics.getModelDetail());
            
        } 
        return false;   
    }
}