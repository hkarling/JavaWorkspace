package kosta.mvc.model.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * DB연동을 위한 로드, 연결, 닫기 및 쿼리 구문들.
 */
public class DbUtil {
	
	private static Properties proFile = new Properties();
	
	/** 로드 */
	static {
		try(FileInputStream fis = new FileInputStream("src/kosta/mvc/model/util/dbInfo.properties");
			FileInputStream fis2 = new FileInputStream("src/kosta/mvc/model/util/board.properties");) {
			proFile.load(fis);
			proFile.load(fis2);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Class.forName(proFile.getProperty("driverName"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/** 연결 */
	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(proFile.getProperty("url"), proFile.getProperty("userName"), proFile.getProperty("userPass"));
	}
	/** 프로파일 로딩 */
	public static Properties getProerties() {
		return proFile;
	}
	/** 닫기 (select) 문 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {

		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
