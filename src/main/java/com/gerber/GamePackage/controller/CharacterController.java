package com.gerber.GamePackage.controller;

import com.gerber.GamePackage.entity.CharacterEquipment;
import com.gerber.GamePackage.entity.CharacterStats;
import com.gerber.GamePackage.entity.EquipmentEntity.*;
import com.gerber.GamePackage.entity.UserCharacter;
import com.gerber.GamePackage.service.UserCharacterService;
import com.gerber.LogInPackage.entity.User;
import com.gerber.LogInPackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/character")
public class CharacterController
{

    @Autowired
    UserService userService;

    @Autowired
    UserCharacterService userCharacterService;


    @GetMapping("/characterInfo")
    public String CharacterInfo(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter userCharacter = user.getUsercharacter();
        CharacterStats characterStats = userCharacter.getCharacterStats();
        for(int i=0;i<20;i++)
        {
            System.out.println("TO MÓJ STR: "+characterStats.getStat_str());
        }
        model.addAttribute("userCharacter",userCharacter);
        model.addAttribute("characterStats",characterStats);
        return "character-info";
    }

    @GetMapping("/characterEquipment")
    public String characterEquipment(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter userCharacter = user.getUsercharacter();
        CharacterEquipment characterEquipment = userCharacter.getCharacterEquipment();

        Helment helment = characterEquipment.getHelment();
        Armor armor = characterEquipment.getArmor();
        Pants pants = characterEquipment.getPants();
        Gloves gloves = characterEquipment.getGloves();
        Boots boots = characterEquipment.getBoots();
        Weapon weapon = characterEquipment.getWeapon();
        for(int i=0;i<20;i++)
        {
            System.out.println(armor.getName()+" taka mam zbroje kurwa<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }
        model.addAttribute("userCharacter",userCharacter);
        model.addAttribute("helment",helment);
        model.addAttribute("armor",armor);
        model.addAttribute("pants",pants);
        model.addAttribute("gloves",gloves);
        model.addAttribute("boots",boots);
        model.addAttribute("weapon",weapon);
        return "character-equipment";
    }


    @PostMapping("/strIncrease")
    public String strIncrease(@RequestParam("StatIncrease") int str)
    {

            userCharacterService.strIncrease(str);
        return "redirect:/character/characterInfo";
    }
    @PostMapping("/dexIncrease")
    public String dexIncrease(@RequestParam("StatIncrease") int str)
    {

            userCharacterService.dexIncrease(str);
        return "redirect:/character/characterInfo";
    }
    @PostMapping("/conIncrease")
    public String conIncrease(@RequestParam("StatIncrease") int str)
    {

            userCharacterService.conIncrease(str);
        return "redirect:/character/characterInfo";
    }
    @PostMapping("/intIncrease")
    public String intIncrease(@RequestParam("StatIncrease") int str)
    {

            userCharacterService.intIncrease(str);

        return "redirect:/character/characterInfo";
    }
    @PostMapping("/wigIncrease")
    public String wigIncrease(@RequestParam("StatIncrease") int str)
    {

            userCharacterService.wigIncrease(str);
        return "redirect:/character/characterInfo";
    }
}
