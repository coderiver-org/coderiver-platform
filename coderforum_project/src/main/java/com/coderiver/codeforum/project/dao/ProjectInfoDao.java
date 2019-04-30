package com.coderiver.codeforum.project.dao;

import com.coderiver.codeforum.project.pojo.ProjectInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @Author: solo
 * @Date: 2019/4/30 11:11 AM
 * @Version 1.0
 */
public interface ProjectInfoDao extends JpaRepository<ProjectInfo, String>, JpaSpecificationExecutor<ProjectInfo> {

}
