package ex0516.board;

public class QaBoardImpl implements BoardInterface {

	@Override
	public boolean insert(Board board) {
		System.out.println("QaBoardImpl의 insert(Board board) 호출");
		return false;
	}

	@Override
	public Board searchByNo(int no) {
		System.out.println("QaBoardImpl의 searcyByNo(int no) 호출");
		return null;
	}

}
