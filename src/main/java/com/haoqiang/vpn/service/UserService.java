package com.haoqiang.vpn.service;

import com.haoqiang.vpn.domain.User;
import com.haoqiang.vpn.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Haoqiang Lyu
 * @date 2019-06-19 13:20
 */

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;


    public User save(User user){
        //TODO add logic
        return userDao.save(user);
    }

    public List<User> saveUsers(List<User> users){
        return userDao.saveUsers(users);
    }

    public List<User> findAll(){
        List<User> users = userDao.findAll();
        return users;
    }

    public User findById(Long id){
        User user = userDao.findById(id);
        return user;
    }

    public List<User> findByUsernameIgnoreCase(String username){
        List<User> users = userDao.findByUsernameIgnoreCase(username);
        return users;
    }



}