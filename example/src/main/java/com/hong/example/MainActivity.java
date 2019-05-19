package com.hong.example;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hong.email.Email;
import com.hong.email.EmailAccount;
import com.hong.email.EmailListener;
import com.hong.email.EmailMessage;
import com.hong.email.TransListener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity implements EmailListener {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyStoragePermissions(this);
    }

    public void sendEmai(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {


                EmailAccount account = EmailAccount.getEmail126("my11712@126.com", "h123456", "3000");// nxbcddiylkgkbibd       eebhwgwxyfrucabe  ypzjfalhwctnbijh
//                EmailAccount account = EmailAccount.getEmailQQ("494917413@qq.com", "eebhwgwxyfrucabe", "3000");

                //邮件接受者
                    List<String> addressList=new ArrayList<>();
                    addressList.add("827071810@qq.com");

                    //抄送给哪些
                    List<String> ccList=new ArrayList<>();
//                    ccList.add("my11712@126.com");

                    File file1=new File("/sdcard/DCIM/Camera/IMG_20190112_134338.jpg");
                    File file2=new File("/sdcard/DCIM/Camera/IMG_20181021_165650.jpg");
                    File[] files={file1,file2};
                    EmailMessage emailMessage=new EmailMessage();
                    emailMessage.setContent("测试内容222");
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
                    emailMessage.setTitle("标题"+simpleDateFormat.format(new Date()));
//                    emailMessage.setFiles(files);

                Email.getInstance().sendEmail(account, addressList, ccList, emailMessage,MainActivity.this);

            }
        }).start();

    }

    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFail(int code,String message) {

    }

    @Override
    public void onPartSuccess() {

    }
}
