package com.coderiver.codeforum.project.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: solo
 * @Date: 2019/4/30 10:38 AM
 * @Version 1.0
 */
@Entity
@Table(name = "project_like_user")
@Data
public class ProjectLikeUser {

    @Id
    private String id;

    //项目id
    @Column(nullable = false)
    private String projectId;

    //点赞的用户id
    @Column(nullable = false)
    private String userId;

    //点赞状态，0 取消点赞，1点赞
    @Column(nullable = false)
    private Integer status;

    private Integer type;

    private Long createTime;

    private Long updateTime;
}
