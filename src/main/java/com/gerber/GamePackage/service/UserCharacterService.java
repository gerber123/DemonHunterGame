package com.gerber.GamePackage.service;

import com.gerber.GamePackage.entity.CharacterRace;
import com.gerber.GamePackage.entity.CharacterStats;
import com.gerber.GamePackage.entity.CharacterType;
import com.gerber.GamePackage.entity.UserCharacter;

public interface UserCharacterService {
    void save(UserCharacter userCharacter);
    CharacterType getCharacterType(int id);
    CharacterRace getCharacterRace(long id);
    void saveUserCharacterType(CharacterType characterType);
    void saveUserCharacterRace(CharacterRace characterRace);
    void CreateCharacterStats();
    void CreateCharacterDetails();
    void saveCharacterEquipment();
    void CreateCharacterStats(UserCharacter userCharacter);
    void CreateCharacterDetails(UserCharacter userCharacter);
    void saveCharacterEquipment(UserCharacter characterUser);
    void strIncrease( int stat);
    void dexIncrease(int stat);
    void intIncrease(int stat);
    void conIncrease(int stat);
    void wigIncrease(int stat);
}
