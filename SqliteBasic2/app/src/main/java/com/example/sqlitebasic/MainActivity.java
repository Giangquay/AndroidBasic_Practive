package com.example.sqlitebasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText txtMa,txtTen,txtSoluong;
    Button btnThem,btnSua,btnXoa,btnHienthi;
    ListView listView;
    ArrayAdapter<SanPham> arrayAdapter;
    SanPhamDAO sanPhamDAO;

    List<SanPham> ls = new ArrayList<>();
    public void init()
    {
        txtMa=findViewById(R.id.txt_masp);
        txtTen=findViewById(R.id.txt_tensp);
        txtSoluong=findViewById(R.id.txt_soluongsp);
        btnThem=findViewById(R.id.btnThem);
        btnSua=findViewById(R.id.btnSua);
        btnXoa=findViewById(R.id.btnXoa);
        btnHienthi=findViewById(R.id.btnHienthi);
        listView=findViewById(R.id.lvSanpham);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Thao tac anh xa
        init();
        //hien thi du lieu
        sanPhamDAO = new SanPhamDAO(MainActivity.this);//tao co so du lieu va bang du lieu
        //---

        btnHienthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ls.clear();//xoa het cac noi dung trong list
                ls=sanPhamDAO.getAllSanPhamToString();
                arrayAdapter = new ArrayAdapter<SanPham>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,ls);
                listView.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dua du lieu vao doi tuong
                SanPham s = new SanPham();//tao doi tuong chua du lieu nguoi dung nhap
                s.setMaSp(txtMa.getText().toString());
                s.setTenSp(txtTen.getText().toString());
                s.setSoLuong(Integer.parseInt(txtSoluong.getText().toString()));
                //goi ham insert
                int kq = sanPhamDAO.insert(s);
                if (kq==-1)
                {
                    Toast.makeText(MainActivity.this,"Insert That bai",Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this,"Insert Thanh Cong",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masp=txtMa.getText().toString();
                int kq = sanPhamDAO.deleteSP(masp);
                if (kq==-1)
                {
                    Toast.makeText(MainActivity.this,"Xoa That bai",Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this,"Xoa Thanh Cong",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanPham s = new SanPham();//tao doi tuong chua du lieu nguoi dung nhap
                s.setMaSp(txtMa.getText().toString());
                s.setTenSp(txtTen.getText().toString());
                s.setSoLuong(Integer.parseInt(txtSoluong.getText().toString()));
                //goi ham insert
                int kq = sanPhamDAO.Update(s);
                if (kq==-1)
                {
                    Toast.makeText(MainActivity.this,"Sua That bai",Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this,"Sua Thanh Cong",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}