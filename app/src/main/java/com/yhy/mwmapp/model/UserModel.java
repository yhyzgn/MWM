package com.yhy.mwmapp.model;

import com.yhy.mwm.model.WModel;

/**
 * Created by 颜洪毅 on 2017/8/15 14:52.
 */
public interface UserModel extends WModel {

    void loadName(int arg, OnStringResultListener listener);
}
