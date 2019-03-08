package com.coderiver.codeforum.user.pojo;

/**
 * Created by Shiyu Rao on 08/03/2019.
 */
public class ConstantPool {

    public static final int USER_STATUS_UNACTIVATE = 1; // 用户未激活
    public static final int USER_STATUS_ACTIVATE = 2; // 用户已激活


    public static final int USER_REGISTER_TYPE_EMAIL = 1; // 激活方式 发邮件
    public static final String USER_REGISTER_TYPE_EMAIL_EXCHANGE = "emailexchange";
    public static final String USER_REGISTER_TYPE_EMAIL_TOPIC = "user.email.register";

    public static final int USER_REGISTER_TYPE_SMS = 2; // 激活方式 发短信
    public static final String USER_REGISTER_TYPE_SMS_EXCHANGE = "smsexchange";
    public static final String USER_REGISTER_TYPE_SMS_TOPIC = "user.sms.register";


}
