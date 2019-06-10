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

	/**
	 * 디비에 들어있는 전체 리스트를 받아온다.
	 */
	@Override
	public List<Vector<Object>> getSelectAll() throws SQLException {

		String sql = "SELECT * FROM USERLIST";
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Vector<Object>> list = new ArrayList<>();

		while (rs.next()) {
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
		String sql = "SELECT ID FROM USERLIST WHERE ID = ?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
			return false;
		else
			return true;
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

		String sql = "DELETE USERLIST WHERE ID IN (";
		for (int i = 0; i < ids.length; i++) {
			sql += "'" + ids[i] + "'";
			if (!(i == ids.length - 1))
				sql += ",";
		}
		sql += ")";
		System.out.println(sql);
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		int result = ps.executeUpdate();

		return result;
	}

	@Override
	public List<Vector<Object>> getSearchUser(String keyField, String keyWord) throws SQLException {

		List<Vector<Object>> list = new ArrayList<>();

		String sql = "";
		if (keyField.contentEquals("ALL")) {
			return this.getSelectAll();
		} else if (keyField.contentEquals("ID")) {
			sql = "SELECT * FROM USERLIST WHERE ID LIKE ?";
		} else if (keyField.contentEquals("name")) {
			sql = "SELECT * FROM USERLIST WHERE NAME LIKE ?";
		} else if (keyField.contentEquals("addr")) {
			sql = "SELECT * FROM USERLIST WHERE ADDR LIKE ?";
		}

		System.out.println(sql);

		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + keyWord + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Vector<Object> vector = new Vector<>();
			vector.add(rs.getString(1));
			vector.add(rs.getString(2));
			vector.add(rs.getInt(3));
			vector.add(rs.getString(4));
			list.add(vector);
		}

		System.out.println(list.size());

//		System.out.println(sql);
//		int result = ps.executeUpdate();

		return list;
	}

}
