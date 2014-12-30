package com.ShinChven.springwebmvc.controller;

import com.ShinChven.springwebmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ShinChven on 2014/12/30.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user,Model model){
        model.addAttribute("user",user);
        return "main";
    }
}
