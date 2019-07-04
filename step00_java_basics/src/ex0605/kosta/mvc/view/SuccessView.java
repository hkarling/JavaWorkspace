package kosta.mvc.view;

import java.util.List;

import kosta.mvc.model.dto.BoardDTO;

public class SuccessView {
	
	public static void selectPrint(List<BoardDTO> list) {
		
		for(BoardDTO board : list)
			System.out.println(board);
	}
	
	public static void selectByNoPrint(BoardDTO board) {
		
		System.out.println(board);
	}
	
	public static void printMessage(String message) {
		
		System.out.println(message);
	}
	
}
