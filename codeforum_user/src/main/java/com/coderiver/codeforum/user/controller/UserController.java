package com.coderiver.codeforum.user.controller;

import com.coderiver.codeforum.common.entity.Result;
import com.coderiver.codeforum.common.entity.StatusCode;
import com.coderiver.codeforum.user.pojo.UserContext;
import com.coderiver.codeforum.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * Created by Shiyu Rao on 08/03/2019.
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "find All Success", userService.getAllUserContext());
    }

    /**
     *  page begin from 1
     *  size means the number per size
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
    public Result pageQuery(@PathVariable int page, @PathVariable int size){
        return new Result(true, StatusCode.OK, "find Page Success",
                userService.getPageUserContext(page, size));
    }

    @RequestMapping(value = {"/{registerType}", ""}, method = RequestMethod.POST)
    public Result registerUserByType(@RequestBody UserContext userContext, @PathVariable(required = false) Integer registerType){
        //TODO 非空校验
        logger.debug("here we received registerType:" + registerType);
        boolean isExist = userService.registerUser(userContext, registerType);
        if (!isExist){
            return new Result(true, StatusCode.REPERROR, "Username has been used");
        }
        return new Result(true, StatusCode.OK, "register success");
    }
}
