package com.yhy.mwmapp.view.view.fragment;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yhy.mwm.view.view.WFragment;
import com.yhy.mwmapp.R;
import com.yhy.mwmapp.UserBinding;
import com.yhy.mwmapp.view.ui.fragment.UserUI;
import com.yhy.mwmapp.vm.fragment.UserVM;

/**
 * Created by 颜洪毅 on 2017/8/15 15:56.
 */
public class UserFragment extends WFragment<UserBinding, UserUI, UserVM> implements UserUI {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    protected UserVM create(LayoutInflater inflater, @Nullable ViewGroup container) {
        return new UserVM(this);
    }
}
