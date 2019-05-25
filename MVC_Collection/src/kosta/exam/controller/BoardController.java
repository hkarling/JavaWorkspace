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
		
	}
	
	public static void getBoardByNo (String kind, int no) {
		
	}
	
	public static void insertBoard (String kind, Board board) {
		
	}
	
	public static void deleteBoard(String kind, int no) {
		
	}
	
	public static void updateBoard(Board board, String kind) {
		
	}
}
