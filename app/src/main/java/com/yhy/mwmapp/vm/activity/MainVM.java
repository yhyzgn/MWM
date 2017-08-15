package com.yhy.mwmapp.vm.activity;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yhy.mwm.vm.WVM;
import com.yhy.mwmapp.global.Const;
import com.yhy.mwmapp.view.ui.activity.MainUI;

/**
 * Created by 颜洪毅 on 2017/8/15 14:43.
 */
public class MainVM extends WVM<MainUI> {
    public final ObservableField<String> mName;

    /**
     * 构造函数
     *
     * @param ui 需要关联的View
     */
    public MainVM(MainUI ui) {
        super(ui);

        mName = new ObservableField<>();

        getUI().binding().setMainVM(this);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mName.set("跳转Fragment");
    }

    @Override
    public void initListener() {
    }

    public void test(View view) {
        getUI().open(Const.FM_USER);
    }
}
