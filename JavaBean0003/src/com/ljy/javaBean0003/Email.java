package com.ljy.javaBean0003;

import java.io.Serializable;

/**
 * 邮箱信息
 */
public class Email implements Serializable{

    private static final long serialVersionUID=1;

    /**
     * 地址
     */
    private String mailAdd;

    /**
     * 是否是一个标准的email
     */
    private boolean email;

    public Email() {
    }

    public Email(String mailAdd) {
        this.mailAdd = mailAdd;
    }

    public String getMailAdd() {
        return mailAdd;
    }

    public void setMailAdd(String mailAdd) {
        this.mailAdd = mailAdd;
    }

    public boolean isEmail() {
        String regex="\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        if(mailAdd.matches(regex)){
            email=true;
        }
        return email;
    }
}
