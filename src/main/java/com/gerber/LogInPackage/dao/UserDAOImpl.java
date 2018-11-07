package com.gerber.LogInPackage.dao;


import com.gerber.GamePackage.entity.UserCharacter;
import com.gerber.LogInPackage.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO
{
    public final static long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        Session session =sessionFactory.getCurrentSession();
//        List<Websites> listOfPlayers = session.createQuery("from Websites",Websites.class).getResultList();
//        return listOfPlayers;
        // get the current hibernate session

        // create a query  ... sort by last name
        Query<User> theQuery = session.createQuery("from User", User.class);

        // execute query and get result list
        List<User> crmUsers = theQuery.getResultList();

        // return the results
        return crmUsers;
    }
    @Override
    public User findByUserName(String theUserName) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using username
        Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
        theQuery.setParameter("uName", theUserName);
        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();

        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

    @Override
    public void save(User theUser) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create the user ... finally LOL
        currentSession.saveOrUpdate(theUser);
    }

    @Override
    public User getUser(long theId) {
        Session session =sessionFactory.getCurrentSession();
        User user=session.get(User.class,theId);
        return user;
    }


    @Transactional
    public UserCharacter getChar(int id)
    {
        Session session =sessionFactory.getCurrentSession();
        UserCharacter usercharacter =session.get(UserCharacter.class,id);
        return usercharacter;
    }

    @Override
    public void deleteUser(long theId) {
        Session session=sessionFactory.getCurrentSession();
        User user=session.get(User.class,theId);
        session.delete(user);
    }

    @Override
    public  List<User>  findByUserNameFinder(String userNameee) {
        Session session=sessionFactory.getCurrentSession();
        Query q=null;
        if(userNameee !=null&& userNameee.trim().length()>0)
        {
            q=session.createQuery ("from User where lower(userName) like :theName or Lower(lastName) like :theName", User.class);
            q.setParameter("theName","%"+ userNameee.toLowerCase()+"%");
        }
        else
        {
            q =session.createQuery("from User", User.class);
        }
        List<User>  users =q.getResultList();
        return users;
    }

}
