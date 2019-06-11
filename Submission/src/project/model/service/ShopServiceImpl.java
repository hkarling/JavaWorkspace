package project.model.service;

import project.model.dao.CustomerDAO;
import project.model.dao.CustomerDAOImpl;
import project.model.dao.ProductDAO;
import project.model.dao.ProductDAOImpl;
import project.model.dto.ProductDTO;

import java.sql.SQLException;
import java.util.List;

public class ShopServiceImpl implements ShopService {

	ProductDAO productDAO = new ProductDAOImpl();
	CustomerDAO customerDAO = new CustomerDAOImpl();

	@Override
	public int checkCustomerID(String id) throws SQLException {

		return 0;
	}

	@Override
	public List<ProductDTO> getSelectAll() throws SQLException {
		List<ProductDTO> list = productDAO.productSelectAll();
		if (list.isEmpty())
			throw new SQLException("테이블이 존재하지 않습니다.");
		return list;
	}

	@Override
	public ProductDTO selectByName(String name) throws SQLException {
		ProductDTO productDto = productDAO.productByName(name);
		if (productDto.getProductNo() == 0)
			throw new SQLException(name + " 제품이 없습니다.");
		return productDto;
	}

	@Override
	public int productInsert(ProductDTO product) throws SQLException {
		return productDAO.productInsert(product);
	}

	@Override
	public int productUpdate(ProductDTO product) throws SQLException {
		if (productDAO.productUpdate(product) == 0)
			throw new SQLException("게시물 번호가 존재하지 않습니다.");
		return productDAO.productUpdate(product);
	}

	@Override
	public int productDelete(int id) throws SQLException {
		if (productDAO.productDelete(id) == 0)
			throw new SQLException("게시물 번호가 존재하지 않으므로 삭제 실패하였습니다.");
		return productDAO.productDelete(id);
	}
}
