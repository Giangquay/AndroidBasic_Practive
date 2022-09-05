package vn.minhgiang.list.ReclyView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import vn.minhgiang.list.Item;
import vn.minhgiang.list.MainActivity;

import vn.minhgiang.list.R;
import java.util.ArrayList;
import java.util.List;

public class Recyleview extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    AdapterView adapterView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyleview);
        //link den id chua recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
         adapterView = new AdapterView(data(), new MyItemClick<Item>() {
             @Override
             public void OnclickItemListener(Item item) {
                 togo(item);
             }
         });
                 mRecyclerView.setAdapter(adapterView);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(7,LinearLayoutManager.HORIZONTAL));
    }
    private List<Item> data(){
        List listitem = new ArrayList<>();
        listitem.add(new Item("item1",R.drawable.react));
        listitem.add(new Item("item2",R.drawable.java));
        listitem.add(new Item("item3",R.drawable.adobe));
        listitem.add(new Item("item4",R.drawable.html));
        listitem.add(new Item("item5",R.drawable.js));
        listitem.add(new Item("item6",R.drawable.studio));
        listitem.add(new Item("item7",R.drawable.adobe));
        listitem.add(new Item("item7",R.drawable.instagram));
        listitem.add(new Item("item8",R.drawable.twitter));
        listitem.add(new Item("item10",R.drawable.studio));
        listitem.add(new Item("item11",R.drawable.html));
        listitem.add(new Item("item12",R.drawable.react));
        listitem.add(new Item("item13",R.drawable.java));
        listitem.add(new Item("item14",R.drawable.linkedin));

            return listitem;
    }
    //ham gui du lieu
    private void togo(Item item1)
    {
        Intent intent = new Intent(Recyleview.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("dulieu",item1);
        intent.putExtras(bundle);
        startActivity(intent);
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (adapterView!=null)
//        {
//            adapterView.replease();
//        }
//    }
}