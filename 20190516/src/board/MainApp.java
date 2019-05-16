package board;

public class MainApp {

	public static void main(String[] args) {

		// 필드를 이용한 다형성
		BoardInterface boardInterface = null;

		System.out.println("1. FreeBoard 게시판.....");
		boardInterface = new FreeBoardImpl();
		test(boardInterface);
		
		System.out.println("\n2. QaBoard 게시판.....");
		boardInterface = new QaBoardImpl();
		test(boardInterface);
		
		System.out.println("\n3. UploadBoard 게시판.....");
		boardInterface = new UploadBoardImpl();
		test(boardInterface);
		
		
	}

	/**
	 * 각 게시판에 검색, 등록을 호출해주는 메소드 작성.
	 */
	public static void test(BoardInterface boardInterface) { // Free, Qa, Upload: 매개변수를 이용한 다형성
		boardInterface.insert(new Board());
		boardInterface.searchByNo(10);
		
		// default와 static을 호출해보장.
		boardInterface.delete(10);
		BoardInterface.update();
	}
}
