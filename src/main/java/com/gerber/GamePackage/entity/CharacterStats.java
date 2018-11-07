package com.gerber.GamePackage.entity;

import javax.persistence.*;

@Entity
@Table(name= "character_stats" )
public class CharacterStats
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="stat_str")
    private int stat_str;

    @Column(name="stat_dex")
    private int stat_dex;

    @Column(name="stat_int")
    private int stat_int;

    @Column(name="stat_con")
    private int stat_con;

    @Column(name="stat_wig")
    private int stat_wig;

    @Column(name="stat_free_points")
    private Integer stat_free_points;

    @OneToOne(mappedBy = "characterStats",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    UserCharacter userCharacter;


    public CharacterStats() {
    }

    public CharacterStats(int stat_str, int stat_dex, int stat_int, int stat_con, int stat_wig) {
        this.stat_str = stat_str;
        this.stat_dex = stat_dex;
        this.stat_int = stat_int;
        this.stat_con = stat_con;
        this.stat_wig = stat_wig;
    }

    public int getStat_free_points() {
        return stat_free_points;
    }

    public void setStat_free_points(int stat_free_points) {
        this.stat_free_points = stat_free_points;
    }

    public int getId() {
        return id;
    }

    public UserCharacter getUserCharacter() {
        return userCharacter;
    }

    public void setUserCharacter(UserCharacter userCharacter) {
        this.userCharacter = userCharacter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStat_str() {
        return stat_str;
    }

    public void setStat_str(int stat_str) {
        this.stat_str = stat_str;
    }

    public int getStat_dex() {
        return stat_dex;
    }

    public void setStat_dex(int stat_dex) {
        this.stat_dex = stat_dex;
    }

    public int getStat_int() {
        return stat_int;
    }

    public void setStat_int(int stat_int) {
        this.stat_int = stat_int;
    }

    public int getStat_con() {
        return stat_con;
    }

    public void setStat_con(int stat_con) {
        this.stat_con = stat_con;
    }

    public int getStat_wig() {
        return stat_wig;
    }

    public void setStat_wig(int stat_wig) {
        this.stat_wig = stat_wig;
    }
}
