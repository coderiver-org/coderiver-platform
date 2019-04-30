package com.coderiver.codeforum.common.entity;

/**
 * Created by Shiyu Rao on 2019/1/2.
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

    public static final int ID_NOT_EXIST = 30100; // id不存在
    public static final int PARAMS_ERROR = 30101; // 参数错误
    public static final int CATEGORY_NAME_EMPTY = 30110; //项目类型名称为空
    public static final int ERROR_SAVE_PROJECT_CATEGORY = 30200; //保存项目类型失败
    public static final int ERROR_UPDATE_PROJECT_CATEGORY = 30210; //更新项目类型失败
    public static final int ERROR_DELETE_PROJECT_CATEGORY = 30220; //更新项目类型失败
    public static final int ERROR_SAVE_PROJECT_INFO = 30300; //保存项目失败
    public static final int ERROR_UPDATE_PROJECT_INFO = 30310; //保存项目失败
    public static final int ERROR_DELETE_PROJECT_INFO = 30320; //删除项目失败


    //TODO 添加状态码 要求统一
}
