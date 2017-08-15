package com.yhy.mwmapp.view.view;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yhy.mwm.view.view.WActivity;
import com.yhy.mwmapp.MainBinding;
import com.yhy.mwmapp.R;
import com.yhy.mwmapp.view.ui.MainUI;
import com.yhy.mwmapp.vm.MainVM;

public class MainActivity extends WActivity<MainBinding, MainUI, MainVM> implements MainUI {

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        //一些初始化操作，在父类的onCreate()方法中调用
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainVM create(@Nullable Bundle savedInstanceState) {
        return new MainVM(this);
    }
}
