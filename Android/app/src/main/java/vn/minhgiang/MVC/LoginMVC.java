package vn.minhgiang.MVC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vn.minhgiang.MVP.User;
import vn.minhgiang.list.R;

public class LoginMVC extends AppCompatActivity {
    EditText edtEmail,edtPass;
    TextView txtResultLogin;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mvc);
        edtEmail=findViewById(R.id.edtEmail);
        edtPass=findViewById(R.id.edtPass);
        txtResultLogin=findViewById(R.id.txt_result);
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLogin();
            }
        });
    }

    private void clickLogin() {
        String email=edtEmail.getText().toString().trim();
        String pass =edtPass.getText().toString().trim();
        User user = new User(email,pass);
        txtResultLogin.setVisibility(View.VISIBLE);
        if (user.isValidEmail()&&user.isValidPass())
        {
            txtResultLogin.setText("Login Success");
            txtResultLogin.setTextColor(getResources().getColor(R.color.teal_200));
        }else if (!user.isValidPass())
        {
            txtResultLogin.setText("Pass invalid");
            txtResultLogin.setTextColor(getResources().getColor(R.color.red));
        }else if(!user.isValidEmail())
        {
            txtResultLogin.setText("Email invalid");
            txtResultLogin.setTextColor(getResources().getColor(R.color.red));
        }
        else{
            txtResultLogin.setText("Email and Pass invalid");txtResultLogin.setTextColor(getResources().getColor(R.color.teal_700));
        }
    }
}