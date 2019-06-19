package com.ljy.web0007.factory;

import com.ljy.web0007.dao.MessageDAO;
import com.ljy.web0007.daoImpl.MessageDAOImpl;

public class MessageDAOFactory {
    public static MessageDAO getMessageDAOInstance(){
        return new MessageDAOImpl();
    }
}
