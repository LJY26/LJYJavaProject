package com.ljy.web0007.factory;

import com.ljy.web0007.dao.CriticismDAO;
import com.ljy.web0007.daoImpl.CriticismDAOImpl;

public class CriticismDAOFactory {
    public static CriticismDAO getCriticismDAOInstance(){
        return new CriticismDAOImpl();
    }
}
