package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.BoardDAO;
import kosta.mvc.model.dao.BoardDAOImpl;
import kosta.mvc.model.dto.BoardDTO;

public class BoardServiceImpl implements BoardService {

	BoardDAO dao = new BoardDAOImpl();
	
	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		
		return dao.boardSelectAll();
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {

		return dao.boardSelectBySubject(keyWord);
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {

		return dao.boardSelectByNo(boardNo);
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws SQLException {
		
		if(dao.boardInsert(boardDTO) == 0)
			throw new SQLException("등록에 실패하였습니다.");
	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws SQLException {
		
		if(dao.boardUpdate(boardDTO) == 0)
			throw new SQLException(boardDTO.getBoardNo() + "번 게시물 수정에 실패하였습니다.");
	}

	@Override
	public void boardDelete(int boardNo) throws SQLException {

		if(dao.boardDelete(boardNo) == 0)
			throw new SQLException(boardNo + "번 게시물 삭제에 실패하였습니다.");		
	}
}
