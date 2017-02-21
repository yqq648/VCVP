package com.example.yq.vp.presenter;

import com.example.yq.vp.model.MyUser;
import com.example.yq.vp.view.ILoginView;

/**
 * Created by yq on 2017/2/21.
 */
//控制数据 调用更改view
public class LoginPresenter implements IPresenter {
    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void clear() {
        loginView.onClearText();
    }

    @Override
    public void doLogin(String u, String p) {
        MyUser user = new MyUser();
        if (user.checkUserPwd(u,p)){
            loginView.onLoginResult();
        }
    }


}
