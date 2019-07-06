package ex0524.kosta.exam.view;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import ex0524.kosta.exam.model.dto.*;

public class SuccessView {

	public SuccessView() {

	}

	public static void printBoard(Map<String, Map<String, Board>> map) {
		
		Set<String> allBoardKey = map.keySet();
		Iterator<String> allBoardIt = allBoardKey.iterator();

		while (allBoardIt.hasNext()) {
			String key = allBoardIt.next();
			Map<String, Board> submap = map.get(key);
			
			System.out.println("**********" + key + "Board 게시물 **********");
			Set<String> subKeys = submap.keySet();
			Iterator<String> it = subKeys.iterator();
//			while(it.hasNext()) {
//				System.out.println(submap.get(it.next()));
//			}
			
			Set<Entry<String, Board>> entry = submap.entrySet();
			for(Entry<String, Board> ent : entry) {
				System.out.println(ent.getValue());
			}
		}
	}

	public static void printByKind(String kind, Map<String, Board> map) {
		
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		System.out.println("**********" + kind + "Board 게시물 **********");
		while(it.hasNext()) {
			System.out.println(map.get(it.next()));
		}
	}

	public static void printBoardByNo(Board board) {
		System.out.println(board);
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}
}
