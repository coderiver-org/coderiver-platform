package com.coderiver.codeforum.user.dao;

import com.coderiver.codeforum.user.pojo.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Shiyu Rao on 08/03/2019.
 */
public interface UserProfileDao extends JpaRepository<UserProfile, String>, JpaSpecificationExecutor<UserProfile> {
    UserProfile findByUserid(Long userId);
}
