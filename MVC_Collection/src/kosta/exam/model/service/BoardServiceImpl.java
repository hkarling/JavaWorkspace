package kosta.exam.model.service;

import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import kosta.exam.model.dto.ArchiveBoard;
import kosta.exam.model.dto.Board;
import kosta.exam.model.dto.PhotoBoard;
import kosta.exam.model.util.DuplicateException;
import kosta.exam.model.util.InexistentException;

public class BoardServiceImpl implements BoardService {
	Map<String, Map<String, Board>> allBoardList = new TreeMap<String, Map<String, Board>>();;

	private static BoardServiceImpl instance = new BoardServiceImpl();

	private BoardServiceImpl() {
		Map<String, Board> photoMap = new TreeMap<>();
		Map<String, Board> archiveMap = new TreeMap<>();

		// 데이터 초기화 작업
		String filepath = "kosta/exam/model/service/photoInfo";

		/** 1. ~.properties 파일을 읽어서 key와 value를 분리 */
		ResourceBundle rb = ResourceBundle.getBundle(filepath);
		Iterator<String> keys = rb.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			String value = rb.getString(key);

			/** 2. value를 콤마를 기준으로 분리 */
			String[] data = value.split(",");

			// 3. 분리된 데이터를 Board객체로 만든다.
			Board board = new PhotoBoard(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]);

			// 4. map에 저장한다.
			photoMap.put(key, board);
		}

		filepath = "kosta/exam/model/service/archiveInfo";
		rb = ResourceBundle.getBundle(filepath);
		keys = rb.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			String value = rb.getString(key);

			/** 2. value를 콤마를 기준으로 분리 */
			String[] data = value.split(",");

			/** 3. 분리된 데이터를 Board객체로 만든다. */
			Board board = new ArchiveBoard(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5],
					Integer.parseInt(data[6]));

			/** 4. map에 저장한다. */
			archiveMap.put(key, board);
		}

		/** 전체 맵에 저장 */
		allBoardList.put("photo", photoMap);
		allBoardList.put("archive", archiveMap);
	}

	public static BoardServiceImpl getInstance() {

		return instance;
	}

	@Override
	public Map<String, Map<String, Board>> getBoardList() throws InexistentException {

		return allBoardList;
	}

	@Override
	public Map<String, Board> getBoardByKind(String kind) throws InexistentException {

		Map<String, Board> map = allBoardList.get(kind);
		
		if(map == null)
			throw new InexistentException(kind + " 유형의 게시판이 존재하지 않습니다.");	
		return map;
	}

	@Override
	public Board getBoardByNo(String kind, int no) throws InexistentException {
		
		Map<String, Board> map = getBoardByKind(kind);
		Board board = map.get(Integer.toString(no));

		if(board == null)
			throw new InexistentException(kind + "게시판의 " + no + "번 게시물이 존재하지 않습니다.");
		return board;
	}

	@Override
	public void insertBoard(String kind, Board board) throws DuplicateException, InexistentException {
		
		Map<String, Board> map = getBoardByKind(kind);
		
		String key = Integer.toString(board.getNo());
		
		if(map.containsKey(key))
			throw new DuplicateException(kind + "게시판의 " + key + "번 게시물이 존재합니다.");
		
		map.put(key, board);
	}

	
	@Override
	public boolean duplicateByNo(String kind, int no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteBoard(String kind, int no) throws InexistentException {

		Map<String, Board> map = getBoardByKind(kind);
		if(!map.containsKey(Integer.toString(no)))
			throw new InexistentException(kind +"게시판에 " + no + "번 게시물이 존재하지 않습니다.");
		
		map.remove(Integer.toString(no));
	}

	@Override
	public void updateBoard(Board board, String kind) throws InexistentException {
		// TODO Auto-generated method stub

	}

	private void propertiesFileStore(String kind, Board board) {
		
	}
}
