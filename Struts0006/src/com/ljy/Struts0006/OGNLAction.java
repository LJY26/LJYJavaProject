package com.ljy.Struts0006;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class OGNLAction extends ActionSupport {
    private static final long serialVersionID=1L;

    private String name;

    private User user;

    private Map<String,Object> request;

    @SuppressWarnings("unchecked")
    public OGNLAction(){
        name="ceshi";

        user=new User();
        user.setName(name);
        user.setAge(20);
        user.setEmail("1197170541@qq.com");

        request=(Map<String,Object>) ActionContext.getContext().get("request");
    }

    @Override
    public String execute() throws Exception {
        request.put("info","request测试");
        return SUCCESS;
    }

    public static long getSerialVersionID() {
        return serialVersionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
