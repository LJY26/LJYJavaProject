package com.ljy.web0007.factory;

import com.ljy.web0007.dao.EmployeeDAO;
import com.ljy.web0007.daoImpl.EmployeeDAOImpl;

public class EmployeeDAOFactory {

    public static EmployeeDAO getEmployeeDAOInstance(){
        return new EmployeeDAOImpl();
    }
}
