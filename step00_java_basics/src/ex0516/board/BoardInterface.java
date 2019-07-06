package ex0516.board;

/**
 * Free, QA, Upload 게시판이 공통으로 가지는 기능 선택
 */
public interface BoardInterface {
	/**
	 * 등록
	 * 
	 * @return : true이면 등록성공, false이면 등록실패
	 * @param: Board board
	 */
	boolean insert(Board board);

	/**
	 * 조건검색 (글번호에 해당하는 게시물 검색)
	 * 
	 * @param int no
	 */
	Board searchByNo(int no);

	/**
	 * 1.8 version에서 추가된 문법: abstract가 아니므로 method body가 같이 정의된다.
	 * - 1) default 메소드: 기능 구현가능, 반드시 구현객체가 있어야만 접근(호출) 가능하다.
	 * - 2) static 메소드: 기능 구현가능, 구현 객체가 없이 호출가능하다.
	 * 			ex) 인터페이스이름.메소드이름(값, 값...)
	 * - 추가된 이유: 유지보수 측면에서 이미 개발된 상태에서 특정 interface에 메소드가 추가되면 이미
	 * 구현된 모든 구현 클래스에서 재정의해야하는 번거로움이 있다. default나 static을 만들면 구현클래스에서만
	 * 재정의하면 된다. 또한 모든 구현객체가 공통으로 가져야하는 기능이 있다면 default메소드나 static메소드로
	 * 정의해 놓고 호출해서 사용하면 된다. 다른 기능을 하고싶은 구현객체만 overriding한다.
	 */
	
	/**
	 * 삭제하기 
	 */
	default boolean delete(int no) {
		System.out.println(no + "의 게시물이 삭제되었습니다.");
		return true;
	}
	
	/**
	 * 수정하기
	 */
	static void update() {
		System.out.println("수정되었습니다.");
	}
}
