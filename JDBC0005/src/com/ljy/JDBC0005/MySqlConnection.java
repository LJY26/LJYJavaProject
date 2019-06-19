package com.ljy.JDBC0005;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {

    public static Connection getMySQLConn(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String user="root";
            String pwd="123";
            String url="jdbc:mysql://localhost:3306/awesome?useUnicode=true&characterEncoding=utf8";
            conn= DriverManager.getConnection(url,user,pwd);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args){
        Connection connection=getMySQLConn();
        if(connection!=null){
            System.out.println("MySQL数据库连接成功！Connection="+connection.toString());
        }
    }

}
