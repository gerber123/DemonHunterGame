package com.gerber.GamePackage.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "character_type" )
public class CharacterType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

        @Column(name="name")
        private String name;

        @Column(name="basic_str")
        private int basic_str;

        @Column(name="basic_dex")
        private int basic_dex;

        @Column(name="basic_int")
        private int basic_int;

        @Column(name="basic_con")
        private int basic_con;

        @Column(name="basic_wig")
        private int basic_wig;

//        @OneToOne(mappedBy = "characterType",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
        @OneToMany(mappedBy = "characterType",cascade = {CascadeType.MERGE})
        List<UserCharacter> userCharacter;

    public CharacterType(String name, int basic_str, int basic_dex, int basic_int, int basic_con, int basic_wig) {
        this.name = name;
        this.basic_str = basic_str;
        this.basic_dex = basic_dex;
        this.basic_int = basic_int;
        this.basic_con = basic_con;
        this.basic_wig = basic_wig;
    }

    public CharacterType() {
    }

    public List<UserCharacter> getUserCharacter() {
        return userCharacter;
    }

    public void setUserCharacter(List<UserCharacter> userCharacter) {
        this.userCharacter = userCharacter;
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

    public int getBasic_str() {
        return basic_str;
    }

    public void setBasic_str(int basic_str) {
        this.basic_str = basic_str;
    }

    public int getBasic_dex() {
        return basic_dex;
    }

    public void setBasic_dex(int basic_dex) {
        this.basic_dex = basic_dex;
    }

    public int getBasic_int() {
        return basic_int;
    }

    public void setBasic_int(int basic_int) {
        this.basic_int = basic_int;
    }

    public int getBasic_con() {
        return basic_con;
    }

    public void setBasic_con(int basic_con) {
        this.basic_con = basic_con;
    }

    public int getBasic_wig() {
        return basic_wig;
    }

    public void setBasic_wig(int basic_wig) {
        this.basic_wig = basic_wig;
    }
}
