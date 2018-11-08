package com.gerber.GamePackage.service;

import com.gerber.GamePackage.dao.UserCharacterDAO;
import com.gerber.GamePackage.entity.CharacterRace;
import com.gerber.GamePackage.entity.CharacterStats;
import com.gerber.GamePackage.entity.CharacterType;
import com.gerber.GamePackage.entity.UserCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserCharacterServiceImpl implements UserCharacterService
{
    @Autowired
    UserCharacterDAO userCharacterDAO;

    @Override
    @Transactional
    public void save(UserCharacter userCharacter)
    {
        userCharacterDAO.save(userCharacter);
    }

    @Override
    @Transactional
    public CharacterType getCharacterType(int id) {
        return userCharacterDAO.getCharacterType(id);
    }


    @Override
    @Transactional
    public CharacterRace getCharacterRace(long id) {
        return userCharacterDAO.getCharacterRace(id);
    }

    @Override
    @Transactional
    public void saveUserCharacterType(CharacterType characterType) {
        userCharacterDAO.saveCharacterType(characterType);
    }

    @Override
    @Transactional
    public void saveUserCharacterRace(CharacterRace characterRace) {
        userCharacterDAO.saveCharacterRace(characterRace);
    }

    @Override
    @Transactional
    public void CreateCharacterStats() {
        userCharacterDAO.CreateCharacterStats();
    }

    @Override
    @Transactional
    public void CreateCharacterDetails() {
        userCharacterDAO.CreateCharacterDetails();
    }

    @Override
    @Transactional
    public void CreateCharacterStats(UserCharacter userCharacter) {
        userCharacterDAO.CreateCharacterStats(userCharacter);
    }

    @Override
    @Transactional
    public void CreateCharacterDetails(UserCharacter userCharacter) {
        userCharacterDAO.CreateCharacterDetails(userCharacter);
    }

    @Override
    @Transactional
    public void saveCharacterEquipment() {
        userCharacterDAO.saveCharacterEquipment();
    }

    @Override
    @Transactional
    public void saveCharacterEquipment(UserCharacter characterUser) {
        userCharacterDAO.saveCharacterEquipment(characterUser);
    }

    @Override
    @Transactional
    public void strIncrease(int stat) {
        userCharacterDAO.strIncrease(stat);
    }

    @Override
    @Transactional
    public void dexIncrease(int stat) {
        userCharacterDAO.dexIncrease(stat);
    }

    @Override
    @Transactional
    public void intIncrease(int stat) {
        userCharacterDAO.intIncrease(stat);
    }

    @Override
    @Transactional
    public void conIncrease(int stat) {
        userCharacterDAO.conIncrease(stat);
    }

    @Override
    @Transactional
    public void wigIncrease(int stat) {
        userCharacterDAO.wigIncrease(stat);
    }




}
