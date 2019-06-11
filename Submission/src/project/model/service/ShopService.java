package project.model.service;

import project.model.dto.ProductDTO;

import java.sql.SQLException;
import java.util.List;

public interface ShopService {

	/**
	 *
	 */
	int checkCustomerID(String id) throws SQLException;

	/**
	 * 재고 리스트를 받아온다.
	 */
	List<ProductDTO> getSelectAll() throws SQLException;
	
	/**
	 *  
	 */
	ProductDTO selectByName(String name) throws SQLException;
	
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
	int productDelete(int id) throws SQLException;
}
