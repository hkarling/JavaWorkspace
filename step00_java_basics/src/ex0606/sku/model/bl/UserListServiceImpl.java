package ex0606.sku.model.bl;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import ex0606.sku.model.dao.UserListDAO;
import ex0606.sku.model.dao.UserListDAOImpl;
import ex0606.sku.model.dto.UserListDTO;

public class UserListServiceImpl implements UserListService{

	UserListDAO dao = new UserListDAOImpl();
	
	@Override
	public List<Vector<Object>> getSelectAll() throws SQLException {
		
		// DAO에서 리스트를 받아온다. 
		List<Vector<Object>> list = dao.getSelectAll();
		
		/** 리스트가 비어있다면 SQLException을 일으키고 메소드를 종료. */
		if(list.isEmpty())
			throw new SQLException("테이블이 비어있음.");
		
		return list;
	}

	@Override
	public boolean getCheckById(String id) throws SQLException {
		boolean result = dao.getCheckById(id);
		if(!result)
			throw new SQLException("중복된 아이디가 존재함.");
		
		return result; 
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
		int result = dao.userListDelete(ids);
		
		if(result == 0)
			throw new SQLException("삭제할 레코드가 없습니다.");
		return result;
	}

	@Override
	public List<Vector<Object>> getSearchUser(String keyField, String keyWord) throws SQLException {
		
		List<Vector<Object>> list = dao.getSearchUser(keyField, keyWord);

		if(list.isEmpty())
			throw new SQLException("레코드가 존재하지 않음.");
		
		return list;
	}

}
