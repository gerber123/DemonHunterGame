package com.gerber.GamePackage.entity;

import com.gerber.LogInPackage.entity.User;

import javax.persistence.*;

@Entity
@Table(name= "user_character" )
public class UserCharacter
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="nick_name")
    private String nick_name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="character_type_id")
    private CharacterType characterType;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="character_race_id")
    private CharacterRace characterRace;


    @Column(name="lvl")
    private int lvl;

    @OneToOne(mappedBy = "usercharacter",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="character_stats_id")
    private CharacterStats characterStats;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="character_detail_id")
    private CharacterDetail characterDetail;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="character_equipment_id")
    private CharacterEquipment characterEquipment;

    public UserCharacter(){};

    public UserCharacter(String nick_name, CharacterType characterType, CharacterRace characterRace, int lvl, User user, CharacterStats characterStats, CharacterDetail characterDetail, CharacterEquipment characterEquipment) {
        this.nick_name = nick_name;
        this.characterType = characterType;
        this.characterRace = characterRace;
        this.lvl = lvl;
        this.user = user;
        this.characterStats = characterStats;
        this.characterDetail = characterDetail;
        this.characterEquipment = characterEquipment;
    }

    public CharacterRace getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(CharacterRace characterRace) {
        this.characterRace = characterRace;
    }

    public CharacterEquipment getCharacterEquipment() {
        return characterEquipment;
    }

    public void setCharacterEquipment(CharacterEquipment characterEquipment) {
        this.characterEquipment = characterEquipment;
    }


    public CharacterStats getCharacterStats() {
        return characterStats;
    }

    public void setCharacterStats(CharacterStats characterStats) {
        this.characterStats = characterStats;
    }

    public CharacterDetail getCharacterDetail() {
        return characterDetail;
    }

    public void setCharacterDetail(CharacterDetail characterDetail) {
        this.characterDetail = characterDetail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }



    public void setCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
