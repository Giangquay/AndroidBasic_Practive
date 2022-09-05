package vn.minhgiang.list.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.minhgiang.list.R;
public class ListviewExample extends AppCompatActivity {
   ListView lvt;
   CustomListAdapter listAdapter;
   City city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        lvt=findViewById(R.id.lv_ListView1);
        listAdapter = new CustomListAdapter(getListCity(),this);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,getList());
//        lvt.setAdapter(arrayAdapter);
        lvt.setAdapter(listAdapter);
        registerForContextMenu(lvt);
        lvt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                city = (City) lvt.getItemAtPosition(position);
                Toast.makeText(ListviewExample.this,city.getNameCity(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private List<City> getListCity() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Hanoi",R.drawable.hanoi1));
        cities.add(new City("HoChiMinh",R.drawable.hochiminh));
        cities.add(new City("DangNang",R.drawable.danang));
        cities.add(new City("Hue",R.drawable.hue));
        cities.add(new City("NhaTrang",R.drawable.nhatrang));
        cities.add(new City("VungTau",R.drawable.vungtau));
        cities.add(new City("Sapa",R.drawable.sapa));
        return cities;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.item_city,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {

            case R.id.xemthem:
                Toast.makeText(ListviewExample.this,"city.getNameCity()",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    //    private List getList() {
//        List<String> stringList = new ArrayList<>();
//        stringList.add("Hanoi");
//        stringList.add("Long An");
//        stringList.add("Thanh Hoa");
//        stringList.add("Hai Phong");
//        stringList.add("Dang Nang");
//        stringList.add("HO CHI MINH");
//        stringList.add("Nam Dinh");
//        return stringList;
//    }
}