package com.ljy.web0007.servlet;

import com.ljy.web0007.bean.Employee;
import com.ljy.web0007.dao.EmployeeDAO;
import com.ljy.web0007.factory.EmployeeDAOFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatusRecognise extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        ServletContext servletContext=getServletContext();
        RequestDispatcher dispatcher=null;
        String employeeID=request.getParameter("employeeID");
        String password=request.getParameter("password");
        if(employeeID==null||"".equals(employeeID)){
            request.setAttribute("error","员工端ID是必传项哦");
            dispatcher=servletContext.getRequestDispatcher("/statusRecognise.jsp");
        }else {
            if(password==null||"".equals(password)){
                request.setAttribute("error","员工密码是必传项哦");
                dispatcher=servletContext.getRequestDispatcher("/statusRecognise,jsp");
            }else {
                EmployeeDAO employeeDAO= EmployeeDAOFactory.getEmployeeDAOInstance();
                Employee employee=employeeDAO.findEmployeeById(Integer.parseInt(employeeID));
                if(employee==null){
                    request.setAttribute("error","未找到员工登录信息");
                    dispatcher=servletContext.getRequestDispatcher("/statusRecognise.jsp");
                }else {
                    if(password.equals(employee.getPassword())){
                        request.getSession().setAttribute("employee",employee);
                        response.sendRedirect("index.jsp");
                        return;
                    }else {
                        request.setAttribute("error","密码错误");
                        dispatcher=servletContext.getRequestDispatcher("/statusRecognise.jsp");
                    }
                }
            }
        }

        dispatcher.forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        doGet(request, response);
    }
}
