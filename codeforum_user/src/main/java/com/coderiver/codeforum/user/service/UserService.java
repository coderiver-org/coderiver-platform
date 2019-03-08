package com.coderiver.codeforum.user.service;

import com.coderiver.codeforum.common.entity.Message;
import com.coderiver.codeforum.common.entity.PageResult;
import com.coderiver.codeforum.common.util.IdGenerator;
import com.coderiver.codeforum.user.dao.UserDao;
import com.coderiver.codeforum.user.dao.UserProfileDao;
import com.coderiver.codeforum.user.pojo.ConstantPool;
import com.coderiver.codeforum.user.pojo.User;
import com.coderiver.codeforum.user.pojo.UserContext;
import com.coderiver.codeforum.user.pojo.UserProfile;
import com.coderiver.codeforum.user.util.RabbitUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Shiyu Rao on 08/03/2019.
 */
@Service
@Transactional
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserProfileDao userProfileDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public boolean registerUser(UserContext userContext, Integer registerType){

        User user = userContext.getUser();
        //检查username是否已经存在
        User targetUser = userDao.findByUsername(user.getUsername());
        if (targetUser != null){
            logger.debug("user {} already exist.", user.getUsername());
            return false;
        }
        Long userId = idGenerator.nextId();
        logger.debug("here is the id:" + userId);
        Long nowTime = new Date().getTime();
        user.setId(userId);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setStatus(ConstantPool.USER_STATUS_UNACTIVATE);
        user.setCreatetime(nowTime);
        logger.debug("here is the user:" + user);
        userDao.save(user);
        logger.debug("i have been here ......");
        UserProfile userProfile = userContext.getUserProfile();
        userProfile.setId(idGenerator.nextId());
        userProfile.setUserid(userId);
        userProfile.setCreatetime(nowTime);
        logger.debug("here is the profile:" + userProfile);
        userProfileDao.save(userProfile);
        // 根据激活方式不同 激活
        if (registerType != null){
            switch (registerType){
                case ConstantPool.USER_REGISTER_TYPE_EMAIL:
                    RabbitUtil.sendMessge2Rabbit(rabbitTemplate, ConstantPool.USER_REGISTER_TYPE_EMAIL_EXCHANGE,
                            ConstantPool.USER_REGISTER_TYPE_EMAIL_TOPIC,
                            new Message<>(ConstantPool.USER_REGISTER_TYPE_EMAIL, "register me now here is using email"));
                    break;
                case ConstantPool.USER_REGISTER_TYPE_SMS:
                    RabbitUtil.sendMessge2Rabbit(rabbitTemplate, ConstantPool.USER_REGISTER_TYPE_SMS_EXCHANGE,
                            ConstantPool.USER_REGISTER_TYPE_SMS_TOPIC,
                            new Message<>(ConstantPool.USER_REGISTER_TYPE_SMS, "register me now here is using sms"));
                    break;
                default:
                    RabbitUtil.sendMessge2Rabbit(rabbitTemplate, ConstantPool.USER_REGISTER_TYPE_EMAIL_EXCHANGE,
                            ConstantPool.USER_REGISTER_TYPE_EMAIL_TOPIC,
                            new Message<>(ConstantPool.USER_REGISTER_TYPE_EMAIL, "register me now here is using email"));
                    break;
            }
        }else {
            // default is sending email
            RabbitUtil.sendMessge2Rabbit(rabbitTemplate, ConstantPool.USER_REGISTER_TYPE_EMAIL_EXCHANGE,
                    ConstantPool.USER_REGISTER_TYPE_EMAIL_TOPIC,
                    new Message<>(ConstantPool.USER_REGISTER_TYPE_EMAIL, "register me now here is using email"));
        }

        return true;
    }

    public List<UserContext> getAllUserContext(){
        List<UserContext> userContexts = new ArrayList<>();
        List<User> users = userDao.findAll();
        for (User user : users){
            UserProfile userProfile = userProfileDao.findByUserid(user.getId());
            userContexts.add(new UserContext(user, userProfile));
        }
        return userContexts;
    }

    public PageResult<UserContext> getPageUserContext(int page, int size){
        List<UserContext> userContexts = new ArrayList<>();
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<User> users = userDao.findAll(pageable);
        for (User user : users.getContent()){
            userContexts.add(new UserContext(user, userProfileDao.findByUserid(user.getId())));
        }
        return new PageResult(users.getTotalElements(), userContexts);
    }
}
