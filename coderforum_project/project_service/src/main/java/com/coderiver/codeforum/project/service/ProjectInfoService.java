package com.coderiver.codeforum.project.service;

import com.coderiver.codeforum.common.entity.PageResult;
import com.coderiver.codeforum.common.entity.StatusCode;
import com.coderiver.codeforum.common.util.IdGenerator;
import com.coderiver.codeforum.project.consts.ConstantsPool;
import com.coderiver.codeforum.project.dao.ProjectInfoDao;
import com.coderiver.codeforum.project.exception.CustomerException;
import com.coderiver.codeforum.project.pojo.ProjectInfo;
import com.coderiver.codeforum.project.pojo.ProjectInfoForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;

/**
 * @Author: solo
 * @Date: 2019/4/30 11:19 AM
 * @Version 1.0
 */
@Service
public class ProjectInfoService {

    @Autowired
    IdGenerator idGenerator;

    @Autowired
    ProjectInfoDao infoDao;


    /**
     * 保存新项目
     *
     * @param form
     * @return
     */
    public ProjectInfo save(ProjectInfoForm form) {
        ProjectInfo info = new ProjectInfo();
        BeanUtils.copyProperties(form, info);

        String id = String.valueOf(idGenerator.nextId());
        info.setProjectId(id);
        //新建项目时状态自动为招募中
        info.setProjectStatus(ConstantsPool.PROJECT_STATUS_RECRUIT);
        long time = System.currentTimeMillis();
        info.setCreateTime(time);
        info.setUpdateTime(time);
        return infoDao.save(info);
    }

    /**
     * 更新项目
     *
     * @param id
     * @param form
     */
    public boolean update(String id, ProjectInfoForm form) {
        ProjectInfo projectInfo = findById(id);
        BeanUtils.copyProperties(form, projectInfo);
        projectInfo.setUpdateTime(System.currentTimeMillis());
        ProjectInfo save = infoDao.save(projectInfo);
        return id.equals(save.getProjectId());
    }

    /**
     * 删除项目
     *
     * @return
     */
    public boolean delete(String id) {
        ProjectInfo projectInfo = findById(id);
        projectInfo.setProjectStatus(ConstantsPool.PROJECT_STATUS_DELETE);
        projectInfo.setUpdateTime(System.currentTimeMillis());

        ProjectInfo save = infoDao.save(projectInfo);
        return id.equals(save.getProjectId());
    }

    /**
     * 分页查询所有非删除状态的项目
     *
     * @param page
     * @param size
     * @return
     */
    public PageResult findAllNotDeleteProject(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ProjectInfo> infoPage = infoDao.findAll(new Specification<ProjectInfo>() {
            @Override
            public Predicate toPredicate(Root<ProjectInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.notEqual(root.get("projectStatus"), ConstantsPool.PROJECT_STATUS_DELETE);
                return predicate;
            }
        }, pageRequest);
        return new PageResult(infoPage.getTotalElements(), infoPage.getContent());
    }

    public ProjectInfo findById(String id) {
        Optional<ProjectInfo> optional = infoDao.findById(id);
        if (!optional.isPresent()) {
            throw new CustomerException(StatusCode.ID_NOT_EXIST, "id不存在");
        }
        return optional.get();
    }
}
