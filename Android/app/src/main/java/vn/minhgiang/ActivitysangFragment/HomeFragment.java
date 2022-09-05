package vn.minhgiang.ActivitysangFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import vn.minhgiang.list.R;

public class HomeFragment extends Fragment {
    EditText geteditEmail, getName;
    Button btn;
    //Khai bao activity trong Fragment
    private activity mactivity;
    //Khai bao doi tuong view
    private View mview;
    private ISendataListener iSendataListener1;
    //Lay du lieu cua activity
    public static HomeFragment getInstance(User user)
    {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("dulieu",user);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview=inflater.inflate(R.layout.fragment_home, container, false);
        // lay du lieu cua activity trong Fragment bang getActivity();
       mactivity = (activity) getActivity();
        initUI();
        return mview ;
    }

    private void initUI() {
        geteditEmail =mview.findViewById(R.id.noidung);
        getName=mview.findViewById(R.id.Name);
        // lay du lieu cua cua Activity bang getArguments
        User user = (User) getArguments().get("dulieu");
        geteditEmail.setText(user.getEmail());
        getName.setText(user.getName());

//        geteditEmail.setText(getArguments().getString("dulieu"));
        btn=mview.findViewById(R.id.btnUpdate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendataActivty();
            }
        });
    }
    // gui du lieu tu fragment sang activity
    private void sendataActivty() {
        String strEmail = geteditEmail.getText().toString().trim();
        String Namefragment = getName.getText().toString().trim();
        // gan activity vao interface
        iSendataListener1=mactivity;
        iSendataListener1.sendata(new User(Namefragment,strEmail));
//        mactivity.getEdtemail().setText(strEmail);
//        mactivity.getEdname().setText(Namefragment);
    }
}