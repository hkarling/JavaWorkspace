package project.service;

import java.sql.SQLException;
import java.util.List;

import project.dao.ShopDAOImpl;
import project.dao.ShopDAO;
import project.dto.ProductDTO;

public class ShopServiceImpl implements ShopService {

	ShopDAO ShopDAO = new ShopDAOImpl();

	@Override
	public List<ProductDTO> getSelectAll() throws SQLException {
		List<ProductDTO> list = ShopDAO.productSelectAll();
		if (list.isEmpty())
			throw new SQLException("테이블이 존재하지 않습니다.");
		return list;
	}

	@Override
	public ProductDTO selectByName(String name) throws SQLException {
		ProductDTO productDto = ShopDAO.productByName(name);
		if (productDto.getProductNo() == 0)
			throw new SQLException(name + " 제품이 없습니다.");
		return productDto;
	}

	@Override
	public int productInsert(ProductDTO product) throws SQLException {
		return ShopDAO.productInsert(product);
	}

	@Override
	public int productUpdate(ProductDTO product) throws SQLException {
		if (ShopDAO.productUpdate(product) == 0)
			throw new SQLException("게시물 번호가 존재하지 않습니다.");
		return ShopDAO.productUpdate(product);
	}

	@Override
	public int productDelete(int id) throws SQLException {
		if (ShopDAO.productDelete(id) == 0)
			throw new SQLException("게시물 번호가 존재하지 않으므로 삭제 실패하였습니다.");
		return ShopDAO.productDelete(id);
	}

}
