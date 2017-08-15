package com.yhy.mwm.view.view;

import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yhy.mwm.view.ui.WUI;
import com.yhy.mwm.vm.WVM;

/**
 * Created by 颜洪毅 on 2017/8/15 11:06.
 */
public abstract class WActivity<B extends ViewDataBinding, U extends WUI, VM extends WVM<U>> extends AppCompatActivity implements WUI<B> {
    protected B mBinding;
    protected VM mVm;

    /**
     * 获取布局资源id
     *
     * @return 布局资源id
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 创建ViewModel
     *
     * @param savedInstanceState Activity中保存的状态
     * @return ViewModel
     */
    protected abstract VM create(@Nullable Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //强制使用竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //创建ViewDataBinding
        int layoutId = getLayoutId();
        if (layoutId <= 0) {
            return;
        }
        //绑定视图
        mBinding = DataBindingUtil.setContentView(this, layoutId);

        //创建ViewModel
        mVm = create(savedInstanceState);
        if (null == mVm) {
            return;
        }

        //初始化
        init(savedInstanceState);

        //子类初始化数据
        initData(savedInstanceState);

        //子类初始化事件
        initListener();
    }

    /**
     * 初始化，子类重写来实现原本在onCreate()方法中实现的逻辑
     *
     * @param savedInstanceState Activity中保存的状态
     */
    protected void init(@Nullable Bundle savedInstanceState) {
    }

    /**
     * 初始化数据
     *
     * @param savedInstanceState Activity中保存的状态
     */
    protected void initData(@Nullable Bundle savedInstanceState) {
        if (null != mVm) {
            mVm.initData(savedInstanceState);
        }
    }

    /**
     * 初始化事件
     */
    protected void initListener() {
        if (null != mVm) {
            mVm.initListener();
        }
    }

    /**
     * 获取当前Activity对象
     *
     * @return Activity
     */
    @Override
    public AppCompatActivity activity() {
        return this;
    }

    /**
     * 获取到当前的ViewDataBinding对象
     *
     * @return ViewDataBinding
     */
    @Override
    public B binding() {
        return mBinding;
    }

    /**
     * Activity销毁时，销毁UI对象
     */
    @Override
    protected void onDestroy() {
        //取消View的关联
        if (null != mVm) {
            mVm.detachUI();
        }

        super.onDestroy();
    }
}
