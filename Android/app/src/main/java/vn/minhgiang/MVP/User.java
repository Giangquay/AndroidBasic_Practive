package vn.minhgiang.MVP;

import android.text.TextUtils;
import android.util.Patterns;


public class User {
    String Email,Pass;

    public User(String email, String pass) {
        Email = email;
        Pass = pass;
    }
    public User(){}

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
    public boolean isValidEmail()
    {
        //dung lop TextUtils
        return !TextUtils.isEmpty(Email) && Patterns.EMAIL_ADDRESS.matcher(Email).matches();
    }
    public boolean isValidPass()
    {
        //dung lop TextUtils
        return !TextUtils.isEmpty(Pass)&&Pass.length()>6;
    }
}
