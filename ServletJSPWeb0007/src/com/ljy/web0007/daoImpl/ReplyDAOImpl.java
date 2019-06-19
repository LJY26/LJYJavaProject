package com.ljy.web0007.daoImpl;

import com.ljy.web0007.bean.Reply;
import com.ljy.web0007.dao.ReplyDAO;
import com.ljy.web0007.util.DBConnectionUtil;
import com.ljy.web0007.util.Page;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReplyDAOImpl implements ReplyDAO {
    @Override
    public void addReply(Reply reply) {
        Connection conn= DBConnectionUtil.getConnection();
        String addSQL="insert into tb_reply(replyContent,employeeID,replyTime,messageID) values(?,?,?,?)";
        PreparedStatement pstmt=null;
        try{
            pstmt=conn.prepareStatement(addSQL);
            pstmt.setString(1,reply.getReplyContent());
            pstmt.setInt(2,reply.getEmployeeID());
            pstmt.setTimestamp(3,new Timestamp(reply.getReplyTime().getTime()));
            pstmt.setInt(4,reply.getMessageID());
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnectionUtil.close(pstmt);
            DBConnectionUtil.close(conn);
        }
    }

    @Override
    public List<Reply> findReplyByMsgID(int messageID, Page page) {
        Connection conn=DBConnectionUtil.getConnection();
        String findSQL="select * from tb_reply where messageID=? limit ?,?";
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<Reply> replies=new ArrayList<Reply>();
        try{
            pstmt=conn.prepareStatement(findSQL);
            pstmt.setInt(1,messageID);
            pstmt.setInt(2,page.getBaginIndex());
            pstmt.setInt(3,page.getEveryPage());
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                Reply reply=new Reply();
                reply.setReplyID(rs.getInt(1));
                reply.setReplyContent(rs.getString(2));
                reply.setEmployeeID(rs.getInt(3));
                reply.setReplyTime(rs.getTimestamp(4));
                reply.setMessageID(rs.getInt(5));
                replies.add(reply);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnectionUtil.close(rs);
            DBConnectionUtil.close(pstmt);
            DBConnectionUtil.close(conn);
        }
        return replies;
    }

    @Override
    public int findCountByMsgID(int messageID) {
        Connection conn=DBConnectionUtil.getConnection();
        String findSQL="select count(*) from tb_reply where messageID=?";
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        int count=0;
        try {
            pstmt=conn.prepareStatement(findSQL);
            pstmt.setInt(1,messageID);
            rs=pstmt.executeQuery();
            if(rs.next()){
                count=rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnectionUtil.close(rs);
            DBConnectionUtil.close(pstmt);
            DBConnectionUtil.close(conn);
        }

        return count;
    }
}
