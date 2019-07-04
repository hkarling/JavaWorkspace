package ex0513.mvc;

/**
 * View와 Model사이에서 사용자 요청이 들어오면 그 요청에 해당하는 Service를 호출하고 그 결과를 받아서 결과에 따른 뷰로
 * 이동해주는 역할
 */
public class ElectronicsController {
    private ElectronicsService service = ElectronicsService.getInstance();

    /**
     * 등록
     */
    public void insert(Electronics electronics) {
        // 서비스를 호출하고 그 결과를 받아서 결과뷰 호출. 등록 전에 중복체크를 하고 등록
        Electronics dbElec = service.searchByModelNo(electronics.getModelNo());
        if (dbElec == null) { // 등록가능
            if (service.insert(electronics)) {
                EndView.printMessage("등록되었습니다.");
            } else {
                EndView.printMessage("등록되지않았습니다.");
            }
        } else { // 등록불가
            EndView.printMessage(electronics.getModelNo() + "번호는 중복이므로 등록할 수 없슴.");
        }
    }

    /**
     * 전체검색
     */
    public void selectAll() {
        // 서비스를 호출하고 그 결과를 받아서 결과뷰 호출
        Electronics[] arr = service.selectAll();
        EndView.printAll(arr);
    }

    /**
     * 부분검색
     */
    public void searchByModelNo(int modelNo) {
        Electronics result = service.searchByModelNo(modelNo);
        if (result != null) {
            EndView.printSearchByModelNo(result);
        } else {
            EndView.printMessage("모델넘버 " + modelNo + "에 해당하는 제품이 없음.");
        }
    }

    /**
     * 수정
     */
    public void update(Electronics electronics) {
        if (service.update(electronics)) {
            EndView.printMessage("수정되었습니다.");
        } else {
            EndView.printMessage("수정되지않았습니다.");
        }
    }
}