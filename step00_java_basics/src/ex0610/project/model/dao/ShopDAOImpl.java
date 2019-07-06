package ex0610.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex0610.project.model.dto.ProductDTO;
import ex0610.util.DbUtil;

public class ShopDAOImpl implements ShopDAO {

	@Override
	public List<ProductDTO> productSelectAll() throws SQLException {
		List<ProductDTO> list = new ArrayList<>();
		String sql = "select * from product order by product_no";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list; 
	}
	
	@Override
	public ProductDTO productByName(String name) throws SQLException {
		ProductDTO dto = null;
		String sql = "select * from product where name=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return dto;
	}
	
	@Override
	public List<ProductDTO> productByPrice(int price) throws SQLException {
		List<ProductDTO> list = new ArrayList<>();
		String sql = "select * from product where price<=?"; 
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, price);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}
	
	@Override
	public List<ProductDTO> productByCategory (String category) throws SQLException {
		List<ProductDTO> list = new ArrayList<>();
		String sql = "select * from product where category like ? "; 
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+category+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}
	
	@Override
	public int productInsert(ProductDTO productDTO) throws SQLException{
		String sql = "insert into product (product_no, name, category, price, quantity)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,productDTO.getProductNo());
			ps.setString(2, productDTO.getProductName());
			ps.setString(3, productDTO.getCategory());
			ps.setInt(4, productDTO.getPrice());
			ps.setInt(5, productDTO.getQuantity());
			result = ps.executeUpdate();
		} finally {
			DbUtil.close(con, ps);
		}
		return result;
	}
	
	@Override
	public int productUpdate(ProductDTO productDTO) throws SQLException {
		String sql = "update product set quantity = ? where product_no = ?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,productDTO.getQuantity());
			ps.setInt(2, productDTO.getProductNo());
			result = ps.executeUpdate();
		} finally {
			DbUtil.close(con, ps);
		}
		return result;
	}
	
	@Override
	public int productDelete(int productNo) throws SQLException {
		String sql = "delete from product where product_no = ?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productNo);
			result = ps.executeUpdate();
		} finally {
			DbUtil.close(con, ps);
		}
		return result;
	}
}
