package com.atlassc.gradleWebApp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

@Action("index")
@ParentPackage("basePackage")
@Namespace("/")
@Results({@Result(name = "success", location = "home.jsp")})
public class IndexAction extends ActionSupport {

    private String name="Gradle";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(name);
        return SUCCESS;
    }
}
