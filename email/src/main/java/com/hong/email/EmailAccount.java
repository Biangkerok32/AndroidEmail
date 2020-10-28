package com.hong.email;


public class EmailAccount {

    public static final int TYPE_QQ = 0;

    public static final int TYPE_126 = 1;
    /**
     * qq企业邮箱
     */
    public static final int TYPE_QQ_COMPANY = 2;

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
    private String protocol = "smtp";

    /**
     * 发送邮件的服务器地址
     */
    private String host = "smtp.126.com";

    /**
     * 发送邮件服务器的端口
     */
    private String port = "25";

    /**
     * 连接超时
     */
    private String connectTimeOut = "6000";

    /**
     * 超时时间
     */
    private String timeout = "1000";

    /**
     * QQ邮箱需要开启ssl，126不需要
     */
    private boolean ssl;

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

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    /**
     * 初始化126邮箱参数
     *
     * @param uerName  用户名
     * @param password 密码
     * @return
     */
    public static EmailAccount getEmail126(String uerName, String password, String timeout) {
        EmailAccount emailAccount = new EmailAccount();
        emailAccount.setFrom(uerName);
        emailAccount.setPassword(password);
        emailAccount.setHost("smtp.126.com");
        emailAccount.setPort("25");
        emailAccount.setTimeout(timeout);
        return emailAccount;
    }



    /**
     * 初始化qq邮箱
     *
     * @param uerName
     * @param password
     * @param timeoutMilli 毫秒
     * @return
     */
    public static EmailAccount getEmailQQ(String uerName, String password, String timeoutMilli) {
        EmailAccount emailAccount = new EmailAccount();
        emailAccount.setFrom(uerName);
        emailAccount.setPassword(password);
        emailAccount.setHost("smtp.qq.com");
        emailAccount.setPort("465");
        emailAccount.setSsl(true);
        emailAccount.setTimeout(timeoutMilli);
        return emailAccount;
    }

    /**
     * 初始化qq企业邮箱
     *
     * @param uerName
     * @param password
     * @param timeoutMilli 毫秒
     * @return
     */
    public static EmailAccount getEmailQQCompany(String uerName, String password, Long timeoutMilli) {
        EmailAccount emailAccount = new EmailAccount();
        emailAccount.setFrom(uerName);
        emailAccount.setPassword(password);
        emailAccount.setHost("smtp.exmail.qq.com");
        emailAccount.setPort("465");
        emailAccount.setSsl(true);
        emailAccount.setTimeout(Long.toString(timeoutMilli));
        return emailAccount;
    }

    public static class Build {
        EmailAccount emailAccount;
        private int accountType;

        public Build() {
            emailAccount = new EmailAccount();
        }

        public Build setAccountType(int type) {
            accountType = type;
            return this;
        }

        public Build setUserName(String userName) {
            emailAccount.setFrom(userName);
            return this;
        }

        public Build setPassword(String password) {
            emailAccount.setPassword(password);
            return this;
        }

        public Build setTimeOut(long timeOut) {
            emailAccount.setTimeout(String.valueOf(timeOut));
            return this;
        }

        public EmailAccount build() {
            if (accountType == TYPE_QQ) {
                //qq邮箱
                emailAccount.setHost("smtp.qq.com");
                emailAccount.setPort("465");
                emailAccount.setSsl(true);
            } else if (accountType == TYPE_126) {
                //网易126
                emailAccount.setHost("smtp.126.com");
                emailAccount.setPort("25");
                emailAccount.setSsl(false);
            }else if (accountType==TYPE_QQ_COMPANY){
                //qq企业邮箱
                emailAccount.setHost("smtp.exmail.qq.com");
                emailAccount.setPort("465");
                emailAccount.setSsl(true);
            }
            return emailAccount;
        }
    }
}
