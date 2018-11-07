package com.gerber.GamePackage.dao;

import com.gerber.GamePackage.entity.CharacterRace;
import com.gerber.GamePackage.entity.CharacterStats;
import com.gerber.GamePackage.entity.CharacterType;
import com.gerber.GamePackage.entity.UserCharacter;

public interface UserCharacterDAO  {
    void save(UserCharacter userCharacter);
    CharacterType getCharacterType(int id);
    void saveCharacterType(CharacterType characterType);
    void saveCharacterRace(CharacterRace characterRace);
    void saveCharacterEquipment();

    CharacterRace getCharacterRace(long id);
    void CreateCharacterStats();
    void CreateCharacterDetails();


    void strIncrease(int stat);
    void dexIncrease(int stat);
    void intIncrease(int stat);
    void conIncrease(int stat);
    void wigIncrease(int stat);

}
