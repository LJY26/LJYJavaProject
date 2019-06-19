package com.ljy.web0007.factory;

import com.ljy.web0007.dao.ReplyDAO;
import com.ljy.web0007.daoImpl.ReplyDAOImpl;

public class ReplyDAOFactory {
    public static ReplyDAO getReplyDAOInstance(){
        return new ReplyDAOImpl();
    }
}
