package dao.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import util.DbUtil;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public int empInsert(EmpDTO dto) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		String query = "insert into emp(empno,ename,job,sal,hiredate) values(?,?,?,?,sysdate)";

		try {
			conn = DbUtil.getConnection();

			ps = conn.prepareStatement(query);
			ps.setInt(1, dto.getEmpno());
			ps.setString(2, dto.getEname());
			ps.setString(3, dto.getJob());
			ps.setInt(4, dto.getSal());

			result = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbUtil.close(conn, ps);
		}

		return result;
	}

	@Override
	public boolean duplicateByEmpno(int empno) {

		return false;
	}

	@Override
	public EmpDTO selectByEmpno(int empno) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmpDTO result = null;
		String query = "select empno,ename,job,sal,hiredate from emp where empno = ?";

		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, empno);
			rs = ps.executeQuery();
			if (rs.next())
				result = new EmpDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn, ps, rs);
		}

		return result;
	}

	@Override
	public List<EmpDTO> selectAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		String query = "select empno,ename,job,sal,hiredate from emp";

		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new EmpDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbUtil.close(conn, ps, rs);
		}

		return list;
	}

	@Override
	public int empDelete(int empno) {
       
		return 0;
	}

	@Override
	public int empUpdate(EmpDTO dto) {

		return 0;
	}
	
	/** 롤백용메서드 SAVEPOINT = P201906041850 */
	public void rollback() {
		try {
			Connection conn = DbUtil.getConnection();
	conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
