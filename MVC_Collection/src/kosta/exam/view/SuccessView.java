package kosta.exam.view;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import kosta.exam.model.dto.*;

public class SuccessView {

	public SuccessView() {

	}

	public static void printBoard(Map<String, Map<String, Board>> map) {
		Set<String> allBoardKey = map.keySet();
		Iterator<String> allBoardIt = allBoardKey.iterator();

		while (allBoardIt.hasNext()) {
			String key = allBoardIt.next();
			Map<String, Board> submap = map.get(key);
			System.out.println("**********" + key + "Board **********");
			Set<String> subKeys = submap.keySet();
			Iterator<String> it = subKeys.iterator();
			while(it.hasNext()) {
				System.out.println(submap.get(it.next()));
			}
		}
	}

	public static void printByKind(String str, Map<String, Board> map) {

	}

	public static void printBoardByNo(Board board) {

	}

	public static void printMessage(String message) {

	}
}
