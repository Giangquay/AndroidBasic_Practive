package vn.minhgiang.RoomdataBase.Activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.minhgiang.RoomdataBase.Adapter.UserAdapter;
import vn.minhgiang.RoomdataBase.DTO.User;
import vn.minhgiang.RoomdataBase.userDatabase.DatabaseUser;
import vn.minhgiang.list.R;

public class LoginRoom extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 10;
    EditText userName,userAddress,editSearch;
    TextView deleteAll;
    Button buttonUser;
    RecyclerView recyclerViewUser;

    private UserAdapter mUserAdapter;
    private List<User> mListuser;

    private ActivityResultLauncher<Intent> mActivityresultLauncher =registerForActivityResult(new ActivityResultContracts.StartActivityForResult()
            , new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()==RESULT_OK)
                    {
                        loadData();
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_room);
        init();
        mUserAdapter = new UserAdapter(new UserAdapter.iClickItemUser() {
            @Override
            public void update(User user) {
                clickUpdateUser(user);
            }

            @Override
            public void delete(User user) {
                clickDeleteUser(user);
            }
        });
        mUserAdapter.setData(mListuser);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewUser.setLayoutManager(linearLayoutManager);
        recyclerViewUser.setAdapter(mUserAdapter);

        buttonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
        loadData();
        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDeleteAllUser();
            }
        });
        editSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId== EditorInfo.IME_ACTION_SEARCH)
                {
                    handleSearchUser();
                }
                return false;
            }
        });
    }

    private void handleSearchUser() {
        String seachUser=editSearch.getText().toString();
        mListuser.clear();
        mListuser = DatabaseUser.getInstance(this).userDao().searchName(seachUser);
        mUserAdapter.setData(mListuser);
        hideSoftKeyboard();
    }

    private void clickDeleteAllUser() {
        new AlertDialog.Builder(this).setTitle("Confirm Delete ALL User").setMessage("Are you sure")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseUser.getInstance(LoginRoom.this).userDao().deleteAllUser();
                        Toast.makeText(LoginRoom.this,"Delete ALL User Sucessfully",Toast.LENGTH_SHORT).show();
                        loadData();
                    }
                }).setNegativeButton("NO",null).show();
    }

    private void clickDeleteUser(final User user) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Database User");
        builder.setMessage("Are you sure");
        builder.setPositiveButton("Dong y", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    DatabaseUser.getInstance(LoginRoom.this).userDao().deleteUser(user);
                    Toast.makeText(LoginRoom.this,"Delete User Success",Toast.LENGTH_SHORT).show();
                    loadData();
            }
        });
        builder.setNegativeButton("Khong dong y",null);
        builder.show();
    }

    private void clickUpdateUser(User user) {
        Intent intent = new Intent(LoginRoom.this,UpdateActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Update",user);
        intent.putExtras(bundle);
        mActivityresultLauncher.launch(intent);
//        startActivityForResult(intent, MY_REQUEST_CODE);
    }

    private void addUser() {
        String strUsername = userName.getText().toString().trim();
        String strUserAddress = userAddress.getText().toString().trim();
        if (TextUtils.isEmpty(strUsername)||TextUtils.isEmpty(strUserAddress))
        {
            return;
        }
        User user = new User(strUsername,strUserAddress);

        if (isUserexit(user))
        {
            Toast.makeText(this,"UserExit",Toast.LENGTH_SHORT).show();
            return;
        }
        DatabaseUser.getInstance(this).userDao().insertUser(user);

        Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();

        userName.setText("");
        userAddress.setText("");
        hideSoftKeyboard();

        loadData();
    }
    // an ban phim
    public void hideSoftKeyboard()
    {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        }catch (NullPointerException ex)
        {
            ex.printStackTrace();
        }
    }
    //chieu id
    private void init()
    {
        userName=findViewById(R.id.RoomUser);
        userAddress=findViewById(R.id.RoomAdress);
        recyclerViewUser=findViewById(R.id.lv_recycler_room);
        buttonUser=findViewById(R.id.btnRoom);
        deleteAll=findViewById(R.id.textDeleteAll);
        editSearch=findViewById(R.id.edtSearch_Room);
    }
    //load du lieu len man hinh
    private void loadData()
    {
        mListuser=DatabaseUser.getInstance(this).userDao().getlistUser();
        mUserAdapter.setData(mListuser);
    }
    //check xem du lieu da ton tai trong chua
    public boolean isUserexit(User user)
    {
        List<User> list = DatabaseUser.getInstance(this).userDao().checkUser(user.getUserName());
        return list!=null && !list.isEmpty();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == MY_REQUEST_CODE && resultCode==Activity.RESULT_OK)
//        {
//            loadData();
//        }
//    }
}