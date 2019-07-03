package kosta.model.dao;

import kosta.model.dto.Electronics;

import java.sql.SQLException;
import java.util.List;

public interface ElectronicsDAO {
	 /**
	  * 레코드 전체 검색
	  * */
	  List<Electronics> selectAll() throws SQLException;
	  
	  /**
		  * 모델번호에 해당하는 레코드 검색
		  * @param : boolean flag - true이면 조회수 증가,  false이면 조회증가 안함.
		  * */
	  Electronics selectByModelNum(String modelNum) throws SQLException;
	  
	/**
	 * 레코드 삽입
	 * @return : 1-삽입성공 , 0 - 삽입실패
	 * */
	  int insert(Electronics electronics) throws SQLException;
	  
	  /**
	   * 모델번호에 해당하는 레코드 삭제
	   * @return : 1-삭제성공 , 0 - 삭제실패
	   * */
	  int delete(String modelNum, String password) throws SQLException;
	  
	   /**
	    * 모델번호에 해당하는 레코드 수정
	    * @return : 1-수정성공 , 0 - 수정실패
	    * */
	  int update(Electronics electronics) throws SQLException;
}
