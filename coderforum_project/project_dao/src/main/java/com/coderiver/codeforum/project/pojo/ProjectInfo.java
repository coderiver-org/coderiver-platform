package com.coderiver.codeforum.project.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: solo
 * @Date: 2019/4/30 10:30 AM
 * @Version 1.0
 * 项目信息Entity
 */
@Entity
@Table(name = "project_info")
@Data
public class ProjectInfo {

    @Id
    private String projectId;

    private String projectName;

    //项目难度
    private Float projectDifficulty;

    //项目类型类目编号
    private String categoryId;

    //项目状态, 0招募中，1 进行中，2已完成，3失败，4延期，5删除
    private Integer projectStatus;

    //项目简介
    private String projectDesc;

    //项目创建者id
    private String projectCreaterId;

    //项目所属团队id
    private String teamId;

    private Long createTime;

    private Long updateTime;


}
