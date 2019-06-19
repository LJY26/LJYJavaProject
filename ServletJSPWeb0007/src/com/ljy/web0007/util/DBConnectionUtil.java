package com.ljy.web0007.util;

import java.sql.*;

/**
 * 数据库配置
 */
public class DBConnectionUtil {


    /**
     * 数据库常量配置
     */
    private static final String DBDrive="com.mysql.jdbc.Driver";
    private static final String DBUrl="jdbc:mysql://localhost:3306/db_affairmanage?useUnicode=true&characterEncoding=utf8";
    private static final  String DBUsr="root";
    private static final String DBPassword="123";

    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName(DBDrive);
            conn= DriverManager.getConnection(DBUrl,DBUsr,DBPassword);
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接
      * @param conn
     */
    public static void close(Connection conn){
        if(conn!=null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭预处理对象方法
     * @param pstmt
     */
    public static void close(PreparedStatement pstmt){
        if(pstmt!=null){
            try {
                pstmt.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        }
    }

    /**
     * 关闭结果集对象方法
     * @param rs
     */
    public static void close(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}
