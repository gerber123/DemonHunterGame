package com.gerber.LogInPackage.service;


import com.gerber.LogInPackage.dao.RoleDao;
import com.gerber.LogInPackage.dao.UserDAO;
import com.gerber.LogInPackage.entity.Role;
import com.gerber.LogInPackage.entity.User;
import com.gerber.LogInPackage.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;



    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();

        return users;
    }

    @Override
    @Transactional
    public User findByUserName(String userName) {
        // check the database if the user already exists
        return userDao.findByUserName(userName);
    }

    @Override
    @Transactional
    public  List<User> findByUserNameFinder(String userName) {
        return userDao.findByUserNameFinder(userName);
    }

    @Override
    @Transactional
    public void save(CrmUser crmUser) {
        User user = new User();
        // assign user details to the user object
        user.setUserName(crmUser.getUserName());
        user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
        user.setFirstName(crmUser.getFirstName());
        user.setLastName(crmUser.getLastName());
        user.setEmail(crmUser.getEmail());
        // give user default role of "employee"
        user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_EMPLOYEE")));

        // save user in the database
        userDao.save(user);
    }

    @Override
    @Transactional
    public void saveUser(User user) {

        // give user default role of "employee"

        Collection<Role> e =user.getRoles();
        Role firstElementOfRoles = e.iterator().next();
        String firstElementOfRolesToString = firstElementOfRoles.getName();


//        System.out.println(user.getLast_vote_date().getTime()+"<<<<<<<<<<<<<<<<<<<<<<<<<");
            user.setRoles(Arrays.asList(roleDao.findRoleByName(firstElementOfRolesToString)));

//        user.setLast_vote_date(user.getLast_vote_date());
        // save user in the database
        userDao.save(user);
    }

    @Override
    @Transactional
    public User getUser(long theId) {
        User user =userDao.getUser(theId);
        return user;
    }

    @Override
    @Transactional
    public void deleteUser(long theId) {
        userDao.deleteUser(theId);
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
