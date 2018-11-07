package com.gerber.LogInPackage.controller;

import com.gerber.LogInPackage.dao.UserDAO;
import com.gerber.LogInPackage.entity.User;
import com.gerber.LogInPackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{
    @Autowired
    UserService userService;


    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+name);

        return "login-page";

    }

    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";

    }

    @GetMapping("/preload")
    public String preload()
    {
        return "Preload";
    }
}
