package com.yhy.mwmapp.model.impl;

import android.os.SystemClock;

import com.yhy.mwmapp.model.UserModel;

/**
 * Created by 颜洪毅 on 2017/8/15 14:53.
 */
public class UserModelImpl implements UserModel {

    @Override
    public void loadName(final int arg, final OnStringResultListener listener) {
        //模拟数据加载延迟
        new Thread() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                //通过回调响应结果
                String url = "用户 " + arg;
                listener.onResult(url, "加载成功");
            }
        }.start();
    }
}
