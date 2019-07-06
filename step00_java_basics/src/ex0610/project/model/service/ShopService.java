package ex0610.project.model.service;

import java.sql.SQLException;
import java.util.List;

import ex0610.project.model.dto.ProductDTO;

public interface ShopService {

	
	/**
	 * 모든 목록 불러오기
	 * @return
	 * @throws SQLException
	 */
	List<ProductDTO> getSelectAll() throws SQLException;
	
	/**
	 *  
	 * */
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
