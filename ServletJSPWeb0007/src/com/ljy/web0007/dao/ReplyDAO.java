package com.ljy.web0007.dao;

import com.ljy.web0007.bean.Reply;
import com.ljy.web0007.util.Page;

import java.util.List;

public interface ReplyDAO {
    void addReply(Reply reply);
    List<Reply> findReplyByMsgID(int messageID, Page page);
    int findCountByMsgID(int messageID);

}
