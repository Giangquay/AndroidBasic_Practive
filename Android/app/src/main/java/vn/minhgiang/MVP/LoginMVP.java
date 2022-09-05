package vn.minhgiang.MVP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vn.minhgiang.list.R;

public class LoginMVP extends AppCompatActivity implements LoginInterface{
    EditText edtEmailMVP,edtPassMVP;
    TextView txtResultLoginMVP;
    Button btnLoginMVP;
    LoginPresenter mloginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mvp);
        edtEmailMVP=findViewById(R.id.edtEmailMVP);
        edtPassMVP=findViewById(R.id.edtPassMVP);
        txtResultLoginMVP=findViewById(R.id.txt_resultMVP);
        btnLoginMVP=findViewById(R.id.btnLoginMVP);
        mloginPresenter = new LoginPresenter(this);
        btnLoginMVP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendlogin();
            }
        });
    }

    private void sendlogin() {
        String email=edtEmailMVP.getText().toString().trim();
        String pass =edtPassMVP.getText().toString().trim();
        User user = new User(email,pass);
        mloginPresenter.login(user);
    }

    @Override
    public void loginSuccess() {
        txtResultLoginMVP.setVisibility(View.VISIBLE);
        txtResultLoginMVP.setText("Login Success");
        txtResultLoginMVP.setTextColor(getResources().getColor(R.color.teal_200));
    }

    @Override
    public void loginError() {
        txtResultLoginMVP.setVisibility(View.VISIBLE);
        txtResultLoginMVP.setText("Email an Pass invalid");
        txtResultLoginMVP.setTextColor(getResources().getColor(R.color.red));
    }
}