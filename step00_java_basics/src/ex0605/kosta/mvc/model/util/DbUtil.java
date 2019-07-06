package ex0605.kosta.mvc.model.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import ex0605.kosta.mvc.view.FailView;

/**
 * DB연동을 위한 로드, 연결, 닫기 및 쿼리 구문들.
 */
public class DbUtil {
	
	private static Properties proFile = new Properties();
	
	/** 로드 */
	static {
		try(FileInputStream fis = new FileInputStream("ex0605/properties/dbInfo.properties");
			FileInputStream fis2 = new FileInputStream("ex0605/properties/board.properties");) {
			
			proFile.load(fis);
			proFile.load(fis2);

			Class.forName(proFile.getProperty("driverName"));

		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			FailView.errMessage(e.getMessage());
		} catch (IOException e) {
//			e.printStackTrace();
			FailView.errMessage(e.getMessage());
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
			FailView.errMessage(e.getMessage());
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
//			e.printStackTrace();
			FailView.errMessage(e.getMessage());
		}
	}
}
