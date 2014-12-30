package com.ShinChven.springwebmvc.controller;

import com.ShinChven.springwebmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ShinChven on 2014/12/29.
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(User user) {
        return "index";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String postHello(User user) {
        return "redirect:/hello.do";
    }
}
