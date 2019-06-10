package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DbUtil;

public class TransactionDAO {
	/**
	 * 계좌이체 기능 구현
	 */
	public void transfer(String inputAccount, String outputAccount, int money) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update bank set balance=balane-? where account = ?";
		try {
			conn = DbUtil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setString(2, outputAccount);
			int re = ps.executeUpdate();
			if (re > 0) {
				ps = conn.prepareStatement("update bank set balance=balane-? where account = ?");
				ps.setInt(1, money);
				ps.setString(2, inputAccount);
				
				re = ps.executeUpdate();
				if (re > 0) {
					
				} else {
					System.out.println("입금실패");
					conn.rollback();
				}
			} else {
				System.out.println("출금실패");
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DbUtil.close(conn, ps, rs);
		}

	}

	public static void main(String[] args) {
		TransactionDAO dao = new TransactionDAO();
		System.out.println("--1. 출금계좌 오류----");
		// dao.transfer("A02", "A05",200);//입금, 출금, 금액

		System.out.println("--2. 입금계좌 오류----");
		// dao.transfer("A04", "A01",200);//입금, 출금, 금액

		System.out.println("--3. 입금계좌의 총액 1000원 이상인경우----");
		// dao.transfer("A02", "A01",700);//입금, 출금, 금액

		System.out.println("--4. 성공----------");
		dao.transfer("A02", "A01", 100);// 입금, 출금, 금액
	}
}
