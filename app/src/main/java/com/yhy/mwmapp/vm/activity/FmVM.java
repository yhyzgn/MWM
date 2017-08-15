package com.yhy.mwmapp.vm;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yhy.mwm.vm.WVM;
import com.yhy.mwmapp.view.ui.FmUI;

/**
 * Created by 颜洪毅 on 2017/8/15 15:12.
 */
public class FmVM extends WVM<FmUI> {

    /**
     * 构造函数
     *
     * @param ui 需要关联的View
     */
    public FmVM(FmUI ui) {
        super(ui);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
    }

    @Override
    public void initListener() {
    }
}
