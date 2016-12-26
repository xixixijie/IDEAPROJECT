package com.cxj.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by xixi on 06/12/2016.
 */
public class OGNLAction extends ActionSupport{
    private String name;
    private Student student;

    Map<String,Object> request;
    @SuppressWarnings("unchecked")
    public OGNLAction(){
        student=new Student();
        student.setId(1);
        student.setName("chenxijie");
        name = "tom";
        request = (Map<String, Object>) ActionContext.getContext().get("request");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String execute() throws Exception{
        request.put("info", "request test");
        return SUCCESS;


    }
}
