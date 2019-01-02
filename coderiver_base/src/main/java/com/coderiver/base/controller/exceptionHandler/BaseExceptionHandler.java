package com.coderiver.base.controller.exceptionHandler;

import com.coderiver.base.pojo.exception.CustomerException;
import com.coderiver.common.entity.Result;
import com.coderiver.common.entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Ultratendency on 2019/1/2.
 * 异常处理类
 */
@RestControllerAdvice
public class BaseExceptionHandler {


    @ExceptionHandler(value = CustomerException.class)
    public Result customer_exception(CustomerException e){
        e.printStackTrace();
        return new Result(false, StatusCode.CUSTOMER_ERROR, "自定义异常", e.getExceptionInfo());
    }

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }

}
