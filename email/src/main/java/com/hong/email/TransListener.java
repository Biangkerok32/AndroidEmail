package com.hong.email;
import android.util.Log;

import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;

public class TransListener implements TransportListener {

    private EmailListener mEmailListener;

    public TransListener(EmailListener emailListener){
        this.mEmailListener=emailListener;
    }
    private String TAG = "TransListener";
    @Override
    public void messageDelivered(TransportEvent e) {
        Log.i(TAG,"邮件发送成功");
        if(mEmailListener!=null)mEmailListener.onSuccess();
    }

    @Override
    public void messageNotDelivered(TransportEvent e) {
        Log.i(TAG,"邮件发送失败:"+e.getMessage().toString());
        if(mEmailListener!=null)mEmailListener.onFail(e.getType(),e.getMessage().toString());
    }

    @Override
    public void messagePartiallyDelivered(TransportEvent e) {
        if(mEmailListener!=null)mEmailListener.onPartSuccess();
        Log.i(TAG,"邮件部分发送成功:"+e.getMessage().toString());
    }


}
