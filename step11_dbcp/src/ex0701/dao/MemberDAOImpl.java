package ex0701.dao;

import ex0701.dto.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public List<MemberDTO> selectAll() {

        Connection conn = null;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        List<MemberDTO> list = new ArrayList<>();

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement("SELECT * FROM MEMBER ORDER BY JOIN_DATE");
            makeList(ps,list);
/*            rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String pwd = rs.getString(2);
                String name = rs.getString(3);
                int age = rs.getInt(4);
                String phone = rs.getString(5);
                String addr = rs.getString(6);
                String joinDate = rs.getString(7);

                list.add(new MemberDTO(id, pwd, name, age, phone, addr, joinDate));
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(null, ps, conn);
        }
        return list;
    }

    @Override
    public List<MemberDTO> selectByKey(String keyField, String keyword) {


        Connection conn = null;
        PreparedStatement ps = null;
        //ResultSet rs = null;

        String sql = "";
        List<MemberDTO> list = new ArrayList<>();

        if(keyField.equals("id")) {
            sql = "SELECT * FROM MEMBER WHERE ID LIKE ? ORDER BY JOIN_DATE";
        } else if(keyField.equals("name")) {
            sql = "SELECT * FROM MEMBER WHERE NAME LIKE ? ORDER BY JOIN_DATE";
        } else if(keyField.equals("addr")) {
            sql = "SELECT * FROM MEMBER WHERE ADDR LIKE ? ORDER BY JOIN_DATE";
        }

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+keyword+"%");
            makeList(ps, list);
 /*           rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String pwd = rs.getString(2);
                String name = rs.getString(3);
                int age = rs.getInt(4);
                String phone = rs.getString(5);
                String addr = rs.getString(6);
                String joinDate = rs.getString(7);

                list.add(new MemberDTO(id, pwd, name, age, phone, addr, joinDate));
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(null, ps, conn);
        }
        return list;

    }

    private void makeList(PreparedStatement ps, List<MemberDTO> list) throws SQLException {

        ResultSet rs = null;
        rs = ps.executeQuery();

        while (rs.next()) {
            String id = rs.getString(1);
            String pwd = rs.getString(2);
            String name = rs.getString(3);
            int age = rs.getInt(4);
            String phone = rs.getString(5);
            String addr = rs.getString(6);
            String joinDate = rs.getString(7);

            list.add(new MemberDTO(id, pwd, name, age, phone, addr, joinDate));
        }
    }
    @Override
    public int insert(MemberDTO memberDTO) {

        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement("INSERT INTO MEMBER VALUES(?,?,?,?,?,?,SYSDATE)");
            ps.setString(1, memberDTO.getId());
            ps.setString(2, memberDTO.getPwd());
            ps.setString(3, memberDTO.getName());
            ps.setInt(4, memberDTO.getAge());
            ps.setString(5, memberDTO.getPhone());
            ps.setString(6, memberDTO.getAddr());

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(ps, conn);
        }

        return result;
    }

    @Override
    public boolean idCheck(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn= DbUtil.getConnection();
            ps = conn.prepareStatement("SELECT ID FROM MEMBER WHERE ID = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();

            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(rs, ps, conn);
        }

        return false;
    }

    @Override
    public MemberDTO selectById(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MemberDTO memberDTO = null;

        try {
            conn= DbUtil.getConnection();
            ps = conn.prepareStatement("SELECT * FROM MEMBER WHERE ID = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();

            if(rs.next()) {
                memberDTO = new MemberDTO(rs.getString("id"), rs.getString("pwd"),
                        rs.getString("name"), rs.getInt("age"), rs.getString("phone"),
                        rs.getString("addr"), rs.getString("join_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(rs, ps, conn);
        }

        return memberDTO;
    }

    @Override
    public int delete(String id) {

        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement("DELETE FROM MEMBER WHERE ID = ?");
            ps.setString(1,id.trim());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(ps, conn);
        }
        return result;
    }
}
