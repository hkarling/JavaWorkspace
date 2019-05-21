package assign.electronics;

import java.util.List;

/**
 * View와 Model사이에서 사용자 요청이 들어오면 그 요청에 해당하는 Service를 호출하고 그 결과를 받아서 결과에 따른 뷰로
 * 이동해주는 역할
 */
public class ElectronicsController {
	
    private ElectronicsService service = ElectronicsService.getInstance();

    /**
     * 등록하기
     * @return void
     * @param Electornics 등록하려는 electornics 객체
     */
    public void insert(Electronics electronics) {
        // 서비스를 호출하고 그 결과를 받아서 결과뷰 호출. 등록 전에 중복체크를 하고 등록
        Electronics dbElec = service.searchByModelNo(electronics.getModelNo());
        if (dbElec == null) { // 등록가능
            if (service.insert(electronics)) {
                ViewEnd.printMessage("등록되었습니다.");
            } else {
                ViewEnd.printMessage("등록되지않았습니다.");
            }
        } else { // 등록불가
            ViewEnd.printMessage(electronics.getModelNo() + "번호는 중복이므로 등록할 수 없슴.");
        }
    }

    /**
     * 전체검색
     * @return void
     */
    public void selectAll() {
        // 서비스를 호출하고 그 결과를 받아서 결과뷰 호출
    	List<Electronics> list = service.selectAll();
        ViewEnd.printAll(list);
    }

    /**
     * 부분검색
     * @return void
     * @param int 모델번호
     */
    public void searchByModelNo(int modelNo) {
        Electronics result = service.searchByModelNo(modelNo);
        if (result != null) {
            ViewEnd.printSearchByModelNo(result);
        } else {
            ViewEnd.printMessage("모델넘버 " + modelNo + "에 해당하는 제품이 없음.");
        }
    }

    /**
     * 수정
     * @return void
     * @param Electronics 수정할 모델정보
     */
    public void update(Electronics electronics) {
        if (service.update(electronics)) {
            ViewEnd.printMessage("수정되었습니다.");
        } else {
            ViewEnd.printMessage("수정되지않았습니다.");
        }
    }
}