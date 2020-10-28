package com.hong.email;

/**
 * Copyright (C)深圳市云客智慧科技有限公司
 * Author: 洪奇志
 * Date: 2020/10/28 18:27
 * Description:
 */
class ErrorCode {

    //收件人为空
    public static final int ERROR_PART = 99;
    public static final String ERROR_PART_MSG = "邮件部分发送成功";
    //收件人为空
    public static final int ERROR_Receive_EMPTY = 100;
    public static final String ERROR_RECEIVE_EMPTY_MSG = "收件人为空";

    //主线程发送
    public static final int ERROR_MAIN_THREAD = 101;
    public static final String ERROR_MAIN_THREAD_MSG = "主线程发送网络请求";


}
