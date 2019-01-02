package com.coderiver.base.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Ultratendency on 2019/1/2.
 */
@Entity
@Table(name = "user_info")
public class User implements Serializable {
    //TODO 补充
    @Id
    private String id;

    private String name;
    private String password;
    //TODO 设计数据库表格 再补充
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
