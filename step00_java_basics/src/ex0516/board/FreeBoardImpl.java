package ex0516.board;

public class FreeBoardImpl implements BoardInterface {

	@Override
	public boolean insert(Board board) {
		System.out.println("FreeboardImpl의 insert(Board board) 호출");
		return false;
	}

	@Override
	public Board searchByNo(int no) {
		System.out.println("FreeboardImpl의 searcyByNo(int no) 호출");
		return null;
	}

	@Override
	public boolean delete(int no) {
		System.out.println("FreeboardImpl의 delete(int no) 호출");
		return true;
	}
}
