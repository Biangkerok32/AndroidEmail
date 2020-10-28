package com.hong.email;

public interface EmailListener {
      void onSuccess();
      void onFail(int type,String message);

}
