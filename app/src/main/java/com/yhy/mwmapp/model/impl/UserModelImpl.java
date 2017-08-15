package com.yhy.mwmapp.model.impl;

import android.os.SystemClock;

import com.yhy.mwm.model.WModel;
import com.yhy.mwmapp.model.MainModel;

/**
 * Created by 颜洪毅 on 2017/8/15 14:53.
 */
public class MainModelImpl implements MainModel {

    @Override
    public void loadUrl(final int arg, final OnStringResultListener listener) {
        new Thread() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                //通过回调响应结果
                String url = "http://xxx.xxx.com?id=" + arg;
                listener.onResult(url, "加载成功");
            }
        }.start();
    }
}
