package com.ljy.web0007.daoImpl;

import com.ljy.web0007.bean.Employee;
import com.ljy.web0007.dao.EmployeeDAO;
import com.ljy.web0007.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(int employeeID) {

    }

    @Override
    public List<Employee> findAllEmployee() {
        return null;
    }

    public Employee findEmployeeById(int employeeID) {
        Connection conn= DBConnectionUtil.getConnection();
        String findByIDSQL="select * from tb_employee where employeeID=?";

        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Employee employee=null;
        try {
            pstmt=conn.prepareStatement(findByIDSQL);
            pstmt.setInt(1,employeeID);
            rs=pstmt.executeQuery();
            if(rs.next()){
                employee=new Employee();
                employee.setEmployeeID(rs.getInt(1));
                employee.setEmployeeName(rs.getString(2));
                employee.setEmployeeSex(rs.getBoolean(3));
                employee.setEmployeeBirth(rs.getDate(4));
                employee.setEmployeePhone(rs.getString(5));
                employee.setEmployeePlace(rs.getString(6));
                employee.setJoinTime(rs.getDate(7));
                employee.setPassword(rs.getString(8));
                employee.setLead(rs.getBoolean(9));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBConnectionUtil.close(rs);
            DBConnectionUtil.close(pstmt);
            DBConnectionUtil.close(conn);
        }
        return employee;
    }
}
