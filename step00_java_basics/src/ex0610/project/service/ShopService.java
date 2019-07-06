package ex0610.project.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import ex0610.project.model.dto.ProductDTO;

public interface ShopService {

	
	/**
	 * 모든 목록 불러오기
	 * @return
	 * @throws SQLException
	 */
	List<ProductDTO> getSelectAll() throws SQLException;
	
	/**
	 *  Id 중복체크 하기
	 *   @return : true이면 중복, false이면 중복아님.
	 * */
	boolean getCheckById(String id) throws SQLException;
	
	/**
	 * 물품 등
	 * */
	int productInsert(ProductDTO product)throws SQLException;
	
	/**
	 * 수정하기
	 * (ID에 해당하는 물품 수량 수정) 
	 * */
	int productUpdate(ProductDTO product)throws SQLException;
	
	/**
	 * 삭제하기
	 * (ID에 해당하는 레코드 삭제)
	 * */
	int productDelete(String id) throws SQLException;
	
	/**
	 * 고객이 구매를 요청했을 때 수량을 판별해서 구매가 가능할경우 진행을 하고 불가능할경우 SQLException을 발생시
	 * 
	 */
	int productPurchase(String id, int quantity) throws SQLException;
	
	
}
