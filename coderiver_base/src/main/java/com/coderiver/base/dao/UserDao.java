package com.coderiver.base.dao;

import com.coderiver.base.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Ultratendency on 2019/1/2.
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

}
