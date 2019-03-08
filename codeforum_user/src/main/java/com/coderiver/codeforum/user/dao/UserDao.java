package com.coderiver.codeforum.user.dao;

import com.coderiver.codeforum.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * Created by Shiyu Rao on 08/03/2019.
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
    User findByUsername(String username);

}
