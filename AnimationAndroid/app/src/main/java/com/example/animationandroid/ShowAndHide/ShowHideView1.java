package com.example.animationandroid.ShowAndHide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;

import com.example.animationandroid.R;
import com.example.animationandroid.ShowAndHide.User.UserAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ShowHideView1 extends AppCompatActivity {
    UserAdapter userAdapter;
    RecyclerView rcyle;
    FloatingActionButton btnFloating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hide_view1);
        rcyle=findViewById(R.id.lRecycleView);
        btnFloating=findViewById(R.id.floatingActionButton);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcyle.setLayoutManager(linearLayoutManager);
        userAdapter = new UserAdapter(this,getListUser());
        rcyle.setAdapter(userAdapter);
//        rcyle.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                if (dy>0)
//                {
//                    btnFloating.setVisibility(View.GONE);
//                }else {
//                    btnFloating.setVisibility(View.VISIBLE);
//                }
//            }
//        });
        rcyle.setOnTouchListener(new TranslateAnimationUtil(this,btnFloating));
    }

    private List<String> getListUser() {
        List<String> list = new ArrayList<>();
        list.add("Van ban 1");
        list.add("Van ban 2");
        list.add("Van ban 3");
        list.add("Van ban 4");
        list.add("Van ban 5");
        list.add("Van ban 6");
        list.add("Van ban 7");
        list.add("Van ban 8");
        list.add("Van ban 9");
        list.add("Van ban 10");
        list.add("Van ban 11");
        list.add("Van ban 12");
        list.add("Van ban 13");
        list.add("Van ban 14");
        return list;
    }

    protected void onDestroy() {
        if (userAdapter !=null)
        {
            userAdapter.replace();
        }
        super.onDestroy();
    }
}