package com.coderiver.codeforum.user.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Shiyu Rao on 08/03/2019.
 */
@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable {
    @Id
    private Long id;

    @Column(nullable = false)
    private Long userid;

    private Long birthday;
    @Column(nullable = false)
    private String email;
    private String phone;
    private String avatar;
    private Integer gender;
    private Long city;
    private String description;
    private Integer workdaystarttime;
    private Integer workdayendtime;
    private Integer weekendstarttime;
    private Integer weekendendtime;
    private Long createtime;
    private Long updatetime;

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", userid=" + userid +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", gender=" + gender +
                ", city=" + city +
                ", description='" + description + '\'' +
                ", workdaystartzime=" + workdaystarttime +
                ", workdayendtime=" + workdayendtime +
                ", weekendstarttime=" + weekendstarttime +
                ", weekendendtime=" + weekendendtime +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWorkdaystarttime() {
        return workdaystarttime;
    }

    public void setWorkdaystarttime(Integer workdaystarttime) {
        this.workdaystarttime = workdaystarttime;
    }

    public Integer getWorkdayendtime() {
        return workdayendtime;
    }

    public void setWorkdayendtime(Integer workdayendtime) {
        this.workdayendtime = workdayendtime;
    }

    public Integer getWeekendstarttime() {
        return weekendstarttime;
    }

    public void setWeekendstarttime(Integer weekendstarttime) {
        this.weekendstarttime = weekendstarttime;
    }

    public Integer getWeekendendtime() {
        return weekendendtime;
    }

    public void setWeekendendtime(Integer weekendendtime) {
        this.weekendendtime = weekendendtime;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }
}
