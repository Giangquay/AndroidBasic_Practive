package vn.minhgiang.MVP;

import vn.minhgiang.list.R;

public class LoginPresenter {
    LoginInterface mloginInterface;

    public LoginPresenter(LoginInterface mloginInterface) {
        this.mloginInterface = mloginInterface;
    }

    public void login(User user)
    {
        if (user.isValidEmail()&&user.isValidPass())
        {
            mloginInterface.loginSuccess();
        }else
        {
            mloginInterface.loginError();
        }
    }
}
