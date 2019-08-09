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

### 发送邮件
#### 1、设置邮箱账户
   EmailAccount account = new EmailAccount.Build()
                .setAccountType(EmailAccount.TYPE_QQ)
                .setUserName("827071810@qq.com")
                .setPassword("xnjdcbtuakqwbegb")
                .setTimeOut(6000)
                .build();
#### 2、设置接收邮件地址
  List<String> addressList = new ArrayList<>();
        addressList.add("my11712@126.com");
####  3、设置抄送
 //抄送给自己
        List<String> ccList = new ArrayList<>();
        ccList.add("827071810@qq.com");
####  4、设置邮件内容
  EmailMessage emailMessage = new EmailMessage();
        //邮件标题
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss", Locale.getDefault());
        emailMessage.setTitle("112323标题" + simpleDateFormat.format(new Date()));
        //邮件内容
        emailMessage.setContent("测试内容22211111111111111");

#### 5、发送

       Email.getInstance().setAccount(account);
             Email.getInstance().setToAddress(addressList);
             Email.getInstance().setCopyToAddress(ccList);
     
             Email.getInstance().sendEmailAsync(emailMessage, MainActivity.this);          