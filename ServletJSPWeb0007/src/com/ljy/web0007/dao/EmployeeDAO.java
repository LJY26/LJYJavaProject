package com.ljy.web0007.dao;

import com.ljy.web0007.bean.Employee;

import java.util.List;

/**
 * 员工操作类
 */
public interface EmployeeDAO {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeID);
    List<Employee> findAllEmployee();
    Employee findEmployeeById(int employeeID);
}
