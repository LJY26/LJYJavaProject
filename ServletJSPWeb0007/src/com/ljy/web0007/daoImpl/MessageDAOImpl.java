package com.ljy.web0007.daoImpl;

import com.ljy.web0007.bean.Message;
import com.ljy.web0007.dao.MessageDAO;
import com.ljy.web0007.util.DBConnectionUtil;
import com.ljy.web0007.util.Page;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAOImpl implements MessageDAO {

    public void addMessage(Message message) {
        Connection conn= DBConnectionUtil.getConnection();
        String addSQL="insert into tb_message(messageTitle,messageContent,employeeID,publishTime) values(?,?,?,?) ";
        PreparedStatement pstmt=null;
        try {
            pstmt=conn.prepareStatement(addSQL);
            pstmt.setString(1,message.getMessageTitle());
            pstmt.setString(2,message.getMessageContent());
            pstmt.setInt(3,message.getEmployeeID());
            pstmt.setTimestamp(4,new Timestamp(message.getPublishTime().getTime()));
            pstmt.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            DBConnectionUtil.close(pstmt);
            DBConnectionUtil.close(conn);
        }
    }

    public void updateMessage(Message message) {

    }

    public void deleteMessage(int messageID) {

    }

    public List<Message> findAllMessage(Page page) {
        Connection conn=DBConnectionUtil.getConnection();
        String findSQL="select * from tb_message order by publishTime desc limit ?,?";
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<Message> messages=new ArrayList<Message>();
        try {
            pstmt=conn.prepareStatement(findSQL);
            pstmt.setInt(1,page.getBaginIndex());
            pstmt.setInt(2,page.getEveryPage());
            rs=pstmt.executeQuery();
            while (rs.next()){
                Message message=new Message();
                message.setMessageID(rs.getInt(1));
                message.setMessageTitle(rs.getString(2));
                message.setMessageContent(rs.getString(3));
                message.setEmployeeID(rs.getInt(4));
                message.setPublishTime(rs.getTimestamp(5));
                messages.add(message);

            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        finally {
            DBConnectionUtil.close(rs);
            DBConnectionUtil.close(pstmt);
            DBConnectionUtil.close(conn);
        }
        return messages;
    }

    public Message findMessageById(int messageID) {
        Connection conn = DBConnectionUtil.getConnection();
        String querySQL  = "select * from tb_message where messageID = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Message message = null;
        try {
            pstmt = conn.prepareStatement(querySQL);
            pstmt.setInt(1, messageID);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                message = new Message();
                message.setMessageID(rs.getInt(1));
                message.setMessageTitle(rs.getString(2));
                message.setMessageContent(
                        rs.getString(3));
                message.setEmployeeID(rs.getInt(4));
                message.setPublishTime(rs.getTimestamp(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBConnectionUtil.close(rs);
            DBConnectionUtil.close(pstmt);
            DBConnectionUtil.close(conn);
        }
        return message;
    }

    public int findAllCount() {
        Connection conn = DBConnectionUtil.getConnection();
        String findSQL = "select count(*) from tb_message";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            pstmt = conn.prepareStatement(findSQL);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBConnectionUtil.close(rs);
            DBConnectionUtil.close(pstmt);
            DBConnectionUtil.close(conn);
        }
        return count;
    }
}
