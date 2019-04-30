package com.coderiver.codeforum.project.exception;

import lombok.Getter;

/**
 * @Author: solo
 * @Date: 2019/4/30 11:45 AM
 * @Version 1.0
 * 自定义异常
 */
@Getter
public class CustomerException extends RuntimeException {

    private Integer code;

    public CustomerException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
