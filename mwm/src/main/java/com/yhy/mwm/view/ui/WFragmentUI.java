package com.yhy.mwm.view.ui;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

/**
 * Created by 颜洪毅 on 2017/8/15 11:12.
 */
public interface WFragmentUI<B extends ViewDataBinding> extends WUI<B> {

    /**
     * Fragment返回事件
     */
    void back();

    /**
     * 获取Fragment页面之间传递的参数
     *
     * @return
     */
    Bundle args();

    /**
     * 获取FragmentManager对象
     *
     * @return FragmentManager
     */
    FragmentManager getFragmentManager();

    /**
     * 获取子Fragment的FragmentManager对象，Fragment嵌套时只能用此方法
     *
     * @return FragmentManager
     */
    FragmentManager getChildFragmentManager();
}