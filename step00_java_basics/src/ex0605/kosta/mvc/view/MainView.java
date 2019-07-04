package kosta.mvc.view;

import kosta.mvc.controller.BoardController;
import kosta.mvc.model.dao.BoardDAOImpl;
import kosta.mvc.model.dto.BoardDTO;

public class MainView {

	public static void main(String[] args) {
		
//		MenuView.menuChoice();
		
		
		System.out.println("********** [1] 모든 게시물 검색 ******************");
		BoardController.boardSelectByAll();		
		
		System.out.println();
	
		System.out.println("********** [2] Board에서 게시글 번호에 해당하는 게시물 검색 *********");
		System.out.println("1. 존재하는 게시글 검색인 경우의 실행 결과 ");
		BoardController.boardSelectByNo(2); //존재하는 게시물
		
		System.out.println();
		
		System.out.println("2. 미 존재하는 게시글 검색인 경우의 실행 결과");
		BoardController.boardSelectByNo(300);// 없는 게시물
		
		System.out.println();
		
		
		System.out.println("********** [3] 게시물 제목이 포함된 모든 게시글들 검색 ******************");
		System.out.println("1. 존재하는 게시글 검색인 경우의 실행 결과 ");
		BoardController.boardSelectBySubject("db수업");
		
		System.out.println();
		
		System.out.println("2. 미 존재하는 게시글 검색인 경우의 실행 결과");
		BoardController.boardSelectBySubject("java");
	
		System.out.println();
		
	
	    System.out.println("********** [4] 게시물 등록 *************");
		BoardController.boardInsert(new BoardDTO("Java기본문법", "이나영", "요약정리학습", null));//글번호 없는 게시물등록
		BoardController.boardInsert(new BoardDTO("WEB", "천송이", "초보개발자기초학습", null));//글번호 없는 게시물등록
		
		System.out.println();
		
		
		System.out.println("********** [5] 게시물 수정 *************");
		System.out.println("1. 게시물이 존재하는 경우 실행결과  ");
		BoardController.boardUpdate(new BoardDTO(2,null,null, "myBatis수업",null));//글번호 있는 게시물 수정
//		BoardController.boardUpdate(2, "myBatis수업");//글번호 있는 게시물 수정

		BoardController.boardSelectByNo(2); //존재하는 게시물

		System.out.println();
		System.out.println("2. 게시물이 존재하지 않는 경우 실행결과 ");
		BoardController.boardUpdate(new BoardDTO(300,null,null,"myBatis수업", null));//글번호 없는 게시물 수정
//		BoardController.boardUpdate(50, "myBatis수업" );//글번호 없는 게시물 수정
		
		System.out.println();
		
	
		System.out.println("********** [6] 게시물 삭제 *************");
		System.out.println("1. 게시물이 존재하는 경우 삭제  ");
		BoardController.boardDelete(3);
		
		System.out.println();
		System.out.println("2. 게시물이 존재하지 않는 경우 삭제");
		BoardController.boardDelete(300);
		
		System.out.println();

		BoardController.boardSelectByAll();		
		/* */
		BoardDAOImpl.rollback();
	}
}






