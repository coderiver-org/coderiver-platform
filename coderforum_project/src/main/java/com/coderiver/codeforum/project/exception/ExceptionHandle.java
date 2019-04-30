package com.coderiver.codeforum.project.exception;

import com.coderiver.codeforum.common.entity.Result;
import com.coderiver.codeforum.project.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: solo
 * @Date: 2019/4/30 11:56 AM
 * @Version 1.0
 * 自定义异常处理
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = CustomerException.class)
    @ResponseBody
    public Result handle(CustomerException e){
        return ResultUtil.error(e.getCode(), e.getMessage());
    }
}
