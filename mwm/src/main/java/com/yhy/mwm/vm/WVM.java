package com.yhy.mwm.vm;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yhy.mwm.view.ui.WUI;

import java.lang.ref.WeakReference;

/**
 * Created by 颜洪毅 on 2017/8/15 11:03.
 */
public abstract class WVM<U extends WUI> {
    //View的弱引用
    private WeakReference<U> mUIRef;

    /**
     * 构造函数
     *
     * @param ui 需要关联的View
     */
    public WVM(U ui) {
        //关联View
        attachUI(ui);
    }

    /**
     * 关联View
     *
     * @param ui 需要关联的View
     */
    public void attachUI(U ui) {
        mUIRef = new WeakReference<>(ui);
    }

    /**
     * 初始化数据
     *
     * @param savedInstanceState 页面保存的状态
     */
    public abstract void initData(@Nullable Bundle savedInstanceState);

    /**
     * 初始化事件
     */
    public abstract void initListener();

    /**
     * 页面销毁
     */
    public void onDestroy() {
    }

    /**
     * 取消关联的View
     */
    public void detachUI() {
        if (null != mUIRef) {
            mUIRef.clear();
        }
    }

    /**
     * 获取将当前关联的View
     *
     * @return 当前关联的View
     */
    public U getUI() {
        if (null != mUIRef) {
            return mUIRef.get();
        }
        return null;
    }
}