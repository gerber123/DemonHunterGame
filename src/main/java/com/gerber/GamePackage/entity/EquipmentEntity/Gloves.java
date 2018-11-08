package com.gerber.GamePackage.entity.EquipmentEntity;

import com.gerber.GamePackage.entity.CharacterEquipment;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="gloves")
public class Gloves
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="defense")
    private int defense;

    @Column(name="bonus_str")
    private int bonus_str;

    @Column(name="bonus_dex")
    private int bonus_dex;

    @Column(name="bonus_int")
    private int bonus_int;

    @Column(name="bonus_con")
    private int bonus_con;


    @OneToMany(mappedBy = "gloves",cascade = {CascadeType.MERGE})
    List<CharacterEquipment> characterEquipment;

    public Gloves() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getBonus_str() {
        return bonus_str;
    }

    public void setBonus_str(int bonus_str) {
        this.bonus_str = bonus_str;
    }

    public int getBonus_dex() {
        return bonus_dex;
    }

    public void setBonus_dex(int bonus_dex) {
        this.bonus_dex = bonus_dex;
    }

    public int getBonus_int() {
        return bonus_int;
    }

    public void setBonus_int(int bonus_int) {
        this.bonus_int = bonus_int;
    }

    public int getBonus_con() {
        return bonus_con;
    }

    public void setBonus_con(int bonus_con) {
        this.bonus_con = bonus_con;
    }

    public List<CharacterEquipment> getCharacterEquipment() {
        return characterEquipment;
    }

    public void setCharacterEquipment(List<CharacterEquipment> characterEquipment) {
        this.characterEquipment = characterEquipment;
    }
}
