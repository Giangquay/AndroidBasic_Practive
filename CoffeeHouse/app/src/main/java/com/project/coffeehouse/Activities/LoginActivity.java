package com.project.coffeehouse.Activities;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.project.coffeehouse.DAO.NhanVienDAO;
import com.project.coffeehouse.R;

public class LoginActivity extends AppCompatActivity {
    Button BTN_login_DangNhap, BTN_login_DangKy, BTN_login_QuenMatKhau;
    TextInputLayout TXTL_login_TenDN, TXTL_login_MatKhau;
    CheckBox chkbox_savelog;
    NhanVienDAO nhanVienDAO;
    private View view;
    SharedPreferences sh_typeAcc, sh_chkSavelog;
    public static final String BUNDLE = "BUNDLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        //thuộc tính view
        TXTL_login_TenDN = (TextInputLayout)findViewById(R.id.txtl_login_TenDN);
        TXTL_login_MatKhau = (TextInputLayout)findViewById(R.id.txtl_login_MatKhau);
        BTN_login_DangNhap = (Button)findViewById(R.id.btn_login_DangNhap);
        BTN_login_QuenMatKhau = (Button)findViewById(R.id.btn_login_quenmatkhau);
        chkbox_savelog = (CheckBox)findViewById(R.id.chkbox_login_savelog);


        nhanVienDAO = new NhanVienDAO(this);    //khởi tạo kết nối csdl

        BTN_login_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateUserName() | !validatePassWord()){
                    return;
                }

                String tenDN = TXTL_login_TenDN.getEditText().getText().toString();
                String matKhau = TXTL_login_MatKhau.getEditText().getText().toString();
                int ktra = nhanVienDAO.KiemTraDN(tenDN,matKhau);
                int maquyen = nhanVienDAO.LayQuyenNV(ktra);
                if(ktra != 0){
                    // lưu mã quyền vào shareprefer
                    SharedPreferences sharedPreferences = getSharedPreferences("luuquyen", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.putInt("maquyen",maquyen);
                    editor.commit();

                    //gửi dữ liệu user qua trang chủ
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    intent.putExtra("tendn",TXTL_login_TenDN.getEditText().getText().toString());
                    intent.putExtra("matkhau",TXTL_login_MatKhau.getEditText().getText().toString());
                    intent.putExtra("manv",ktra);
                    boolean chk_savelog_state = chkbox_savelog.isChecked();
                    if (chk_savelog_state){
                        sh_chkSavelog = getSharedPreferences("last_chk", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor2 = sh_chkSavelog.edit();
                        editor2.putBoolean("last_chk",true);
                        editor2.commit();
                    }
                    else {
                        sh_chkSavelog = getSharedPreferences("last_chk", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor2 = sh_chkSavelog.edit();
                        editor2.putBoolean("last_chk",false);
                        editor2.commit();
                    }
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Đăng nhập thất bại!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        BTN_login_QuenMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PasswordActivity.class);
                startActivity(intent);
            }

        });

        //Set account nếu lưu đăng nhập trước
        sh_chkSavelog = getSharedPreferences("last_chk", Context.MODE_PRIVATE);
        Boolean last_chk = sh_chkSavelog.getBoolean("last_chk",false);
        if (last_chk) {
            SharedPreferences sh2 = getSharedPreferences("LastAcc", MODE_PRIVATE);

            String username = sh2.getString("UserName", "");
            String passwd = sh2.getString("PassWord", "");
            TXTL_login_TenDN.getEditText().setText(username);
            TXTL_login_MatKhau.getEditText().setText(passwd);
            chkbox_savelog.setChecked(true);
        } else {
            return;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sh_lastAcc = getSharedPreferences("LastAcc", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sh_lastAcc.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("UserName", TXTL_login_TenDN.getEditText().getText().toString());
        myEdit.putString("PassWord", TXTL_login_MatKhau.getEditText().getText().toString());
        myEdit.commit();

    }
    //Hàm quay lại màn hình chính
    public void backFromLogin(View view)
    {
        Intent intent = new Intent(getApplicationContext(),WelcomeActivity.class);
        //tạo animation cho thành phần
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.layoutLogin),"transition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
            startActivity(intent,options.toBundle());
        }
        else {
            startActivity(intent);
        }
    }

    //Hàm chuyển qua trang đăng ký
    public void callRegisterFromLogin(View view)
    {
        this.view = view;
        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    //region Validate field
    private boolean validateUserName(){
        String val = TXTL_login_TenDN.getEditText().getText().toString().trim();

        if(val.isEmpty()){
            TXTL_login_TenDN.setError(getResources().getString(R.string.not_empty));
            return false;
        }else {
            TXTL_login_TenDN.setError(null);
            TXTL_login_TenDN.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassWord(){
        String val = TXTL_login_MatKhau.getEditText().getText().toString().trim();

        if(val.isEmpty()){
            TXTL_login_MatKhau.setError(getResources().getString(R.string.not_empty));
            return false;
        }else{
            TXTL_login_MatKhau.setError(null);
            TXTL_login_MatKhau.setErrorEnabled(false);
            return true;
        }
    }
    //endregion
}