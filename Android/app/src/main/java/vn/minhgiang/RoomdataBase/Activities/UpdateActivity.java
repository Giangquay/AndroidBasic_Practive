package vn.minhgiang.RoomdataBase.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.minhgiang.RoomdataBase.DTO.User;
import vn.minhgiang.RoomdataBase.userDatabase.DatabaseUser;
import vn.minhgiang.list.R;

public class UpdateActivity extends AppCompatActivity {
    EditText userName,userAddress;
    Button buttonUpdateUser;
    private User muser;
    private void init()
    {
        userName=findViewById(R.id.RoomUser);
        userAddress=findViewById(R.id.RoomAdress);
        buttonUpdateUser=findViewById(R.id.btnRoom);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        init();
        muser= (User) getIntent().getExtras().get("Update");
        if (muser!=null)
        {
            userName.setText(muser.getUserName());
            userAddress.setText(muser.getAddress());
        }
        buttonUpdateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser();
            }
        });
    }

    private void updateUser() {
        String strUsername = userName.getText().toString().trim();
        String strUserAddress = userAddress.getText().toString().trim();
        if (TextUtils.isEmpty(strUsername)||TextUtils.isEmpty(strUserAddress))
        {
            return;
        }
        User user = new User(strUsername,strUserAddress);

        //Update
        muser.setUserName(strUsername);
        muser.setAddress(strUserAddress);
        DatabaseUser.getInstance(this).userDao().updateUser(muser);
        Toast.makeText(this,"Update User Success",Toast.LENGTH_SHORT).show();

        Intent resultIntent = new Intent();
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}