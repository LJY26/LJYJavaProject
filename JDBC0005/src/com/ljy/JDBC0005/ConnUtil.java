package com.ljy.JDBC0005;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnUtil {
    private static Connection conn=null;

    public static Connection getConn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/awesome?useUnicode=true&characterEncoding=utf8","root","123");

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return conn;
    }
}
