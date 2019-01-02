package com.coderiver.base.pojo.exception;

/**
 * Created by Ultratendency on 2019/1/2.
 */
public class CustomerException extends RuntimeException {

    private String retCd;  //异常对应的返回码
    private String msgDes;  //异常对应的描述信息

    public ExceptionInfo getExceptionInfo(){
        return new ExceptionInfo(this.retCd, this.msgDes);
    }

    public CustomerException() {
        super();
    }

    public CustomerException(String message) {
        super(message);
        msgDes = message;
    }

    public CustomerException(String retCd, String msgDes) {
        super();
        this.retCd = retCd;
        this.msgDes = msgDes;
    }

    public String getRetCd() {
        return retCd;
    }

    public String getMsgDes() {
        return msgDes;
    }
}
