package com.example.sqlitebasic.Baitap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sqlitebasic.R;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView lv ;
    ArrayList<Nut> listNut= new ArrayList<>();
    ArrayAdapter<Nut> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv=findViewById(R.id.lv);
        SqliteHelp sqliteHelp = new SqliteHelp(this);
        sqliteHelp.createDefaultNode();
        listNut.addAll(sqliteHelp.getAllNotes());
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listNut);
        lv.setAdapter(arrayAdapter);
    }
}