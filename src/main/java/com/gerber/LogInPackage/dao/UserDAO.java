package com.gerber.LogInPackage.dao;

import com.gerber.GamePackage.entity.UserCharacter;
import com.gerber.LogInPackage.entity.User;


import java.util.List;

public interface UserDAO
{

    public List<User> getAllUsers();

    User findByUserName(String userName);

    public UserCharacter getChar(int id);

    void save(User user);

    User getUser(long theId);

    void deleteUser(long theId);


    List<User> findByUserNameFinder(String userName);


}
