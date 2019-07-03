package kosta.model.service;

import kosta.model.dao.ElectronicsDAO;
import kosta.model.dao.ElectronicsDAOImpl;
import kosta.model.dto.Electronics;

import java.sql.SQLException;
import java.util.List;

public class ElectronicsService {

    static ElectronicsDAO dao = new ElectronicsDAOImpl();
//    private ElectronicsService instance = new ElectronicsService();
//
//    private ElectronicsService(){
//
//    }
//
//    public ElectronicsService getInstance() {
//        return instance;
//    }
    /**
     * ElectronicsDAOImpl의 모든레코드 검색하는 메소드 호출
     */
    public static List<Electronics> selectAll() throws SQLException {

        return dao.selectAll();
    }
    /**
     * ElectronicsDAOImpl의 레코드 삽입하는 메소드 호출
     */
    public static int insert(Electronics electronics) throws SQLException {

        return dao.insert(electronics);
    }
    /**
     * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 검색하는 메소드 호출
     * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
     */
    public static Electronics selectByModelNum(String modelNum, boolean flag) throws SQLException {
        if(flag) {
            dao.increamentByReadnum(modelNum);
        }
        return dao.selectByModelNum(modelNum);
    }
    /**
     * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
     */
    public static int delete(String modelNum, String password) throws SQLException {

        return dao.delete(modelNum, password);
    }
    /**
     * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 수정  메소드 호출
     */
    public static int update(Electronics electronics) throws SQLException {
        Electronics selected = selectByModelNum(electronics.getModelNum(), false);
        if(electronics.getPassword().equals(selected.getPassword())){
            return dao.update(electronics);
        } else {
            throw new SQLException("비밀번호 일치하지 않음.");
        }
    }
}



