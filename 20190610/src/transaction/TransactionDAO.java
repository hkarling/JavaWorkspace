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
		// 로드 연결 실행 닫기
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // 입금완료후 입금계좌 총잔액 확인
		String sql = "update bank set balance=balance-? where account = ?";
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);// 자동커밋해지
			ps = con.prepareStatement(sql);
			// ?설정
			ps.setInt(1, money);// 인출금액
			ps.setString(2, outputAccount);// 출금계좌번호
			int re = ps.executeUpdate();
			if (re > 0) {// 인출이 성공했다면
				// 입금하기
				ps = con.prepareStatement("update bank set balance=balance+? where account =?");
				ps.setInt(1, money);
				ps.setString(2, inputAccount);

				re = ps.executeUpdate();
				if (re > 0) {// 입금 완료되었으니 총금액 확인
					ps = con.prepareStatement("select balance from bank where account=?");
					ps.setString(1, inputAccount);
					rs = ps.executeQuery();
					if (rs.next()) {
						int blance = rs.getInt(1);
						if (blance > 1000) {
							System.out.println("입금계좌 총액이 1000원을 초과하여 계좌이체 되지 않았습니다.");
							con.rollback();
						} else {
							System.out.println("계좌이체 성공하였습니다...");
							con.commit();
						}
					} else {
						System.out.println("총금액 확인하는 중에 문제가 발생하여 계좌이체 되지 않았습니다.");
						con.rollback();
					}

				} else {// 입금실패
					System.out.println("출금은 되었으나 입금이 실패되어 rollback합니다.- 계좌이체 실패");
					con.rollback();
				}
			} else {
				System.out.println("출금이 실패하여 계좌이체 되지 않았습니다.");
				con.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
	}

	public static void main(String[] args) {
		TransactionDAO dao = new TransactionDAO();
		System.out.println("--1. 출금계좌 오류----");
		dao.transfer("A02", "A05", 200);// 입금, 출금, 금액

		System.out.println("--2. 입금계좌 오류----");
		// dao.transfer("A04", "A01",200);//입금, 출금, 금액

		System.out.println("--3. 입금계좌의 총액 1000원 이상인경우----");
		// dao.transfer("A02", "A01",700);//입금, 출금, 금액

		System.out.println("--4. 성공----------");
		// dao.transfer("A02", "A01", 100);// 입금, 출금, 금액
	}
}
