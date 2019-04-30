package com.coderiver.codeforum.project.service;

import com.coderiver.codeforum.common.entity.StatusCode;
import com.coderiver.codeforum.common.util.IdGenerator;
import com.coderiver.codeforum.project.consts.ConstantsPool;
import com.coderiver.codeforum.project.dao.ProjectCategoryDao;
import com.coderiver.codeforum.project.exception.CustomerException;
import com.coderiver.codeforum.project.pojo.ProjectCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * @Author: solo
 * @Date: 2019/4/30 11:27 AM
 * @Version 1.0
 */
@Service
public class ProjectCategoryService {

    @Autowired
    IdGenerator idGenerator;

    @Autowired
    ProjectCategoryDao categoryDao;

    /**
     * 新增分类
     *
     * @param categoryName
     * @return
     */
    public boolean save(String categoryName) {
        ProjectCategory category = new ProjectCategory();
        String id = String.valueOf(idGenerator.nextId());

        category.setId(id);
        category.setName(categoryName);
        category.setStatus(ConstantsPool.PROJECT_CATEGORY_STATUS_NORMAL);

        ProjectCategory save = categoryDao.save(category);
        return id.equals(save.getId());
    }

    /**
     * 更新分类名称
     *
     * @param id
     * @param name
     * @return
     */
    public boolean updateName(String id, String name) {
        Optional<ProjectCategory> optional = categoryDao.findById(id);
        if (!optional.isPresent()) {
            throw new CustomerException(StatusCode.ID_NOT_EXIST, "id不存在");
        }
        if (StringUtils.isEmpty(name)) {
            throw new CustomerException(StatusCode.CATEGORY_NAME_EMPTY, "类目名称不能为空");
        }
        ProjectCategory category = optional.get();
        category.setName(name);
        ProjectCategory save = categoryDao.save(category);
        return id.equals(save.getId());
    }

    /**
     * 根据id删除项目分类
     * @param id
     * @return
     */
    public boolean deleteById(String id) {
        Optional<ProjectCategory> optional = categoryDao.findById(id);
        if (!optional.isPresent()) {
            throw new CustomerException(StatusCode.ID_NOT_EXIST, "id不存在");
        }
        ProjectCategory category = optional.get();
        category.setStatus(ConstantsPool.PROJECT_CATEGORY_STATUS_DELETE);
        ProjectCategory save = categoryDao.save(category);

        return id.equals(save.getId());
    }

    /**
     * 查询所有状态正常的类目
     * @return
     */
    public List<ProjectCategory> findAllNormal(){
        return categoryDao.findAllByStatus(ConstantsPool.PROJECT_CATEGORY_STATUS_NORMAL);
    }


}
