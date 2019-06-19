package com.ljy.JDBC0005;

import com.ljy.JDBC0005.DAO.UserDao;
import com.ljy.JDBC0005.POJO.User;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Test {
    public static void main(String[] args){
//        User user=new User();
//        user.setId(UUID.randomUUID().toString());
//        user.setEmail("1197170541@qq.com");
//        user.setPassword("123");
//        user.setAdmin(0);
//        user.setName("ceshi");
//        user.setImage("");
//        user.setCreated_at(Calendar.getInstance().getTime().getTime());
//        boolean result=UserDao.getInstance().saveUser(user);
//        if(result) {
//            System.out.println("插入数据成功");
//        }else {
//            System.out.println("插入数据失败");
//        }

        User user=new User();
        user.setName("李金燚1");
        user.setEmail("1197170541@qq.com");
        boolean result=UserDao.getInstance().updateUser(user);
        result=UserDao.getInstance().deleteUser(user);
        if(result) {

            List<User> users = UserDao.getInstance().selectUsers();
            users.forEach(t -> {
                System.out.println("------------------------");
                System.out.println("编号：" + t.getId());
                System.out.println("密码：" + t.getPassword());
                System.out.println("邮箱:" + t.getEmail());
                System.out.println("姓名："+t.getName());
            });
        }else {
            System.out.println("更新失败");
        }
    }
}
