package vn.minhgiang.ActivitysangFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.bluetooth.BluetoothAdapter;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import vn.minhgiang.BroadCastReceiver.BroadCastRecive.ExampleBroadCastReciver;
import vn.minhgiang.list.R;


public class activity extends AppCompatActivity implements ISendataListener<User>{
    private EditText edtemail,edname;
    private Button btnsend;
    private ExampleBroadCastReciver exampleBroadCastReciver;
    private User user ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysangfragment);
        edtemail =findViewById(R.id.noidung);
        edname=findViewById(R.id.edtName);
        btnsend=findViewById(R.id.chuyen);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDatafragment();
            }
        });
        exampleBroadCastReciver = new ExampleBroadCastReciver();
    }
    //gui du lieu sang Fragment bang FragmentTrangsaction
    private void sendDatafragment() {
        String Email= edtemail.getText().toString().trim();
        String name = edname.getText().toString().trim();
        user = new User(name,Email);
        //    c2    bundle.putSerializable("dulieu",Email);
              HomeFragment fragment = new HomeFragment();
              /* C3
        Bundle bundle = new Bundle();

        bundle.putSerializable("dulieu",user);
        fragment.setArguments(bundle);*/
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //truyen du lieu User vao Home Fragment = getInstance khoi tao trong Fragment(user)
        fragmentTransaction.replace(R.id.content_fragment,HomeFragment.getInstance(user));
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter1 = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(exampleBroadCastReciver,intentFilter1);
        IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(exampleBroadCastReciver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(exampleBroadCastReciver);
    }
//   c2 public EditText getEdtemail() {
//        return edtemail;
//    }
//
//    public EditText getEdname() {
//        return edname;
//    }

    @Override
    public void sendata(User user) {
        edtemail.setText(user.getEmail());
        edname.setText(user.getName());
    }

}