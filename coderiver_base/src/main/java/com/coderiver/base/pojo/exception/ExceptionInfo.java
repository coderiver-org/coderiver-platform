package com.coderiver.base.pojo.exception;

import java.io.Serializable;

/**
 * Created by Ultratendency on 2019/1/2.
 */
public class ExceptionInfo implements Serializable {
    private String retCd;  //异常对应的返回码
    private String msgDes;  //异常对应的描述信息

    public ExceptionInfo() {
    }

    public ExceptionInfo(String retCd, String msgDes) {
        this.retCd = retCd;
        this.msgDes = msgDes;
    }

    public String getRetCd() {
        return retCd;
    }

    public void setRetCd(String retCd) {
        this.retCd = retCd;
    }

    public String getMsgDes() {
        return msgDes;
    }

    public void setMsgDes(String msgDes) {
        this.msgDes = msgDes;
    }
}
