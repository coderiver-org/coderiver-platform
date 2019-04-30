package com.coderiver.codeforum.project.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author: solo
 * @Date: 2019/4/30 3:00 PM
 * @Version 1.0
 * controller 接收的项目信息类
 */
@Data
public class ProjectInfoForm {

    @NotEmpty(message = "项目名称不能为空")
    private String projectName;

    //项目难度
    @NotNull(message = "项目难度不能为空")
    private Float projectDifficulty;

    //项目类型类目编号
    @NotEmpty(message = "项目类型不能为空")
    private String categoryId;

    //项目简介
    private String projectDesc;

    //项目创建者id
    @NotEmpty(message = "项目创建者不能为空")
    private String projectCreaterId;

    //项目所属团队id
    private String teamId;

}
