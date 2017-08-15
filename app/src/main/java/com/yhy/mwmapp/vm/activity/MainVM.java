package com.yhy.mwmapp.vm;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yhy.mwm.model.WModel;
import com.yhy.mwm.vm.WVM;
import com.yhy.mwmapp.model.UserModel;
import com.yhy.mwmapp.model.impl.UserModelImpl;
import com.yhy.mwmapp.view.ui.MainUI;

import java.util.Random;

/**
 * Created by 颜洪毅 on 2017/8/15 14:43.
 */
public class MainVM extends WVM<MainUI> {
    public final ObservableField<String> mName;
    private final UserModel mUserModel;

    private Random mRand;
    private boolean mIsReq;

    /**
     * 构造函数
     *
     * @param ui 需要关联的View
     */
    public MainVM(MainUI ui) {
        super(ui);

        mName = new ObservableField<>();
        mUserModel = new UserModelImpl();
        mRand = new Random();

        getUI().binding().setMainVM(this);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mName.set("Hello MWMApp");
    }

    @Override
    public void initListener() {
    }

    public void test(View view) {
        if (mIsReq) {
            return;
        }

        mIsReq = true;
        mName.set("正在请求数据...");

        mUserModel.loadName(mRand.nextInt(1000) + 1, new WModel.OnStringResultListener() {
            @Override
            public void onResult(String result, String msg) {
                mName.set(result);
                mIsReq = false;
            }
        });
    }
}
