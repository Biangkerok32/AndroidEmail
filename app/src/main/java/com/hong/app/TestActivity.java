package com.hong.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hong.email.EmailAccount;
import com.hong.email.EmailListener;
import com.hong.email.EmailMessage;
import com.hong.email.EmailUtil;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
    private String tag = "邮件";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        new Thread(() -> {
//        EmailAccount account = new EmailAccount();
//        account.setFrom("support@szykzh.com");
//        account.setHost("smtp.exmail.qq.com");
//        account.setPort("465");
//        account.setPassword("nXo5N6go4wBVQ7QZ");
//        account.setSsl(true);
//        account.setTimeout("60000");
            Log.e("dddddd", Long.toString(6000));
            EmailAccount account = EmailAccount.getEmailQQCompany("support@szykzh.com", "nXo5N6go4wBVQ7QZ", 6000L);



            ArrayList<String> toAddress = new ArrayList<>();
            toAddress.add("827071810@qq.com");

            ArrayList<String> copyAddress = new ArrayList<>();

            EmailMessage emailMessage = new EmailMessage();
            emailMessage.setContent("12244");
            emailMessage.setTitle("赫尔达到");


            EmailUtil emailUtil = new EmailUtil(account);
            emailUtil.setToAddress(toAddress);
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
        }).start();
    }
}