package com.coderiver.common.entity;

/**
 * Created by Ultratendency on 2019/1/2.
 * 统一管理状态码
 */
public class StatusCode {
    public static final int OK = 20000; // 成功
    public static final int ERROR = 20100; // 失败
    public static final int CUSTOMER_ERROR = 20110; // 失败
    public static final int LOGINERROR = 20200; //用户名或者密码错误
    public static final int ACCESSERROR = 20300; // 权限不足
    public static final int REMOTEERROR = 20400; // 远程调用失败
    public static final int REPERROR = 20500; // 重复操作

    //TODO 添加状态码 要求统一
}
