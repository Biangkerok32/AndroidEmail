package com.hong.email;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;

public class TransListener implements TransportListener {

    private final EmailListener mEmailListener;
    private Handler mainHandler;

    public TransListener(EmailListener emailListener) {
        this.mEmailListener = emailListener;
        mainHandler = new Handler(Looper.getMainLooper());
    }

    private final String TAG = "TransListener";

    @Override
    public void messageDelivered(TransportEvent e) {
        Log.i(TAG, "邮件发送成功");
        mainHandler.post(() -> {
            //已在主线程中，可以更新UI
            if (mEmailListener != null) mEmailListener.onSuccess();
            destroy();
        });

    }

    @Override
    public void messageNotDelivered(final TransportEvent e) {
        Log.i(TAG, "邮件发送失败:" + e.getMessage().toString());
        mainHandler.post(() -> {
            if (mEmailListener != null)
                mEmailListener.onFail(e.getType(), e.getMessage().toString());
            destroy();
        });

    }

    @Override
    public void messagePartiallyDelivered(TransportEvent e) {
        Log.i(TAG, "邮件部分发送成功:" + e.getMessage().toString());
        mainHandler.post(() -> {
            if (mEmailListener != null) mEmailListener.onFail(ErrorCode.ERROR_PART,ErrorCode.ERROR_PART_MSG);
            destroy();
        });

    }

    private void destroy() {
        mainHandler.removeCallbacks(null);
        mainHandler = null;
    }
}
