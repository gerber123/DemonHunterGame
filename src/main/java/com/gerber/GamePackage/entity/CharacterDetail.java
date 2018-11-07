package com.gerber.GamePackage.entity;

import javax.persistence.*;

@Entity
@Table(name="character_detail")
public class CharacterDetail
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="attack")
    private int attack;

    @Column(name="m_attack")
    private int m_attack;

    @Column(name="max_hp")
    private int max_hp;

    @Column(name="actual_hp")
    private int actual_hp;

    @Column(name="defense")
    private int defense;

    @Column(name="max_energy")
    private int max_energy;

    @Column(name="actual_energy")
    private int actual_energy;

    @Column(name="chance_avoid")
    private int chance_avoid;

    @Column(name="accuracy")
    private int accuracy;

    @Column(name="crit_chance")
    private int crit_chance;

    @Column(name="crit_damage")
    private int crit_damage;

    @Column(name="max_exp")
    private int max_exp;

    @Column(name="actual_exp")
    private int actual_exp;

    @OneToOne(mappedBy = "characterDetail",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    UserCharacter userCharacter;

    public CharacterDetail() {
    }

    public CharacterDetail(int attack, int m_attack, int max_hp, int actual_hp, int defense, int max_energy, int actual_energy, int chance_avoid, int accuracy, int crit_chance, int crit_damage, int max_exp, int actual_exp) {
        this.attack = attack;
        this.m_attack = m_attack;
        this.max_hp = max_hp;
        this.actual_hp = actual_hp;
        this.defense = defense;
        this.max_energy = max_energy;
        this.actual_energy = actual_energy;
        this.chance_avoid = chance_avoid;
        this.accuracy = accuracy;
        this.crit_chance = crit_chance;
        this.crit_damage = crit_damage;
        this.max_exp = max_exp;
        this.actual_exp = actual_exp;
    }

    public UserCharacter getUserCharacter() {
        return userCharacter;
    }

    public void setUserCharacter(UserCharacter userCharacter) {
        this.userCharacter = userCharacter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getM_attack() {
        return m_attack;
    }

    public void setM_attack(int m_attack) {
        this.m_attack = m_attack;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public int getActual_hp() {
        return actual_hp;
    }

    public void setActual_hp(int actual_hp) {
        this.actual_hp = actual_hp;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMax_energy() {
        return max_energy;
    }

    public void setMax_energy(int max_energy) {
        this.max_energy = max_energy;
    }

    public int getActual_energy() {
        return actual_energy;
    }

    public void setActual_energy(int actual_energy) {
        this.actual_energy = actual_energy;
    }

    public int getChance_avoid() {
        return chance_avoid;
    }

    public void setChance_avoid(int chance_avoid) {
        this.chance_avoid = chance_avoid;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getCrit_chance() {
        return crit_chance;
    }

    public void setCrit_chance(int crit_chance) {
        this.crit_chance = crit_chance;
    }

    public int getCrit_damage() {
        return crit_damage;
    }

    public void setCrit_damage(int crit_damage) {
        this.crit_damage = crit_damage;
    }

    public int getMax_exp() {
        return max_exp;
    }

    public void setMax_exp(int max_exp) {
        this.max_exp = max_exp;
    }

    public int getActual_exp() {
        return actual_exp;
    }

    public void setActual_exp(int actual_exp) {
        this.actual_exp = actual_exp;
    }
}
