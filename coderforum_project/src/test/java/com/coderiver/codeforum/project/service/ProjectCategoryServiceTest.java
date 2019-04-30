package com.coderiver.codeforum.project.service;

import com.coderiver.codeforum.project.ProjectApplicationTest;
import com.coderiver.codeforum.project.pojo.ProjectCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: solo
 * @Date: 2019/4/30 1:56 PM
 * @Version 1.0
 */
public class ProjectCategoryServiceTest extends ProjectApplicationTest {

    @Autowired
    ProjectCategoryService service;

    private String id = "1123106307792146432";

    @Test
    public void save() {
        boolean result = service.save("社交");
        Assert.assertTrue(result);
    }

    @Test
    public void updateName() {
        boolean result = service.updateName(id, "电商");
        Assert.assertTrue(result);
    }

    @Test
    public void deleteById() {
        boolean result = service.deleteById(id);
        Assert.assertTrue(result);
    }

    @Test
    public void findAllNormal() {
        List<ProjectCategory> list = service.findAllNormal();
        Assert.assertTrue(list.size() > 0);
    }
}