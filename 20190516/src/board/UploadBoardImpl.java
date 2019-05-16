package board;

public class UploadBoardImpl implements BoardInterface {

	@Override
	public boolean insert(Board board) {
		System.out.println("UploadBoardImpl의 insert(Board board) 호출");
		return false;
	}

	@Override
	public Board searchByNo(int no) {
		System.out.println("UploadBoardImpl의 searcyByNo(int no) 호출");
		return null;
	}

}
