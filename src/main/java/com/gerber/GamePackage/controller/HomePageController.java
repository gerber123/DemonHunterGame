package com.gerber.GamePackage.controller;

import com.gerber.GamePackage.entity.UserCharacter;
import com.gerber.GamePackage.service.UserCharacterService;
import com.gerber.LogInPackage.entity.User;
import com.gerber.LogInPackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomePageController
{
    @Autowired
    UserService userService;

    @Autowired
    UserCharacterService userCharacterService;


    @GetMapping("/homepage")
    public String homePage(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);

        model.addAttribute("user",user);
        return "home-page";
    }
    @GetMapping("/startingPanel")
    public String startingPanel(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter userCharacter = user.getUsercharacter();
        System.out.println(userCharacter+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        model.addAttribute("userCharacter",userCharacter);
        return "starting-panel";
    }


}
