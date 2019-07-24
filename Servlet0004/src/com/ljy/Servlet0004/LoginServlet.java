package com.ljy.Servlet0004;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter=resp.getWriter();

        String name=req.getParameter("name");
        String passwd=req.getParameter("userpass");

        if(passwd.equals("123")&&name.equals("123")){
            RequestDispatcher rd=req.getRequestDispatcher("book.jsp");
            System.out.println("user name is :"+name);
            rd.forward(req,resp);
        }else if(passwd.equals("123")||name.equals("123")){
            printWriter.print("Sorry username or password error~");
            RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
            rd.include(req,resp);
        }else{
            resp.sendRedirect("/index.jsp");

        }
    }
}
