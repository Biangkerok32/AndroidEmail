package com.hong.email;


import java.util.concurrent.TimeUnit;

public class EmailAccount {
    /**
     * 发送邮件的地址
     */
    private String from;

    /**
     * 发送邮箱的密码
     */
    private String password;



    /**
     * 发送邮件的服务器类型
     */
    private String protocol="smtp";

    /**
     * 发送邮件的服务器地址
     */
    private String host="smtp.126.com";

    /**
     * 发送邮件服务器的端口
     */
    private String port="25";

    /**
     * 连接超时
     */
    private String connectTimeOut="6000";

    /**
     * 超时时间
     */
    private String timeout="1000";

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getConnectTimeOut() {
        return connectTimeOut;
    }

    public void setConnectTimeOut(String connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
    }

    /**
     * 初始化126邮箱参数
     * @param uerName 用户名
     * @param password 密码
     * @return
     */
    public static EmailAccount getEmail126(String uerName,String password,String timeout){
        EmailAccount emailAccount=new EmailAccount();
        emailAccount.setFrom(uerName);
        emailAccount.setPassword(password);
        emailAccount.setHost("smtp.126.com");
        emailAccount.setPort("25");
        emailAccount.setTimeout(timeout);
        return emailAccount;
    }

    /**
     * 初始化qq邮箱
     * @param uerName
     * @param password
     * @param timeoutMilli 毫秒
     * @return
     */
    public static EmailAccount getEmailQQ(String uerName,String password,String timeoutMilli){
        EmailAccount emailAccount=new EmailAccount();
        emailAccount.setFrom(uerName);
        emailAccount.setPassword(password);
        emailAccount.setHost("smtp.qq.com");
        emailAccount.setPort("465");
        emailAccount.setTimeout(timeoutMilli);
        return emailAccount;
    }

}
