package com.ljy.web0007.servlet;

import com.ljy.web0007.bean.Employee;
import com.ljy.web0007.bean.Reply;
import com.ljy.web0007.dao.ReplyDAO;
import com.ljy.web0007.factory.ReplyDAOFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CommitReply extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        request.setCharacterEncoding("UTF-8");
        String replyContent=request.getParameter("replyContent");
        int messageID=Integer.parseInt(request.getParameter("messageID"));
        ServletContext servletContext=getServletContext();
        RequestDispatcher dispatcher=null;

        Employee employee=(Employee)request.getSession().getAttribute("employee");
        if(employee==null){
            request.setAttribute("error","要进行回复必须首先进行身份识别");
        }else {
            if(replyContent==null||"".equals(replyContent)){
                request.setAttribute("error","必须输入回复内容");
            }else{
                Reply reply=new Reply();
                reply.setReplyContent(replyContent);
                reply.setMessageID(messageID);
                reply.setEmployeeID(employee.getEmployeeID());
                reply.setReplyTime(new Date());
                ReplyDAO replyDAO= ReplyDAOFactory.getReplyDAOInstance();
                replyDAO.addReply(reply);
            }
        }
        dispatcher=servletContext.getRequestDispatcher("/GetMessage?messageID="+messageID);
        dispatcher.forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        doGet(request, response);
    }
}
