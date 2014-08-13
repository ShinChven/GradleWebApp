package com.atlassc.gradleWebApp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ShinChven on 14/7/11.
 */
@Action("index")
@ParentPackage("basePackage")
@Namespace("/")
@Results({@Result(name = "success",location = "index.jsp")})
public class IndexAction extends ActionSupport{
    private Logger mIndexLogger;

    @Override
    public String execute() throws Exception {
        mIndexLogger = Logger.getLogger("IndexAction");
        mIndexLogger.log(Level.ALL,"Welcome to Index Action");
        return SUCCESS;
    }
}
