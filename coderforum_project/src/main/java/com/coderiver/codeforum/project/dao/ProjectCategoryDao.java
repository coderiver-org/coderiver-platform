package com.coderiver.codeforum.project.dao;

import com.coderiver.codeforum.project.pojo.ProjectCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author: solo
 * @Date: 2019/4/30 11:26 AM
 * @Version 1.0
 */
public interface ProjectCategoryDao extends JpaRepository<ProjectCategory, String>, JpaSpecificationExecutor<ProjectCategory> {

    List<ProjectCategory> findAllByStatus(int status);
}
