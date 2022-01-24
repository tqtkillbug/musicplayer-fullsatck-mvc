package com.tqtplayer.controller;

import com.tqtplayer.model.User;
import com.tqtplayer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private HttpSession session;

    @GetMapping("/")
    public String showLoginPage(Model model) {
        User userLogin = (User) session.getAttribute("userLogin");
        if (userLogin == null){
            ModelAndView modelAndView = new ModelAndView();
            model.addAttribute("message", "Well Come To TQT Player, Please login!");
            model.addAttribute("user", new User());
            return "/account/signIn";
        }
        return "redirect:/home";
    }

    @GetMapping("/signup")
    public ModelAndView showSignup() {
        ModelAndView modelAndView = new ModelAndView("/account/signUp");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message", "Fill out the form to sign up for an account!");
        return modelAndView;
    }

    @PostMapping("/signup")
    public ModelAndView registerAccount(@ModelAttribute @Valid User user, BindingResult bindingResult, @RequestParam String confirmpassword) {
        ModelAndView modelAndView = new ModelAndView();
        user.setRole("user");
        if (!user.getPassword().equals(confirmpassword)) {
            modelAndView.setViewName("/account/signUp");
            modelAndView.addObject("user", user);
            modelAndView.addObject("message", "Password and re-password do not match, please try again");
        }
        if (bindingResult.hasFieldErrors()) {
            modelAndView.setViewName("/account/signUp");
            modelAndView.addObject("user", user);
        } else {
            customerService.save(user);
            modelAndView.addObject("message", "Successful account registration, Login to use!");
            modelAndView.setViewName("/account/signIn");
        }
        return modelAndView;
    }

    @PostMapping("/signin")
    public String loginAccount(@ModelAttribute  User user, Model model, HttpServletResponse response) throws IOException {
            Optional<User> userLogin = customerService.findByEmail(user.getEmail());
            if (!userLogin.isPresent() || !userLogin.get().getPassword().equals(user.getPassword())) {
//                model.setViewName("/account/signIn");
                model.addAttribute("message", "Login failed, please try again!");
                return "/account/signIn";
            } else{
                if (userLogin.get().getRole().equals("user")){
                    session.setAttribute("userLogin", userLogin.get());
                    return "redirect:/home";
                } else if (userLogin.get().getRole().equals("admin")){
                    Cookie cookie = new Cookie("adminId",userLogin.get().getId().toString() );
                    response.addCookie(cookie);
                    response.sendRedirect("/pages?action=dashboard");
                }
            }
            return null;
    }

    @GetMapping("/logout")
    public ModelAndView logoutAction(){
        ModelAndView modelAndView = new ModelAndView("/account/signIn");
        modelAndView.addObject("message", "LogOut Success");
        modelAndView.addObject("user", new User());
        session.invalidate();
        return modelAndView;
    }



}

