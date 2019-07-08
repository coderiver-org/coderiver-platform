package com.coderiver.codeforum.project.controller;

import com.coderiver.codeforum.common.entity.Result;
import com.coderiver.codeforum.common.entity.StatusCode;
import com.coderiver.codeforum.project.pojo.ProjectCategory;
import com.coderiver.codeforum.project.service.ProjectCategoryService;
import com.coderiver.codeforum.project.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: solo
 * @Date: 2019/4/30 2:17 PM
 * @Version 1.0
 */
@RestController
public class ProjectCategoryController {

    @Autowired
    ProjectCategoryService categoryService;

    @PostMapping("/category/save")
    @ApiOperation("")
    public Result save(@RequestParam("name") String name) {
        boolean save = categoryService.save(name);
        if (save) {
            return ResultUtil.success();
        }
        return ResultUtil.error(StatusCode.ERROR_SAVE_PROJECT_CATEGORY, "新增项目类型失败");
    }

    @PostMapping("/category/update")
    @ApiOperation("")
    public Result updateName(@RequestParam("id") String id,
                             @RequestParam("name") String name) {
        boolean flag = categoryService.updateName(id, name);
        if (flag) {
            return ResultUtil.success();
        }
        return ResultUtil.error(StatusCode.ERROR_UPDATE_PROJECT_CATEGORY, "更新项目类型失败");
    }

    @PostMapping("/category/delete/{id}")
    @ApiOperation("")
    public Result delete(@PathVariable("id") String id) {
        boolean flag = categoryService.deleteById(id);
        if (flag){
            return ResultUtil.success();
        }
        return ResultUtil.error(StatusCode.ERROR_DELETE_PROJECT_CATEGORY, "删除失败");
    }

    @GetMapping("/categories")
    @ApiOperation("")
    public Result findAllNormal(){
        List<ProjectCategory> list = categoryService.findAllNormal();
        return ResultUtil.success(list);
    }

}
