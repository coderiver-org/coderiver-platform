package com.coderiver.codeforum.project.util;

import com.coderiver.codeforum.common.entity.Result;
import com.coderiver.codeforum.common.entity.StatusCode;

/**
 * @Author: solo
 * @Date: 2019/4/30 11:50 AM
 * @Version 1.0
 * 对返回结果封装的快捷工具类
 */
public class ResultUtil {

    public static Result success(){
        return new Result(true, StatusCode.OK, "success");
    }

    public static Result success(Object data){
        return new Result(true, StatusCode.OK, "success", data);
    }

    public static Result success(String message, Object data){
        return new Result(true, StatusCode.OK, message, data);
    }

    public static Result error(int code, String message){
        return new Result(false, code, message);
    }

    public static Result error(int code, String message, Object data){
        return new Result(false, code, message, data);
    }
}
