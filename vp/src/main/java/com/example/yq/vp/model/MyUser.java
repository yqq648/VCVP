package com.example.yq.vp.model;

import android.text.TextUtils;

/**
 * Created by yq on 2017/2/21.
 */

public class MyUser implements IUser{
    public boolean checkUserPwd(String u,String p){
        if (TextUtils.isEmpty(u)||TextUtils.isEmpty(p)){
            return false;
        }
        return true;
    }
}
