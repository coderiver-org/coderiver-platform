package com.coderiver.base.service;

import com.coderiver.base.dao.UserDao;
import com.coderiver.base.pojo.User;
import com.coderiver.common.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ultratendency on 2019/1/2.
 */
@Service
@Transactional
public class UserService {
    //TODO 补充
    @Autowired
    private UserDao userDao;
    @Autowired
    private IdGenerator idGenerator;

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User findById(String id){
        return userDao.findById(id).get();
    }

    public void save(User user){
        user.setId(idGenerator.nextId() + "");
        userDao.save(user);
    }

    public void update(User user){
        userDao.save(user);
    }

    public void deleteById(String id){
        userDao.deleteById(id);
    }
}
