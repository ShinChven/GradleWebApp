package com.ShinChven.springwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ShinChven on 2014/12/29.
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("hello","gradle，你好！");
        return "index";
    }
}
