package com.ljy.Struts0006;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class GreetAction extends ActionSupport {
    private static final long serialVersionUID=1L;
    private Map<String,Object> request;
    private Map<String,Object> session;
    private Map<String,Object> application;
    @SuppressWarnings("unchecked")
    public GreetAction(){
        ActionContext context=ActionContext.getContext();
        request=(Map<String,Object>)context.get("request");
        session=context.getSession();
        application=context.getApplication();
    }
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String execute() throws Exception {
        String info="明日科技";
        request.put("info",info);
        session.put("info",info);
        application.put("info",info);

        if(username==null||"".equals(username)){
            return ERROR;
        }else{
            return SUCCESS;
        }
    }
}
