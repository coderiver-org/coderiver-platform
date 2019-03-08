package com.coderiver.codeforum.user.controller.exceptionHandler;


import com.coderiver.codeforum.common.entity.Result;
import com.coderiver.codeforum.common.entity.StatusCode;
import com.coderiver.codeforum.user.pojo.exception.CustomerException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Shiyu Rao on 2019/1/2.
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
