### Setup
Download
```groovy

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 
implementation 'com.github.my11712:AndroidEmail:1.0.3'
```
### MARK
目前版本 126邮箱是使用密码登录，QQ邮箱是使用授权码登录
### 发送邮件
#### 1、设置邮箱账户
```
EmailAccount account = new EmailAccount.Build()
                .setAccountType(EmailAccount.TYPE_QQ)
                .setUserName("827071810@qq.com")
                .setPassword("XXXXX")
                .setTimeOut(6000)
                .build();   
```
####  2、设置接收邮件地址
``` 
List<String> addressList = new ArrayList<>();
addressList.add("my11712@126.com");
```
####  3、设置抄送
```
 //抄送给自己
List<String> ccList = new ArrayList<>();
ccList.add("827071810@qq.com");
```
####  4、设置邮件内容
```
EmailMessage emailMessage = new EmailMessage();
//邮件标题
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss", Locale.getDefault());
emailMessage.setTitle("112323标题" + simpleDateFormat.format(new Date()));
//邮件内容
emailMessage.setContent("测试内容22211111111111111");
```
#### 5、发送
```
EmailUtil emailUtil = new EmailUtil(account);
	    //收件人
            emailUtil.setToAddress(toAddress);
	    //抄送者
            emailUtil.setCopyToAddress(copyAddress);
            emailUtil.sendEmail(emailMessage, new EmailListener() {

                @Override
                public void onSuccess() {
                    Log.e(tag, "发送成功");
                }

                @Override
                public void onFail(int type, String message) {
                    Log.e(tag, "发送失败" + message);
                }

            });  
```
