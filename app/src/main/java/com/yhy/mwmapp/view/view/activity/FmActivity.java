package com.yhy.mwmapp.view.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.yhy.fmhelper.FmHelper;
import com.yhy.mwm.view.view.WActivity;
import com.yhy.mwmapp.FmBinding;
import com.yhy.mwmapp.R;
import com.yhy.mwmapp.view.ui.FmUI;
import com.yhy.mwmapp.vm.FmVM;

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
        mArgs = new Bundle();
    }

    public void open(Fragment fm) {
        //将参数从Activity中获取到，并传递给要展示的Fragment
        if (null != mArgs) {
            fm.getArguments().putAll(mArgs);
        }
        mHelper.open(fm);
    }
}
