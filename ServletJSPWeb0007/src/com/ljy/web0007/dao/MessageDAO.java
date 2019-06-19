package com.ljy.web0007.dao;

import com.ljy.web0007.bean.Message;
import com.ljy.web0007.util.Page;

import java.util.List;

public interface MessageDAO {
    void addMessage(Message message);
    void updateMessage(Message message);
    void deleteMessage(int messageID);
    List<Message> findAllMessage(Page page);
    Message findMessageById(int messageID);
    int findAllCount();
}
