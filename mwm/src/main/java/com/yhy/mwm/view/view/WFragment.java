package com.yhy.mwm.view.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yhy.mwm.view.ui.WFragmentUI;
import com.yhy.mwm.vm.WVM;

/**
 * Created by 颜洪毅 on 2017/8/15 11:11.
 */
public abstract class WFragment<B extends ViewDataBinding, U extends WFragmentUI, VM extends WVM<U>> extends Fragment implements WFragmentUI<B> {
    protected B mBinding;
    protected VM mVm;
    public AppCompatActivity mActivity;

    /**
     * Fragment创建时调用
     *
     * @param savedInstanceState Fragment保存的状态
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //获取当前Activity对象
        if (null == mActivity) {
            mActivity = (AppCompatActivity) getActivity();
        }

        //初始化
        init(savedInstanceState);
    }

    /**
     * 依附到Activity上时调用
     *
     * @param context 上下文对象
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //再次尝试获取Activity对象
        if (null == mActivity) {
            mActivity = (AppCompatActivity) context;
        }
    }

    /**
     * 初始化，子类重写来实现原本在onCreate()方法中实现的逻辑
     *
     * @param savedInstanceState Fragment保存的状态
     */
    protected void init(@Nullable Bundle savedInstanceState) {
    }

    /**
     * 创建Fragment的View时调用
     *
     * @param inflater           布局映射器
     * @param container          布局容器
     * @param savedInstanceState Fragment保存的状态
     * @return 显示在Fragment中的View
     */
    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //创建ViewDataBinding
        int layoutId = getLayoutId();
        if (layoutId <= 0) {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
        mBinding = DataBindingUtil.inflate(inflater, layoutId, container, false);

        //创建ViewModel对象
        mVm = create(inflater, container);
        if (null == mVm) {
            return super.onCreateView(inflater, container, savedInstanceState);
        }

        return mBinding.getRoot();
    }

    /**
     * Activity创建时调用
     *
     * @param savedInstanceState Fragment中保存的状态
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (null == mVm) {
            return;
        }

        //初始化数据
        initData(savedInstanceState);

        //初始化事件
        initListener();
    }

    /**
     * 获取布局资源id
     *
     * @return 布局资源id
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 创建ViewModel
     * 在父类onCreateView方法中调用
     *
     * @param inflater  布局映射解析器
     * @param container 布局容器
     * @return ViewModel
     */
    protected abstract VM create(LayoutInflater inflater, @Nullable ViewGroup container);

    /**
     * 初始化数据
     *
     * @param savedInstanceState Fragment中保存的状态
     */
    public void initData(@Nullable Bundle savedInstanceState) {
        if (null != mVm) {
            mVm.initData(savedInstanceState);
        }
    }

    /**
     * 初始化事件
     */
    public void initListener() {
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
        return mActivity;
    }

    /**
     * 获取当前ViewDataBinding对象
     *
     * @return ViewDataBinding
     */
    @Override
    public B binding() {
        return mBinding;
    }

    /**
     * Fragment的返回事件
     * 这里直接调用了Activity的返回事件，也可重写自定义
     */
    @Override
    public void back() {
        if (null != mActivity) {
            mActivity.onBackPressed();
        }
    }

    /**
     * 获取Fragment的页面之间参数
     *
     * @return 页面跳转传递的参数
     */
    @Override
    public Bundle args() {
        return getArguments();
    }

    /**
     * Fragment销毁时，也销毁UI对象
     */
    @Override
    public void onDestroy() {
        //取消View的关联
        if (null != mVm) {
            mVm.detachUI();
        }
        super.onDestroy();
    }
}
