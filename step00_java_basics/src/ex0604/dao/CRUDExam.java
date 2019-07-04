package dao;

import java.sql.*;

import util.DbUtil;

public class CRUDExam {

	/** 전체 검색하기 */
	public void selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			/** 연결 */
			conn = DbUtil.getConnection();
			
			/** 실행 */
			stmt = conn.createStatement();
			//stmt.executeUpdate(sql);
			rs = stmt.executeQuery("SELECT EMPNO, ENAME, JOB, SAL, HIREDATE FROM EMP ORDER BY SAL DESC");
			
			while(rs.next()) {
				System.out.print(rs.getInt(1) + " | ");
				System.out.print(rs.getString(2) + " | ");
				System.out.print(rs.getString(3) + " | ");
				System.out.print(rs.getInt(4) + " | ");
				System.out.println(rs.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 닫기
			DbUtil.close(conn, stmt, rs);
		}
	}
	
	
	/** 사원번호로 검색하기 */
	public void searchByEmpno(int empno) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			/** 연결 */
			conn = DbUtil.getConnection();
			
			/** 실행 */
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT EMPNO, ENAME, JOB, SAL, HIREDATE FROM EMP WHERE EMPNO = " + empno);
			
			if(rs.next()) {
				System.out.print(rs.getInt(1) + " | ");
				System.out.print(rs.getString(2) + " | ");
				System.out.print(rs.getString(3) + " | ");
				System.out.print(rs.getInt(4) + " | ");
				System.out.println(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 닫기
			DbUtil.close(conn, stmt, rs);
		}
	}
	
	/** PreparedStatment */
}
