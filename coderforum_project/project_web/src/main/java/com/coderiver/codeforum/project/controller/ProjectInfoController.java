package com.coderiver.codeforum.project.controller;

import com.coderiver.codeforum.common.entity.PageResult;
import com.coderiver.codeforum.common.entity.Result;
import com.coderiver.codeforum.common.entity.StatusCode;
import com.coderiver.codeforum.project.exception.CustomerException;
import com.coderiver.codeforum.project.pojo.ProjectInfo;
import com.coderiver.codeforum.project.pojo.ProjectInfoForm;
import com.coderiver.codeforum.project.service.ProjectInfoService;
import com.coderiver.codeforum.project.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: solo
 * @Date: 2019/4/30 3:04 PM
 * @Version 1.0
 */
@RestController
@Slf4j
public class ProjectInfoController {

    @Autowired
    ProjectInfoService infoService;

    @PostMapping("/save")
    public Result save(@Valid ProjectInfoForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new CustomerException(StatusCode.PARAMS_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        ProjectInfo info = infoService.save(form);
        if (info == null) {
            throw new CustomerException(StatusCode.ERROR_SAVE_PROJECT_INFO, "新建项目失败");
        }
        return ResultUtil.success(info);
    }

    @PostMapping("/update/{id}")
    public Result update(@PathVariable("id") String id, @Valid ProjectInfoForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new CustomerException(StatusCode.PARAMS_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        boolean update = infoService.update(id, form);
        if (update) {
            return ResultUtil.success();
        }
        return ResultUtil.error(StatusCode.ERROR_UPDATE_PROJECT_INFO, "更新项目失败");
    }

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id) {
        boolean delete = infoService.delete(id);
        if (delete) {
            return ResultUtil.success();
        }
        return ResultUtil.error(StatusCode.ERROR_DELETE_PROJECT_INFO, "删除项目失败");
    }

    @GetMapping("/all")
    public Result findAll(@RequestParam("page") Integer page,
                          @RequestParam("size") Integer size) {
        PageResult pageResult = infoService.findAllNotDeleteProject(page, size);
        return ResultUtil.success(pageResult);
    }

    @GetMapping("/find/{id}")
    public Result findById(@PathVariable("id") String id){
        ProjectInfo info = infoService.findById(id);
        return ResultUtil.success(info);
    }
}
