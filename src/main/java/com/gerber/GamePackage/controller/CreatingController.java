package com.gerber.GamePackage.controller;

import com.gerber.GamePackage.entity.CharacterRace;
import com.gerber.GamePackage.entity.CharacterType;
import com.gerber.GamePackage.entity.UserCharacter;
import com.gerber.GamePackage.service.UserCharacterService;
import com.gerber.LogInPackage.entity.User;
import com.gerber.LogInPackage.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/creatingProcess")
public class CreatingController
{
    @Autowired
    UserService userService;

    @Autowired
    UserCharacterService userCharacterService;



    @GetMapping("/showCreatingCharacterPanel")
    public String showCreatingCharacterPanel(Model model)
    {
        UserCharacter character =new UserCharacter();
        model.addAttribute("character",character);
        return "creating-form";
    }

    @PostMapping("/createCharacter")
    public String createCharacter(@ModelAttribute("character") UserCharacter character)
    {
        userCharacterService.save(character);
        return "redirect:/creatingProcess/selectingClass";
    }
    @GetMapping("/selectingClass")
    public String selectingClass(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter character = user.getUsercharacter();
        model.addAttribute("character",character);
        return "select-class";
    }
    @PostMapping("/classSelected")
    public String classSelected(@ModelAttribute("character") UserCharacter character, @RequestParam("characterTypeId") int id)
    {

        CharacterType characterType=userCharacterService.getCharacterType(id);
        userCharacterService.saveUserCharacterType(characterType);
        return "select-race";
    }
    @GetMapping("/selectingRace")
    public String selectingRace(Model model)
    {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter character = user.getUsercharacter();
        CharacterType characterType=character.getCharacterType();
        model.addAttribute("characterType",characterType);
        model.addAttribute("character",character);
        return "select-race";
    }
    @PostMapping("/raceSelected")
    public String raceSelected(@ModelAttribute("character") UserCharacter character, @RequestParam("characterRaceId") long id)
    {

        CharacterRace characterRace=userCharacterService.getCharacterRace(id);
//        System.out.println(characterRace.getName()+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        userCharacterService.saveUserCharacterRace(characterRace);
        return "redirect:/creatingProcess/characterCreated";
    }
    @GetMapping("/characterCreated")
    public String characterCreated(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter characterUser = user.getUsercharacter();
        userCharacterService.CreateCharacterStats(characterUser);
        userCharacterService.CreateCharacterDetails(characterUser);
        userCharacterService.saveCharacterEquipment(characterUser);
        System.out.println(characterUser.getCharacterEquipment().getBoots().getName()+"<<<<<<<<<<<<<<<<<<<<<<<<<<");

        model.addAttribute("user",user);
        return "character-created";
    }
}
