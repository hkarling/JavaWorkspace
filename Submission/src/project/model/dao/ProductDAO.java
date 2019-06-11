package project.model.dao;

import project.model.dto.ProductDTO;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
	/**
	 * 재고목록 전체검색
	 * select * from product order by product_no
	 */
	List<ProductDTO> productSelectAll() throws SQLException;
	
	/**
	 * 상품번호에 따른 상품 검색
	 * select * from product where product_no=?
	 */
	ProductDTO productByName(String name) throws SQLException;
	
	/**
	 * 가격에 따른 술 검색
	 * select * from product where price between ? and ?
	 */
	List<ProductDTO> productByPrice(int price) throws SQLException;
	
	/**
	 * 카테고리에 따른 술 검색
	 * select * from product where category like ? 
	 */
	List<ProductDTO> productByCategory(String category) throws SQLException;
	
	/**
	 * 재고 등록하기
	 * insert into product (product_no, name, category, price, quantity) 
	 * values (?, ?, ?, ?, ?)
	 */
	int productInsert(ProductDTO productDTO) throws SQLException;
	
	/**
	 * 품목번호에 해당하는 수량 수정하기
	 * update product set quantity = ? where product_no = ?
	 */
	int productUpdate(ProductDTO productDTO) throws SQLException;
	
	/**
	 * 품목번호에 해당하는 레코드 삭제
	 * delete from product where product_no = ?
	 */
	int productDelete(int productNo) throws SQLException;
}
