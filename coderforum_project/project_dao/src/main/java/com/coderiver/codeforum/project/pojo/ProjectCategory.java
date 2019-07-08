package com.coderiver.codeforum.project.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: solo
 * @Date: 2019/4/30 10:49 AM
 * @Version 1.0
 */
@Entity
@Table(name = "project_category")
@Data
public class ProjectCategory {

    @Id
    private String id;

    private String name;

    //状态。1正常，2删除
    private Integer status;

    //备注
    private String remark;
}
