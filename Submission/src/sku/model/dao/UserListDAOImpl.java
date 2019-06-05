package sku.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import sku.model.dto.UserListDTO;
import sku.model.util.DbUtil;

public class UserListDAOImpl implements UserListDAO {

	@Override
	public List<Vector<Object>> getSelectAll() throws SQLException {
		
		String sql = "SELECT * FROM USERLIST";
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<Vector<Object>> list = new ArrayList<>();
		
		while(rs.next()) {
			Vector<Object> vector = new Vector<>();
			vector.add(rs.getString(1));
			vector.add(rs.getString(2));
			vector.add(rs.getInt(3));
			vector.add(rs.getString(4));
			list.add(vector);
		}
		return list;
	}

	@Override
	public boolean getCheckById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int userListInsert(UserListDTO userListDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userListUpdate(UserListDTO userListDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userListDelete(String id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userListDelete(String[] ids) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Vector<Object>> getSearchUser(String keyField, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}