package com.cxj.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by xixi on 06/12/2016.
 */
public class TestAction extends ActionSupport {
    private static final long serialVersionUID=1L;

    private Map<String,Object> request;

    private Map<String,Object> session;

    private Map<String,Object> application;

    @SuppressWarnings("unchecked")
    public TestAction(){
        ActionContext context=ActionContext.getContext();

        request=(Map<String,Object>)context.get("request");

        session=context.getSession();

        application=context.getApplication();
    }

    public String execute() throws Exception{
        String info="123";

        request.put("info",info);
        session.put("info",info);
        application.put("info",info);

        return SUCCESS;
    }

}
