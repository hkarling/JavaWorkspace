package project.model.util;

import java.sql.*;

/**
 * DB연동을 위한 로드, 연결, 닫기
 */
public class DbUtil {

	/**
	 * DB연결에 필요한 DRIVER_NAME, URL, USER, PASS는 다른 interface에 정의해둔다.
	 */

	/** 로드 */
	static {
		try {
			Class.forName(DbProperty.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/** 연결 */
	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(DbProperty.URL, DbProperty.USER, DbProperty.PASS);
	}

	/** 닫기 (insert, update, delete - DML 전) */
	public static void close(Connection conn, Statement stmt) {

		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** 닫기 (select) 문 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {

		try {
			if (rs != null)
				rs.close();
			close(conn, stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
