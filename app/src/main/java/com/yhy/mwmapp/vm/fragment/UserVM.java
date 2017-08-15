package com.yhy.mwmapp.vm.fragment;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yhy.mwm.model.WModel;
import com.yhy.mwm.view.ui.WUI;
import com.yhy.mwm.vm.WVM;
import com.yhy.mwmapp.model.UserModel;
import com.yhy.mwmapp.model.impl.UserModelImpl;
import com.yhy.mwmapp.view.ui.fragment.UserUI;

import java.util.Random;

/**
 * Created by 颜洪毅 on 2017/8/15 15:32.
 */
public class UserVM extends WVM<UserUI> {

    public final ObservableField<String> mName;
    private final UserModel mUserModel;

    private Random mRand;
    private boolean mIsReq;

    /**
     * 构造函数
     *
     * @param ui 需要关联的View
     */
    public UserVM(UserUI ui) {
        super(ui);

        mName = new ObservableField<>();
        mUserModel = new UserModelImpl();
        mRand = new Random();

        getUI().binding().setUserVM(this);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mName.set(getUI().args().getString("user_arg"));
    }

    @Override
    public void initListener() {
        getUI().binding().tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUI().back();
            }
        });
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
