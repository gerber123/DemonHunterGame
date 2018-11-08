package com.gerber.GamePackage.dao;

import com.gerber.GamePackage.entity.*;
import com.gerber.GamePackage.entity.EquipmentEntity.*;
import com.gerber.LogInPackage.entity.User;
import com.gerber.LogInPackage.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserCharacterDAOimpl implements UserCharacterDAO
{
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserService userService;


    @Override
    public void save(UserCharacter userCharacter)
    {
        Session session= sessionFactory.getCurrentSession();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        user.setUsercharacter(userCharacter);
        session.saveOrUpdate(userCharacter);
    }

    @Override
    public CharacterType getCharacterType(int id) {
        Session session=sessionFactory.getCurrentSession();
        CharacterType characterType =session.load(CharacterType.class,id);
        return characterType;
    }

    @Override
    public void saveCharacterType(CharacterType characterType) {
        Session session= sessionFactory.getCurrentSession();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter userCharacter =user.getUsercharacter();
        userCharacter.setCharacterType(characterType);
        session.saveOrUpdate(userCharacter);

    }
//
    @Override
    public void saveCharacterEquipment(UserCharacter characterUser) {
        Session session= sessionFactory.getCurrentSession();

        CharacterType characterType=characterUser.getCharacterType();
        CharacterEquipment characterEquipment=new CharacterEquipment();


        Integer id=1;
        Gloves gloves =session.get(Gloves.class,id);
        Helment helment =session.get(Helment.class,id);
        Boots boots =session.get(Boots.class,id);
        Pants pants =session.get(Pants.class,id);
        Armor armor =session.get(Armor.class,id);
        Weapon weapon = new Weapon();

        characterEquipment.setArmor(armor);
        characterEquipment.setHelment(helment);
        characterEquipment.setGloves(gloves);
        characterEquipment.setBoots(boots);
        characterEquipment.setPants(pants);
        if(characterType.getId()==1)
        {
            weapon =session.get(Weapon.class,1);
            characterEquipment.setWeapon(weapon);
        }
        if(characterType.getId()==2)
        {
            weapon =session.get(Weapon.class,5);
            characterEquipment.setWeapon(weapon);
        }
        if(characterType.getId()==3) {
            weapon = session.get(Weapon.class, 3);
            characterEquipment.setWeapon(weapon);
        }
//        }
//        str+=armor.getBonus_str()+helment.getBonus_str()+gloves.getBonus_str()+boots.getBonus_str()+pants.getBonus_str()+weapon.getBonus_str();
//        dex+=armor.getBonus_dex()+helment.getBonus_dex()+gloves.getBonus_dex()+boots.getBonus_dex()+pants.getBonus_dex()+weapon.getBonus_dex();
//        con+=armor.getBonus_con()+helment.getBonus_con()+gloves.getBonus_con()+boots.getBonus_con()+pants.getBonus_con();
//        m_int+=armor.getBonus_int()+helment.getBonus_int()+gloves.getBonus_int()+boots.getBonus_int()+pants.getBonus_int()+weapon.getBonus_int();


        session.saveOrUpdate(characterEquipment);
        characterUser.setCharacterEquipment(characterEquipment);
        session.saveOrUpdate(characterUser);


    }

    @Override
    public void saveCharacterRace(CharacterRace characterRace) {
        Session session= sessionFactory.getCurrentSession();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter userCharacter =user.getUsercharacter();
        userCharacter.setCharacterRace(characterRace);
        session.saveOrUpdate(userCharacter);

    }

    @Override
    public void saveCharacterEquipment() {

    }

    @Override
    public CharacterRace getCharacterRace(long id) {
        Session session=sessionFactory.getCurrentSession();
        CharacterRace characterRace =session.load(CharacterRace.class,id);
        return characterRace;
    }

    @Override
    public void CreateCharacterStats() {
        Session session = sessionFactory.getCurrentSession();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter characterUser=user.getUsercharacter();


        int str=0;
        int dex=0;
        int con=0;
        int wig=0;
        int m_int=0;
        int free_stats=3;

        CharacterType characterType = characterUser.getCharacterType();
        str+=characterType.getBasic_str();
        dex+=characterType.getBasic_dex();
        con+=characterType.getBasic_con();
        wig+=characterType.getBasic_wig();
        m_int+=characterType.getBasic_int();



        CharacterRace characterRace = characterUser.getCharacterRace();
        str+=characterRace.getBasic_str();
        dex+=characterRace.getBasic_dex();
        con+=characterRace.getBasic_con();
        wig+=characterRace.getBasic_wig();
        m_int+=characterRace.getBasic_int();

        CharacterStats characterStats = new CharacterStats();
        characterStats.setStat_str(str);
        characterStats.setStat_dex(dex);
        characterStats.setStat_con(con);
        characterStats.setStat_wig(wig);
        characterStats.setStat_int(m_int);
        characterStats.setStat_free_points(free_stats);

        characterUser.setCharacterStats(characterStats);
        session.saveOrUpdate(characterStats);
        session.saveOrUpdate(characterUser);
    }

    @Override
    public void CreateCharacterDetails()
    {
        Session session = sessionFactory.getCurrentSession();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter characterUser=user.getUsercharacter();
        CharacterStats characterStats= characterUser.getCharacterStats();
//        CharacterEquipment characterEquipment=characterUser.getCharacterEquipment();
//        int defFromItems=0;
//        int atkFromItems=0;
//        defFromItems+=characterEquipment.getArmor().getDefense();
//        defFromItems+=characterEquipment.getBoots().getDefense();
//        defFromItems+=characterEquipment.getHelment().getDefense();
//        defFromItems+=characterEquipment.getGloves().getDefense();
//        defFromItems+=characterEquipment.getPants().getDefense();
//        atkFromItems+=characterEquipment.getWeapon().getAttack();


        int atk = 30+4*characterStats.getStat_str();
        int m_attack =30+4*characterStats.getStat_int();
        int def = 50+4*characterStats.getStat_con();
        int max_hp = 100+4*characterStats.getStat_con();
        int max_energy = 30+4*characterStats.getStat_wig();
        int chance_avoid = 150-characterStats.getStat_wig();
        int accuracy = 150-characterStats.getStat_dex();
        int crit_chance = 150-characterStats.getStat_dex();
        int crit_damage = 30+4*characterStats.getStat_dex();
        CharacterDetail characterDetail= new CharacterDetail();
        characterDetail.setAttack(atk);
        characterDetail.setDefense(def);
        characterDetail.setAccuracy(accuracy);
        characterDetail.setM_attack(m_attack);
        characterDetail.setActual_energy(max_energy);
        characterDetail.setMax_energy(max_energy);
        characterDetail.setActual_hp(max_hp);
        characterDetail.setMax_hp(max_hp);
        characterDetail.setChance_avoid(chance_avoid);
        characterDetail.setCrit_chance(crit_chance);
        characterDetail.setCrit_damage(crit_damage);
        characterDetail.setMax_exp(100);
        characterDetail.setActual_exp(0);
        characterUser.setCharacterDetail(characterDetail);
        characterUser.setLvl(1);
        session.saveOrUpdate(characterDetail);
        session.saveOrUpdate(characterUser);


    }

     @Override
    public void CreateCharacterStats(UserCharacter characterUser) {
        Session session = sessionFactory.getCurrentSession();




        int str=0;
        int dex=0;
        int con=0;
        int wig=0;
        int m_int=0;
        int free_stats=3;

        CharacterType characterType = characterUser.getCharacterType();
        str+=characterType.getBasic_str();
        dex+=characterType.getBasic_dex();
        con+=characterType.getBasic_con();
        wig+=characterType.getBasic_wig();
        m_int+=characterType.getBasic_int();



        CharacterRace characterRace = characterUser.getCharacterRace();
        str+=characterRace.getBasic_str();
        dex+=characterRace.getBasic_dex();
        con+=characterRace.getBasic_con();
        wig+=characterRace.getBasic_wig();
        m_int+=characterRace.getBasic_int();

        CharacterStats characterStats = new CharacterStats();
        characterStats.setStat_str(str);
        characterStats.setStat_dex(dex);
        characterStats.setStat_con(con);
        characterStats.setStat_wig(wig);
        characterStats.setStat_int(m_int);
        characterStats.setStat_free_points(free_stats);

        characterUser.setCharacterStats(characterStats);
        session.saveOrUpdate(characterStats);
        session.saveOrUpdate(characterUser);
    }

    @Override
    public void CreateCharacterDetails(UserCharacter characterUser)
    {
        Session session = sessionFactory.getCurrentSession();

        CharacterStats characterStats= characterUser.getCharacterStats();
//        CharacterEquipment characterEquipment=characterUser.getCharacterEquipment();
//        int defFromItems=0;
//        int atkFromItems=0;
//        defFromItems+=characterEquipment.getArmor().getDefense();
//        defFromItems+=characterEquipment.getBoots().getDefense();
//        defFromItems+=characterEquipment.getHelment().getDefense();
//        defFromItems+=characterEquipment.getGloves().getDefense();
//        defFromItems+=characterEquipment.getPants().getDefense();
//        atkFromItems+=characterEquipment.getWeapon().getAttack();


        int atk = 30+4*characterStats.getStat_str();
        int m_attack =30+4*characterStats.getStat_int();
        int def = 50+4*characterStats.getStat_con();
        int max_hp = 100+4*characterStats.getStat_con();
        int max_energy = 30+4*characterStats.getStat_wig();
        int chance_avoid = 150-characterStats.getStat_wig();
        int accuracy = 150-characterStats.getStat_dex();
        int crit_chance = 150-characterStats.getStat_dex();
        int crit_damage = 30+4*characterStats.getStat_dex();
        CharacterDetail characterDetail= new CharacterDetail();
        characterDetail.setAttack(atk);
        characterDetail.setDefense(def);
        characterDetail.setAccuracy(accuracy);
        characterDetail.setM_attack(m_attack);
        characterDetail.setActual_energy(max_energy);
        characterDetail.setMax_energy(max_energy);
        characterDetail.setActual_hp(max_hp);
        characterDetail.setMax_hp(max_hp);
        characterDetail.setChance_avoid(chance_avoid);
        characterDetail.setCrit_chance(crit_chance);
        characterDetail.setCrit_damage(crit_damage);
        characterDetail.setMax_exp(100);
        characterDetail.setActual_exp(0);
        characterUser.setCharacterDetail(characterDetail);
        characterUser.setLvl(1);
        session.saveOrUpdate(characterDetail);
        session.saveOrUpdate(characterUser);


    }

    @Override
    public void strIncrease( int stat) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter userCharacter = user.getUsercharacter();
        CharacterStats characterStats = userCharacter.getCharacterStats();
        CharacterDetail characterDetail = userCharacter.getCharacterDetail();
        if(characterStats.getStat_free_points()>0) {
            int actualAttack = characterDetail.getAttack();
            int actualCritDamage = characterDetail.getCrit_damage();
            int actualHp = characterDetail.getMax_hp();
            int actualDef = characterDetail.getDefense();

            characterDetail.setDefense(actualDef + (3 * stat));
            characterDetail.setAttack(actualAttack + (15 * stat));
            characterDetail.setCrit_damage(actualCritDamage + (15 * stat));
            characterDetail.setMax_hp(actualHp + (5 * stat));

            int ActualStat = characterStats.getStat_str();

            for (int i = 0; i < 20; i++) {
                System.out.println("STR Z METODY: " + ActualStat);
            }

            ActualStat += stat;
            characterStats.setStat_str(ActualStat);

            int actualFreeStats = characterStats.getStat_free_points();
            characterStats.setStat_free_points(actualFreeStats - stat);
            sessionFactory.getCurrentSession().saveOrUpdate(characterStats);
            sessionFactory.getCurrentSession().saveOrUpdate(characterDetail);
        }
    }

    @Override
    public void dexIncrease(int stat) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter userCharacter = user.getUsercharacter();
        CharacterStats characterStats = userCharacter.getCharacterStats();
        CharacterDetail characterDetail = userCharacter.getCharacterDetail();
        int actualCritChance = characterDetail.getCrit_chance();
        int actualCritDamage = characterDetail.getCrit_damage();
        int actualChanceToAvoid = characterDetail.getChance_avoid();
        int actualDef = characterDetail.getDefense();
        int actualAccuracy = characterDetail.getAccuracy();
        int actualHp = characterDetail.getMax_hp();
        if(characterStats.getStat_free_points()>0) {
        characterDetail.setMax_hp(actualHp+(5*stat));
        characterDetail.setDefense(actualDef+(3*stat));
        characterDetail.setCrit_chance(actualCritChance+3*stat);
        characterDetail.setCrit_damage(actualCritDamage+(15*stat));
        characterDetail.setChance_avoid(actualChanceToAvoid+3*stat);
        characterDetail.setAccuracy(actualAccuracy+2*stat);


        int ActualStat= characterStats.getStat_dex();



        ActualStat+=stat;
        characterStats.setStat_dex(ActualStat);

        int actualFreeStats = characterStats.getStat_free_points();
        characterStats.setStat_free_points(actualFreeStats-stat);

        sessionFactory.getCurrentSession().saveOrUpdate(characterStats);
        sessionFactory.getCurrentSession().saveOrUpdate(characterDetail);}
    }

    @Override
    public void intIncrease(int stat) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter userCharacter = user.getUsercharacter();
        CharacterStats characterStats = userCharacter.getCharacterStats();
        CharacterDetail characterDetail = userCharacter.getCharacterDetail();
        int actualAttack = characterDetail.getM_attack();
        int actualCritDamage = characterDetail.getCrit_damage();
        int actualHp = characterDetail.getMax_hp();
        int actualDef = characterDetail.getDefense();
        if(characterStats.getStat_free_points()>0) {
        characterDetail.setM_attack(actualAttack+(15*stat));
        characterDetail.setCrit_damage(actualCritDamage+(15*stat));
        characterDetail.setMax_hp(actualHp+(5*stat));
        characterDetail.setDefense(actualDef+(3*stat));

        int ActualStat= characterStats.getStat_int();

        ActualStat+=stat;
        characterStats.setStat_int(ActualStat);


        int actualFreeStats = characterStats.getStat_free_points();
        characterStats.setStat_free_points(actualFreeStats-stat);
        sessionFactory.getCurrentSession().saveOrUpdate(characterStats);
        sessionFactory.getCurrentSession().saveOrUpdate(characterDetail);}
    }

    @Override
    public void conIncrease(int stat) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter userCharacter = user.getUsercharacter();
        CharacterStats characterStats = userCharacter.getCharacterStats();
        CharacterDetail characterDetail = userCharacter.getCharacterDetail();
        int actualAttack = characterDetail.getAttack();
        int actualCritDamage = characterDetail.getCrit_damage();
        int actualHp = characterDetail.getMax_hp();
        int actualDef = characterDetail.getDefense();
        if(characterStats.getStat_free_points()>0) {
        characterDetail.setAttack(actualAttack+(4*stat));
        characterDetail.setCrit_damage(actualCritDamage+(4*stat));
        characterDetail.setMax_hp(actualHp+(16*stat));
        characterDetail.setDefense(actualDef+(15*stat));

        int ActualStat= characterStats.getStat_con();

        ActualStat+=stat;
        characterStats.setStat_con(ActualStat);

        int actualFreeStats = characterStats.getStat_free_points();
        characterStats.setStat_free_points(actualFreeStats-stat);
        sessionFactory.getCurrentSession().saveOrUpdate(characterStats);
        sessionFactory.getCurrentSession().saveOrUpdate(characterDetail);}
    }

    @Override
    public void wigIncrease(int stat) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        UserCharacter userCharacter = user.getUsercharacter();
        CharacterStats characterStats = userCharacter.getCharacterStats();
        CharacterDetail characterDetail = userCharacter.getCharacterDetail();
        int actualAttack = characterDetail.getAttack();
        int actualCritDamage = characterDetail.getCrit_damage();
        int actualHp = characterDetail.getMax_hp();
        int actualEnergy = characterDetail.getMax_energy();
        if(characterStats.getStat_free_points()>0) {
        characterDetail.setAttack(actualAttack+(3*stat));
        characterDetail.setCrit_damage(actualCritDamage+(3*stat));
        characterDetail.setMax_hp(actualHp+(3*stat));
        characterDetail.setMax_energy(actualEnergy+(3*stat));

        int ActualStat= characterStats.getStat_wig();



        ActualStat+=stat;
        characterStats.setStat_wig(ActualStat);

        int actualFreeStats = characterStats.getStat_free_points();
        characterStats.setStat_free_points(actualFreeStats-stat);
        sessionFactory.getCurrentSession().saveOrUpdate(characterStats);
        sessionFactory.getCurrentSession().saveOrUpdate(characterDetail);}
    }


}
