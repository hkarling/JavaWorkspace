package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.service.BoardService;
import kosta.mvc.model.service.BoardServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class BoardController {
	
	private static BoardService service = new BoardServiceImpl();
	
	public static void boardSelectByAll() {
		try {
			List<BoardDTO> list = service.boardSelectAll();
			if(!list.isEmpty())
				SuccessView.selectPrint(list);
			else
				FailView.errMessage("해당 게시판에 게시물이 없습니다.");
		} catch (SQLException e) {
//			e.printStackTrace();
			FailView.errMessage("불러오는데 실패하였습니다.");
		}
	}
	
	public static void boardSelectBySubject(String subject) {
		try {
			List<BoardDTO> list = service.boardSelectBySubject(subject);
			if(!list.isEmpty())
				SuccessView.selectPrint(list);
			else
				FailView.errMessage("키워드 '"+ subject + "'에 해당하는 게시물이 존재하지 않습니다.");
		} catch (SQLException e) {
//			e.printStackTrace();
			FailView.errMessage("불러오는데 실패하였습니다.");
		}	
	}
	
	public static void boardSelectByNo(int boardNo) {
		try {
			BoardDTO board = service.boardSelectByNo(boardNo);
			if(board != null)
				SuccessView.selectByNoPrint(board);
			else
				FailView.errMessage(boardNo + "번 게시물이 존재하지 않습니다.");
		} catch (SQLException e) {
//			e.printStackTrace();
			FailView.errMessage("불러오는데 실패하였습니다.");
		}		
	}
	
	public static void boardInsert(BoardDTO boardDTO) {
		try {
			service.boardInsert(boardDTO);
			SuccessView.printMessage("게시물을 등록하였습니다.");
			
		} catch (SQLException e) {
//			e.printStackTrace();
			FailView.errMessage(e.getMessage());
		}
	}
	
	public static void boardUpdate(BoardDTO boardDTO) {
		try {
			service.boardUpdate(boardDTO);
			SuccessView.printMessage(boardDTO.getBoardNo() + "번 게시물을 수정하였습니다.");
		} catch (SQLException e) {
//			e.printStackTrace();
			FailView.errMessage(e.getMessage());
		}
	}
	
	public static void boardDelete(int boardNo) {
		
		try {
			service.boardDelete(boardNo);
			SuccessView.printMessage(boardNo + "번 게시물을 삭제하였습니다.");
		} catch (SQLException e) {
//			e.printStackTrace();
			FailView.errMessage(e.getMessage());
		}
	}
}
