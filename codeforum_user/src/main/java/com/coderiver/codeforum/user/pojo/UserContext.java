package com.coderiver.codeforum.user.pojo;

import java.io.Serializable;

/**
 * Created by Shiyu Rao on 08/03/2019.
 */
public class UserContext implements Serializable {
    private User user;
    private UserProfile userProfile;

    public UserContext() {
    }

    public UserContext(User user, UserProfile userProfile) {
        this.user = user;
        this.userProfile = userProfile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public String toString() {
        return "UserContext{" +
                "user=" + user +
                ", userProfile=" + userProfile +
                '}';
    }
}
