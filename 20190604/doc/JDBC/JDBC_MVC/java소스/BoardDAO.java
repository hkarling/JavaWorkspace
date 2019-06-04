package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.BoardDTO;

public interface BoardDAO {
	/**
	 * ���ڵ� ��ü�˻�
	 */
	List<BoardDTO> boardSelectAll() throws SQLException;
	
	/**
	 * ���� Ư�� ���ڿ��� ���Ե� ���ڵ� �˻�
	 * select * from board where subject like ?
	 */
	List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException;
	
	/**
	 * �۹�ȣ�� �ش��ϴ� ���ڵ� �˻�
	 * select * from board where board_no = ? 
	 */
	BoardDTO boardSelectByNo(int boardNo) throws SQLException;
	
	/**
	 * �Խù� ����ϱ�
	 * insert into board (board_no, subject, writer, content, board_date) 
	 * values (board_seq.nextval, ?, ?, ?, sysdate)
	 */
	int boardInsert(BoardDTO boardDTO) throws SQLException;
	
	/**
	 * �۹�ȣ�� �ش��ϴ� �Խù� ���� �����ϱ�
	 * update board set content = ? where board_no = ?
	 */
	int boardUpdate(BoardDTO boardDTO) throws SQLException;
	
	/**
	 * �۹�ȣ�� �ش��ϴ� ���ڵ� ����
	 * delete from board where board_no = ?
	 */
	int boardDelete(int boardNo) throws SQLException;
	
}
