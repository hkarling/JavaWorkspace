package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.BoardDTO;

public interface BoardService {
	/**
	 * ��� ���ڵ� �˻�
	 */
	List<BoardDTO> boardSelectAll() throws SQLException;

	/**
	 * ���� Ư�����ڿ� ������ ���ڵ� �˻�
	 */
	List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException;

	/**
	 * �۹�ȣ�� �ش��ϴ� ���ڵ� �˻�
	 */
	BoardDTO boardSelectByNo(int boardNo) throws SQLException;

	/**
	 * �Խù� ��� (����ϱ� ����, �۹�ȣ �ߺ�üũ - boardSelectByNo(int boardNo))
	 */
	void boardInsert(BoardDTO boardDTO) throws SQLException;

	/**
	 * �Խù� ����
	 */
	void boardUpdate(BoardDTO boardDTO) throws SQLException;

	/**
	 * �Խù� ����
	 */
	void boardDelete(int boardNo) throws SQLException;
}
