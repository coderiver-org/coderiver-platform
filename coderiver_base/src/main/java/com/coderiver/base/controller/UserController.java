package com.coderiver.base.controller;

import com.coderiver.base.pojo.User;
import com.coderiver.base.pojo.exception.CustomerException;
import com.coderiver.base.service.UserService;
import com.coderiver.common.entity.Result;
import com.coderiver.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ultratendency on 2019/1/2.
 */
@RestController
@CrossOrigin
@RequestMapping("/base/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        /*if (1 == 1){
            // 测试自定义错误
            throw new CustomerException("222", "测试错误");
        }*/
        return new Result(true, StatusCode.OK, "查询成功", userService.findAll());
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("userId") String userId){
//        int n = 1 / 0; // 测试未获取错误
        return new Result(true, StatusCode.OK, "查询成功", userService.findById(userId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody User user){
        userService.save(user);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.PUT)
    public Result update(@PathVariable String userId, @RequestBody User user){
        user.setId(userId);
        userService.update(user);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String userId){
        userService.deleteById(userId);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
