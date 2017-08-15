package com.yhy.mwm.view.ui;

import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 颜洪毅 on 2017/8/15 11:03.
 */
public interface WUI<B extends ViewDataBinding> {

    /**
     * 获取当前Activity
     *
     * @return Activity
     */
    AppCompatActivity activity();

    /**
     * 获取当前ViewDataBinding对象
     *
     * @return ViewDataBinding
     */
    B binding();
}
