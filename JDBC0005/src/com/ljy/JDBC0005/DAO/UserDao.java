package com.ljy.JDBC0005.DAO;

import com.ljy.JDBC0005.ConnUtil;
import com.ljy.JDBC0005.POJO.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static UserDao instance = null;

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public boolean saveUser(User user) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = ConnUtil.getConn();
            String sql = "insert into users(id,email,password,admin,name,image,created_at) values(?,?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getId());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getAdmin());
            stmt.setString(5, user.getName());
            stmt.setString(6, user.getImage());
            stmt.setDouble(7, user.getCreated_at());
            int i = stmt.executeUpdate();
            if (i == 1) result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public List<User> selectUsers(){
        List<User> users=new ArrayList<>();
        Connection connection=null;
        try {
            connection=ConnUtil.getConn();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("select * from users");
            while (rs.next()){
                User user=new User();
                user.setId(rs.getString("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAdmin(rs.getInt("admin"));
                user.setName(rs.getString("name"));
                user.setImage(rs.getString("image"));
                user.setCreated_at(rs.getDouble("created_at"));
                users.add(user);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return users;
    }

    public boolean updateUser(User user){
        boolean result=false;
        Connection con=null;
        try{
            con=ConnUtil.getConn();
            String sql="update users set name=? where email=?";
            PreparedStatement statement=con.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            int i=statement.executeUpdate();
            if(i==1)result=true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean deleteUser(User user){
        boolean result=false;
        Connection conn=null;
        try{
            conn=ConnUtil.getConn();
            String sql="delete from users where email=?";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,user.getEmail());
            int i=stmt.executeUpdate();
            if(i==1)result=true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
