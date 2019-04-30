package com.coderiver.codeforum.project.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: solo
 * @Date: 2019/4/30 10:46 AM
 * @Version 1.0
 */
@Entity
@Table(name = "project_picture")
@Data
public class ProjectPicture {

    @Id
    private String id;

    @Column(nullable = false)
    private String projectId;

    //图片地址
    private String pictureUrl;

    private String pictureUrl32;

    private String pictureUrl64;

}
