package com.example.animationandroid.Animation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.animationandroid.R;

import java.util.ArrayList;

public class RecycleFloding extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_floding);
        recyclerView=findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setFocusable(false);

        productAdapter= new ProductAdapter(this);

        recyclerView.setAdapter(productAdapter);

        productAdapter.setData(getListProduct());
//        ProgressBar progressBar = (ProgressBar) findViewById(R.id.my_progressBar);
//        progressBar.setProgress(20);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                if (dy>0)
//                {
//
//                }
//            }
//        });
    }

    private ArrayList<Product> getListProduct()
    {
        ArrayList<Product> mlist= new ArrayList<>();
        mlist.add(new Product("Product 1","Produce content1"));
        mlist.add(new Product("Product 2","Produce content2"));
        mlist.add(new Product("Product 3","Produce content3"));
        mlist.add(new Product("Product 4","Produce content4"));
        mlist.add(new Product("Product 5","Produce content5"));
        mlist.add(new Product("Product 6","Produce content6"));
        return mlist;
    }

    @Override
    protected void onDestroy() {
        if (productAdapter!=null)
        {
            productAdapter.replace();
        }
        super.onDestroy();
    }
}