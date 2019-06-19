package com.ljy.web0007.servlet;

import com.ljy.web0007.bean.Criticism;
import com.ljy.web0007.bean.Employee;
import com.ljy.web0007.dao.CriticismDAO;
import com.ljy.web0007.factory.CriticismDAOFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CommitCriticism extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("gbk");
        String criticismContent = request.getParameter("criticismContent");//获得用户输入的回复内容
        int messageID = Integer.parseInt(request.getParameter("messageID"));
        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = null;
        //是哪个领导发布的批复
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        if (employee == null) {
            request.setAttribute("error", "要进行批复必须首先进行身份识别");
        } else {
            if (criticismContent == null || "".equals(criticismContent)) { //如果用户没有输入标题
                request.setAttribute("error", "必须输入批复内容");
            } else {
                Criticism criticism = new Criticism();
                criticism.setCriticismContent(criticismContent);
                criticism.setEmployeeID(employee.getEmployeeID());
                criticism.setCriticismTime(new Date());
                criticism.setMessageID(messageID);
                CriticismDAO criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
                criticismDAO.addCriticism(criticism);
            }
        }
        dispatcher = servletContext.
                getRequestDispatcher("/GetMessage?messageID=" + messageID);//跳转回消息查看页
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
