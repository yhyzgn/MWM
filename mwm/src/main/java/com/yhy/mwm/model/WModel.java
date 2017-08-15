package com.yhy.mwm.model;

/**
 * Created by 颜洪毅 on 2017/8/15 11:02.
 */
public interface WModel {

    //在此提供几个结果响应的监听器，实也可以定义自己的监听器

    /**
     * 响应整形结果的监听器
     */
    interface OnIntResultListener {
        void onResult(int result, String msg);
    }

    /**
     * 响应字符串结果的监听器
     */
    interface OnStringResultListener {
        void onResult(String result, String msg);
    }

    /**
     * 响应布尔值结果的监听器
     */
    interface OnBoolResultListener {
        void onResult(boolean result, String msg);
    }

    /**
     * 响应对象结果的监听器
     */
    interface OnObjectResultListener {
        void onResult(Object result, String msg);
    }
}
