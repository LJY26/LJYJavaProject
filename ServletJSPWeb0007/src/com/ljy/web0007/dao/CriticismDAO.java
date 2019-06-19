package com.ljy.web0007.dao;

import com.ljy.web0007.bean.Criticism;

public interface CriticismDAO {
   void addCriticism(Criticism criticism);
   Criticism findCriticismByMsgID(int messageID);
}
