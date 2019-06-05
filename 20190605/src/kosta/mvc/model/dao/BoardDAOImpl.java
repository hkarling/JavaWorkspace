package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.util.DbUtil;

public class BoardDAOImpl implements BoardDAO {
	
	private Properties proFile = DbUtil.getProerties();

	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(proFile.getProperty("board.selectAll"));
		ResultSet rs = ps.executeQuery();
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		/* 레코드의 숫자만큼 BoardDTO를 생성하여 반환할 리스트에 저장한다. */
		while(rs.next()) {
			list.add(new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
		}
		
		DbUtil.close(conn, ps, rs);
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(proFile.getProperty("board.selectBySubject"));
		ps.setString(1, "%"+keyWord+"%");
		
		ResultSet rs = ps.executeQuery();
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		/* 레코드의 숫자만큼 BoardDTO를 생성하여 반환할 리스트에 저장한다. */
		while(rs.next())
			list.add(new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));

		DbUtil.close(conn, ps, rs);
		
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(proFile.getProperty("board.selectByNo"));
		ps.setInt(1, boardNo);
		ResultSet rs = ps.executeQuery();
		BoardDTO result = null;
		
		/* 항목이 있으면 반환할 결과에 넣어준다. */
		if(rs.next())
			result = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
		
		DbUtil.close(conn, ps, rs);

		return result;
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(proFile.getProperty("board.insert"));
		ps.setString(1, boardDTO.getSubject());
		ps.setString(2, boardDTO.getWriter());
		ps.setString(3, boardDTO.getContent());

		int result = ps.executeUpdate();
		
		DbUtil.close(conn, ps, null);

		return result;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(proFile.getProperty("board.updateByNo"));
		ps.setString(1, boardDTO.getContent());
		ps.setInt(2, boardDTO.getBoardNo());

		int result = ps.executeUpdate();
		
		DbUtil.close(conn, ps, null);

		return result;
	}

	@Override
	public int boardDelete(int boardNo) throws SQLException {
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(proFile.getProperty("board.deleteByNo"));
		ps.setInt(1, boardNo);
		
		int result = ps.executeUpdate();

		DbUtil.close(conn, ps, null);

		return result;
	}
	
	/** 기본값 세팅을 위한 디비 셋업 함수. */
	public static void rollback() {
		String queries[] = {
				"DROP SEQUENCE BOARD_SEQ",
				"CREATE SEQUENCE BOARD_SEQ NOCACHE", 
				"DROP TABLE BOARD",
				"CREATE TABLE BOARD(BOARD_NO INT PRIMARY KEY,SUBJECT VARCHAR2(30) NOT NULL,WRITER VARCHAR2(20) NOT NULL,CONTENT VARCHAR2(50) NOT NULL,BOARD_DATE DATE NOT NULL)", 
				"INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,'db수업','장희정','잼난다',SYSDATE)",
				"INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,'제목 1','저자 1','살려줘',SYSDATE)", 
				"INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,'제목 2','저자 2','졸려어어어',SYSDATE)"
		};
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtil.getConnection();
			
			for(String query : queries) {
				ps = conn.prepareStatement(query);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn, ps, null);			
		}
	}
}
