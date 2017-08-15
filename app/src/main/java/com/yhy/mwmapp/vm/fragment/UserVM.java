package com.yhy.mwmapp.view.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yhy.mwm.view.ui.WUI;
import com.yhy.mwm.vm.WVM;

/**
 * Created by 颜洪毅 on 2017/8/15 15:32.
 */
public class UserVM extends WVM<WUI> {

    /**
     * 构造函数
     *
     * @param ui 需要关联的View
     */
    public UserVM(WUI ui) {
        super(ui);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
    }

    @Override
    public void initListener() {
    }
}
