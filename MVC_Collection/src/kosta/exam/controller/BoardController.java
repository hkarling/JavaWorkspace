package kosta.exam.controller;

import java.util.Map;

import kosta.exam.model.dto.*;
import kosta.exam.model.service.*;
import kosta.exam.model.util.*;
import kosta.exam.view.*;

public class BoardController {

	private static BoardService boardService = BoardServiceImpl.getInstance();
	
	public BoardController() {

	}
	
	public static void getAllBoard() {
		try {
			Map<String, Map<String, Board>> allMap = boardService.getBoardList();
			
			SuccessView.printBoard(allMap);
		}catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		} 
	}
	
	public static void getBoardByKind(String kind) {
		try {
			Map<String, Board> map = boardService.getBoardByKind(kind);
			SuccessView.printByKind(kind, map);
		} catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}	
	}
	
	public static void getBoardByno (String kind, int no) {
		try {
			Board board = boardService.getBoardByNo(kind, no);
			SuccessView.printBoardByNo(board);
		} catch (InexistentException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void insertBoard (String kind, Board board) {
		try {
			boardService.insertBoard(kind, board);
			SuccessView.printMessage("등록이 성공하였습니다.");
		} catch (DuplicateException e) {
//			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		} catch (InexistentException e) {
//			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void deleteBoard(String kind, int no) {
		try {
			boardService.deleteBoard(kind, no);
			SuccessView.printMessage("삭제에 성공하였습니다.");
		} catch (InexistentException e) {
//			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void updateBoard(Board board, String kind) {
		try {
			boardService.updateBoard(board, kind);
			SuccessView.printMessage("수정에 성공하였습니다.");
		} catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
