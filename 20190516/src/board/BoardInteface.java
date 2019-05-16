package board;

/**
 * Free, QA, Upload 게시판이 공통으로 가지는 기능 선택
 */
public interface BoardInteface {
	/**
	 * 등록
	 * @return : true이면 등록성공, false이면 등록실패
	 * @param: Board board
	 */
	boolean insert(Board board);
	
	/**
	 * 조건검색 (글번호에 해당하는 게시물 검색)
	 * @param int no
	 */
	Board searchByNo(int no);
}
