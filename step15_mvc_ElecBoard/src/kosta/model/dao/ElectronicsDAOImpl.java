package kosta.model.dao;

import kosta.model.dto.Electronics;
import kosta.model.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ElectronicsDAOImpl implements ElectronicsDAO {
    @Override
    public List<Electronics> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Electronics> list = new ArrayList<>();

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement("SELECT * FROM ELECTRONICS");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Electronics(rs.getString("model_num"), rs.getString("model_name"),
                        rs.getInt("price"), rs.getString("description"),
                        rs.getString("password"), rs.getString("writeday"),
                        rs.getInt("readnum"), rs.getString("fname"),
                        rs.getInt("fsize")));
            }
        } finally {
            DbUtil.dbClose(rs, ps, conn);
        }
        return list;
    }

    @Override
    public Electronics selectByModelNum(String modelNum) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Electronics result = null;

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement("SELECT * FROM ELECTRONICS WHERE MODEL_NUM = ?");
            rs = ps.executeQuery();

            if (rs.next()) {
                result = new Electronics(rs.getString("model_num"), rs.getString("model_name"),
                        rs.getInt("price"), rs.getString("description"),
                        rs.getString("password"), rs.getString("writeday"),
                        rs.getInt("readnum"), rs.getString("fname"),
                        rs.getInt("fsize"));
            }
        } finally {
            DbUtil.dbClose(rs, ps, conn);
        }
        return result;
    }

    @Override
    public int insert(Electronics electronics) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement("INSERT INTO ELECTRONICS VALUES(?,?,?,?,?,SYSDATE,0,?,?)");
            ps.setString(1, electronics.getModelNum());
            ps.setString(2, electronics.getModelName());
            ps.setInt(3, electronics.getPrice());
            ps.setString(4, electronics.getDescription());
            ps.setString(5, electronics.getPassword());
            ps.setString(6,electronics.getFname());
            ps.setInt(7,electronics.getFsize());
            result = ps.executeUpdate();
        } finally {
            DbUtil.dbClose(ps, conn);
        }
        return result;
    }

    @Override
    public int delete(String modelNum, String password) throws SQLException {

        
        return 0;
    }

    @Override
    public int update(Electronics electronics) throws SQLException {
        return 0;
    }
}
