package com.gerber.GamePackage.entity;

import com.gerber.GamePackage.entity.EquipmentEntity.*;

import javax.persistence.*;

@Entity
@Table(name="character_equipment")
@Embeddable
public class CharacterEquipment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="weapon_id")
    private Weapon weapon;

    @OneToOne(cascade =  CascadeType.MERGE)
    @JoinColumn(name="armor_id")
    private Armor armor;

    @OneToOne( cascade =  CascadeType.MERGE)
    @JoinColumn(name="gloves_id")
    private Gloves gloves;

    @OneToOne( cascade =  CascadeType.MERGE)
    @JoinColumn(name="helment_id")
    private Helment helment;


    @OneToOne(cascade =  CascadeType.MERGE)
    @JoinColumn(name="boots_id")
    private Boots boots;

    @OneToOne(cascade =  CascadeType.MERGE)
    @JoinColumn(name="pants_id")
    private Pants pants;


    @OneToOne(mappedBy = "characterEquipment",cascade = {CascadeType.MERGE})
    UserCharacter userCharacter;

    public Pants getPants() {
        return pants;
    }

    public void setPants(Pants pants) {
        this.pants = pants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Gloves getGloves() {
        return gloves;
    }

    public void setGloves(Gloves gloves) {
        this.gloves = gloves;
    }

    public Helment getHelment() {
        return helment;
    }

    public void setHelment(Helment helment) {
        this.helment = helment;
    }

    public Boots getBoots() {
        return boots;
    }

    public void setBoots(Boots boots) {
        this.boots = boots;
    }

    public UserCharacter getUserCharacter() {
        return userCharacter;
    }

    public void setUserCharacter(UserCharacter userCharacter) {
        this.userCharacter = userCharacter;
    }
}
