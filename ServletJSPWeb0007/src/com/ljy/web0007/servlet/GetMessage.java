package com.ljy.web0007.servlet;

import com.ljy.web0007.bean.Criticism;
import com.ljy.web0007.bean.Message;
import com.ljy.web0007.bean.Reply;
import com.ljy.web0007.dao.CriticismDAO;
import com.ljy.web0007.dao.MessageDAO;
import com.ljy.web0007.dao.ReplyDAO;
import com.ljy.web0007.factory.CriticismDAOFactory;
import com.ljy.web0007.factory.MessageDAOFactory;
import com.ljy.web0007.factory.ReplyDAOFactory;
import com.ljy.web0007.util.Page;
import com.ljy.web0007.util.PageUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetMessage extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        int messageID=Integer.parseInt(request.getParameter("messageID"));

        MessageDAO messageDAO= MessageDAOFactory.getMessageDAOInstance();
        Message message=messageDAO.findMessageById(messageID);
        request.setAttribute("message",message);

        //获得该消息对应的所有回复
        int currentPage=0;
        String currentPageStr=request.getParameter("currentPage");

        if(currentPageStr==null||"".equals(currentPageStr)){
            currentPage=1;
        }else {
            currentPage=Integer.parseInt(currentPageStr);
        }

        ReplyDAO replyDAO= ReplyDAOFactory.getReplyDAOInstance();
        Page page= PageUtil.createPage(5,replyDAO.findCountByMsgID(messageID),currentPage);
        List<Reply> replies=replyDAO.findReplyByMsgID(messageID,page);

        request.setAttribute("replyList",replies);
        request.setAttribute("page",page);

        CriticismDAO criticismDAO= CriticismDAOFactory.getCriticismDAOInstance();
        Criticism criticism=criticismDAO.findCriticismByMsgID(messageID);
        request.setAttribute("criticism",criticism);

        ServletContext servletContext=getServletContext();
        RequestDispatcher dispatcher=servletContext.getRequestDispatcher("/showMsg.jsp");
        dispatcher.forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        doGet(request,response);
    }
}
