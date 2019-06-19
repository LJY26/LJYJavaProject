package com.ljy.web0007.servlet;

import com.ljy.web0007.bean.Message;
import com.ljy.web0007.dao.MessageDAO;
import com.ljy.web0007.factory.MessageDAOFactory;
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

public class GetMessageList extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        int currentPage=0;
        String currentPageStr=request.getParameter("currentPage");
        if(currentPageStr==null||"".equals(currentPageStr)){
            currentPage=1;
        }else {
            currentPage=Integer.parseInt(currentPageStr);
        }

        MessageDAO messageDAO= MessageDAOFactory.getMessageDAOInstance();
        Page page= PageUtil.createPage(5,messageDAO.findAllCount(),currentPage);
        List<Message> messages=messageDAO.findAllMessage(page);
        request.setAttribute("messageList",messages);
        request.setAttribute("page",page);
        ServletContext servletContext=getServletContext();
        RequestDispatcher dispatcher=servletContext.getRequestDispatcher("/msgList.jsp");
        dispatcher.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        doGet(request,response);
    }
}

