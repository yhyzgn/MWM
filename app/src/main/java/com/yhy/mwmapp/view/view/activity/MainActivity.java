package com.yhy.mwmapp.view.view.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;

import com.yhy.mwm.view.view.WActivity;
import com.yhy.mwmapp.MainBinding;
import com.yhy.mwmapp.R;
import com.yhy.mwmapp.view.ui.activity.MainUI;
import com.yhy.mwmapp.vm.activity.MainVM;

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

    @Override
    public void open(int flag) {
        Intent intent = new Intent(this, FmActivity.class);
        intent.putExtra("fm_flag", flag);
        startActivity(intent);
    }
}
