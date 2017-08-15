package com.yhy.mwmapp.view.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.yhy.fmhelper.FmHelper;
import com.yhy.mwm.view.view.WActivity;
import com.yhy.mwmapp.FmBinding;
import com.yhy.mwmapp.R;
import com.yhy.mwmapp.view.ui.activity.FmUI;
import com.yhy.mwmapp.view.view.fragment.UserFragment;
import com.yhy.mwmapp.vm.activity.FmVM;

/**
 * Created by 颜洪毅 on 2017/8/15 15:14.
 */
public class FmActivity extends WActivity<FmBinding, FmUI, FmVM> implements FmUI {

    private FmHelper mHelper;
    private Bundle mArgs;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fm;
    }

    @Override
    protected FmVM create(@Nullable Bundle savedInstanceState) {
        return new FmVM(this);
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        mHelper = new FmHelper.Builder(this, R.id.fl_fm_container).build();
        //显示Fragment
        display();
    }

    private void display() {
        int flag = getIntent().getIntExtra("fm_flag", 0);
        if (flag == 1000) {
            UserFragment fm = new UserFragment();
            Bundle arg = new Bundle();
            arg.putString("user_arg", "Hello MWMApp");
            fm.setArguments(arg);
            //打开Fragment页面
            open(fm);
        }
    }

    public void open(Fragment fm) {
        mHelper.open(fm);
    }

    public void back() {
        mHelper.back();
    }

    @Override
    public void onBackPressed() {
        back();
    }
}
