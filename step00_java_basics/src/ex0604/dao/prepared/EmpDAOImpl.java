package ex0604.dao.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import ex0604.util.DbUtil;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public int empInsert(EmpDTO dto) {

		/** DB와의 연결을 위한 변수 선언. */
		Connection conn = null;
		PreparedStatement ps = null;
		/** 반환값 저장용 */
		int result = 0;

		/** 여기서 중복체크하는 메소드 불러서 확인하고 해당되면 0을 반환한다. */
		if(duplicateByEmpno(dto.getEmpno())){
			return result;
		}

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
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		String query = "select empno from emp where empno = ?";

		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, empno);
			rs = ps.executeQuery();

			result = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn, ps, rs);
		}

		return result;
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

		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM EMP WHERE EMPNO=?";
		int result = 0;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int empUpdate(EmpDTO dto) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE EMP SET ENAME=?, JOB=?, SAL=? WHERE EMPNO=?";
		int result = 0;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getEname());
			ps.setString(2, dto.getJob());
			ps.setInt(3, dto.getSal());
			ps.setInt(4, dto.getEmpno());
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}


	/** 편의를 위한 디비 재작성 쿼리 -_-.... 테스트할때마다 디비만들기 귀찮아서 만들었습니다... */
	public static void rollback() {
		Connection conn = null;
		PreparedStatement ps = null;
		String query[] = {"DROP TABLE EMP",
				"CREATE TABLE EMP(EMPNO NUMBER(4) NOT NULL,ENAME VARCHAR2(10),JOB VARCHAR2(9),MGR NUMBER(4),HIREDATE DATE,SAL NUMBER(7, 2),COMM NUMBER(7, 2),DEPTNO NUMBER(2))",
				"INSERT INTO EMP VALUES(7369,'SMITH','CLERK',7902,TO_DATE('17-12-1980','DD-MM-YYYY'),800,NULL,20)",
				"INSERT INTO EMP VALUES(7499,'ALLEN','SALESMAN',7698,TO_DATE('20-02-1981','DD-MM-YYYY'),1600,300,30)",
				"INSERT INTO EMP VALUES(7521,'WARD','SALESMAN',7698,TO_DATE('22-02-1981','DD-MM-YYYY'),1250,500,30)",
				"INSERT INTO EMP VALUES(7566,'JONES','MANAGER',7839,TO_DATE('02-04-1981','DD-MM-YYYY'),2975,NULL,20)",
				"INSERT INTO EMP VALUES(7654, 'MARTIN','SALESMAN',7698, TO_DATE('28-09-1981','DD-MM-YYYY'),1250,1400,30)",
				"INSERT INTO EMP VALUES(7698, 'BLAKE','MANAGER',7839,TO_DATE('01-05-1981','DD-MM-YYYY'),2850,NULL,30)",
				"INSERT INTO EMP VALUES(7782, 'CLARK','MANAGER',7839,TO_DATE('09-06-1981','DD-MM-YYYY'),2450,NULL,10)",
				"INSERT INTO EMP VALUES(7788, 'SCOTT','ANALYST',7566,TO_DATE('09-12-1982','DD-MM-YYYY'),3000,NULL,20)",
				"INSERT INTO EMP VALUES(7839, 'KING','PRESIDENT',NULL,TO_DATE('17-11-1981','DD-MM-YYYY'),5000,NULL,10)",
				"INSERT INTO EMP VALUES(7844, 'TURNER','SALESMAN',7698,TO_DATE('08-09-1981','DD-MM-YYYY'),1500,NULL,30)",
				"INSERT INTO EMP VALUES(7876, 'ADAMS','CLERK',7788,TO_DATE('12-01-1983','DD-MM-YYYY'),1100,NULL,20)",
				"INSERT INTO EMP VALUES(7900, 'JAMES','CLERK',7698,TO_DATE('03-12-1981','DD-MM-YYYY'),950,NULL,30)",
				"INSERT INTO EMP VALUES(7902, 'FORD','ANALYST',7566,TO_DATE('03-12-1981','DD-MM-YYYY'),3000,NULL,20)",
				"INSERT INTO EMP VALUES(7934, 'MILLER','CLERK',7782,TO_DATE('23-01-1982','DD-MM-YYYY'),1300,NULL,10)"};
		try {
			conn = DbUtil.getConnection();
			for(String str : query) {
				ps = conn.prepareStatement(str);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn, ps);
		}
	}
}
