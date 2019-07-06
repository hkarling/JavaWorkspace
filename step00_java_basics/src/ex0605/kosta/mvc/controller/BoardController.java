package ex0605.kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import ex0605.kosta.mvc.model.dto.BoardDTO;
import ex0605.kosta.mvc.model.service.BoardService;
import ex0605.kosta.mvc.model.service.BoardServiceImpl;
import ex0605.kosta.mvc.view.FailView;
import ex0605.kosta.mvc.view.SuccessView;

public class BoardController {

	private static BoardService service = new BoardServiceImpl();

	public static void boardSelectByAll() {
		try {
			SuccessView.selectPrint(service.boardSelectAll());
		} catch (SQLException e) {
			FailView.errMessage(e.getMessage());
		}
	}

	public static void boardSelectBySubject(String subject) {
		try {
			SuccessView.selectPrint(service.boardSelectBySubject(subject));

		} catch (SQLException e) {
			FailView.errMessage(e.getMessage());
		}
	}

	public static void boardSelectByNo(int boardNo) {
		try {
			SuccessView.selectByNoPrint(service.boardSelectByNo(boardNo));
		} catch (SQLException e) {
			FailView.errMessage(e.getMessage());
		}
	}

	public static void boardInsert(BoardDTO boardDTO) {
		try {
			service.boardInsert(boardDTO);
			SuccessView.printMessage("게시물을 등록하였습니다.");

		} catch (SQLException e) {
			FailView.errMessage(e.getMessage());
		}
	}

	public static void boardUpdate(BoardDTO boardDTO) {
		try {
			service.boardUpdate(boardDTO);
			SuccessView.printMessage(boardDTO.getBoardNo() + "번 게시물을 수정하였습니다.");
		} catch (SQLException e) {
			FailView.errMessage(e.getMessage());
		}
	}

	public static void boardDelete(int boardNo) {

		try {
			service.boardDelete(boardNo);
			SuccessView.printMessage(boardNo + "번 게시물을 삭제하였습니다.");
		} catch (SQLException e) {
			FailView.errMessage(e.getMessage());
		}
	}
}
