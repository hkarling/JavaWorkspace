package ex0605.kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import ex0605.kosta.mvc.model.dao.BoardDAO;
import ex0605.kosta.mvc.model.dao.BoardDAOImpl;
import ex0605.kosta.mvc.model.dto.BoardDTO;

public class BoardServiceImpl implements BoardService {

	BoardDAO dao = new BoardDAOImpl();

	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		List<BoardDTO> list = dao.boardSelectAll();

		if (list.isEmpty())
			throw new SQLException("해당 게시판에 게시물이 없습니다.");

		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		List<BoardDTO> list = dao.boardSelectBySubject(keyWord);

		if (list.isEmpty())
			throw new SQLException("키워드 '" + keyWord + "'에 해당하는 게시물이 존재하지 않습니다.");

		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {

		BoardDTO board = dao.boardSelectByNo(boardNo);
		
		if (board == null)
			throw new SQLException(boardNo + "번 게시물이 존재하지 않습니다.");
		
		return board;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws SQLException {

		if (dao.boardInsert(boardDTO) == 0)
			throw new SQLException("등록에 실패하였습니다.");
	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws SQLException {

		if (dao.boardUpdate(boardDTO) == 0)
			throw new SQLException(boardDTO.getBoardNo() + "번 게시물 수정에 실패하였습니다.");
	}

	@Override
	public void boardDelete(int boardNo) throws SQLException {

		if (dao.boardDelete(boardNo) == 0)
			throw new SQLException(boardNo + "번 게시물 삭제에 실패하였습니다.");
	}
}
