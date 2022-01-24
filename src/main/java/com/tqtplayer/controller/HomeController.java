package com.tqtplayer.controller;

import com.tqtplayer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HttpSession session;

    @GetMapping("")
    public ModelAndView toHomePage(){
        ModelAndView modelAndView = new ModelAndView();
        User userLogin = (User) session.getAttribute("userLogin");
        System.out.println(userLogin);
        if (userLogin != null){
            modelAndView.setViewName("/home");
            modelAndView.addObject("userLogin",userLogin);
        } else {
            modelAndView.setViewName("account/signIn");
            modelAndView.addObject("message", "Vui Long Dang Nhap De Su Dung ");
        }
        return modelAndView;
    }
}
