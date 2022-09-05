package com.example.myapplication.NavigationView.NavigaViewDrawer.FragmentOnBroading;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.myapplication.NavigationView.NavigaViewDrawer.Activities.LoginActivity;
import com.example.myapplication.R;

public class FragmentOnbroading3 extends Fragment {
    private Button button;
    private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_onbroading3, container, false);
        button=mView.findViewById(R.id.btn_get_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return mView;
    }
}