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
        ResultSet rs = null;
        List<MemberDTO> list = new ArrayList<>();

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement("select * from member order by id");
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(rs, ps, conn);
        }
        return list;
    }

    @Override
    public List<MemberDTO> selectByKey(String keyField, String keyword) {
        return null;
    }

    @Override
    public int insert(MemberDTO memberDTO) {
        return 0;
    }

    @Override
    public boolean idCheck(String id) {
        return false;
    }

    @Override
    public MemberDTO selectById(String id) {
        return null;
    }

    @Override
    public int delete(String id) {
        return 0;
    }
}
