package ex0701.dao;

import ex0701.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {

    /**
     *  1.전체검색
     *  select * from member order by id
     */
    List<MemberDTO> selectAll();

    /**
     * 2.조건검색
     * -- id
     * select * from member where id like ?
     * -- name
     * select * from member where name like ?
     * -- addr
     * select * from member where addr like ?
     */
    List<MemberDTO> selectByKey(String keyField, String keyword);

    /**
     * 3.등록하기
     * insert into member values(?,?,?,?,?,?,sysdate);
     */
    int insert(MemberDTO memberDTO);

    /**
     * 4.등록전에 id 중복체크하기
     * select * from member where id = ?
     * @return true 이면 중복, false 이면 중복아님
     */
    boolean idCheck(String id);

    /**
     * 5.id에 해당하는 정보검색 (상세페이지)
     * select * from member where id = ?
     */
    MemberDTO selectById(String id);
}
