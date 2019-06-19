package com.ljy.web0007.daoImpl;

import com.ljy.web0007.bean.Criticism;
import com.ljy.web0007.dao.CriticismDAO;
import com.ljy.web0007.util.DBConnectionUtil;

import java.sql.*;

public class CriticismDAOImpl implements CriticismDAO {
    @Override
    public void addCriticism(Criticism criticism) {
        Connection conn= DBConnectionUtil.getConnection();
        String addSQL="insert into tb_criticism(criticismContent,employeeID,criticismTime,messageID) values(?,?,?,?)";
        PreparedStatement pstmt=null;
        try {
            pstmt=conn.prepareStatement(addSQL);
            pstmt.setString(1,criticism.getCriticismContent());
            pstmt.setInt(2,criticism.getEmployeeID());
            pstmt.setTimestamp(3,new Timestamp(criticism.getCriticismTime().getTime()));
            pstmt.setInt(4,criticism.getMessageID());
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnectionUtil.close(pstmt);
            DBConnectionUtil.close(conn);
        }
    }

    @Override
    public Criticism findCriticismByMsgID(int messageID) {
        Connection conn=DBConnectionUtil.getConnection();
        String findSQL="select * from tb_criticism where messageID=?";
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Criticism criticism=new Criticism();
        try{
            pstmt=conn.prepareStatement(findSQL);
            pstmt.setInt(1,messageID);
            rs=pstmt.executeQuery();
            if(rs.next()){
                criticism.setCriticismID(rs.getInt(1));
                criticism.setCriticismContent(rs.getString(2));
                criticism.setEmployeeID(rs.getInt(3));
                criticism.setCriticismTime(rs.getTimestamp(4));
                criticism.setMessageID(rs.getInt(5));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnectionUtil.close(rs);
            DBConnectionUtil.close(pstmt);
            DBConnectionUtil.close(conn);
        }
        return criticism;
    }
}
