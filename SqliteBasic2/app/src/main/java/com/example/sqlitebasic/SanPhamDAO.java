package com.example.sqlitebasic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    private SQLiteDatabase db;
    private SQLiteOpenHelper dbHelper;
    private  Context context;
    public SanPhamDAO(Context context)
    {   this.context=context;
        dbHelper = new KetnoiDatabase(context);//thu thi tao database
        db=dbHelper.getWritableDatabase();//cho phep gi du lieu vao database
    }
    //Them du lieu
    public int insert(SanPham sp)
    {
        ContentValues contentValues = new ContentValues();//tao doi tuong chua du lieu
        //Dua du lieu vao doi tuong chua
        contentValues.put("masp",sp.getMaSp());
        contentValues.put("tensp",sp.getTenSp());
        contentValues.put("soluong",String.valueOf(sp.getSoLuong()));
        //thu thi insert
        long kq =db.insert("Sanpham",null,contentValues);
        //kiem tra ket qua insert
        if (kq<=0)
        {
            return -1;//insert that bai
        }else
        {
            return 1;//insert thanh cong
        }
    }
    //Hien thi du lieu dang String
    public List<SanPham> getAllSanPhamToString()
    {
        List<SanPham> ls = new ArrayList<>();//Tao 1 danh sach rong
        //tao con tro doc bang du lieu san pham
        Cursor cursor =db.query("Sanpham",null,null,null,null,null,null);
        cursor.moveToFirst();//di chuyen con tro ve ban ghi dau tien
        while (cursor.isAfterLast()==false)//trong khi khong phai dong cuoi cung => van doc
        {
                SanPham s = new SanPham();//tao doi tuong chua du lieu
                s.setMaSp(cursor.getString(0));//doc du lieu Ma san pham dua vao San Pham
                s.setTenSp(cursor.getString(1));//doc du lieu Ten san pham dua vao San pham
                s.setSoLuong(cursor.getInt(2));//doc du lieu So luong dua vao san pham
                //chuyen doi tuong thanh chuoi
            ls.add(s);
            cursor.moveToNext();
        }
        cursor.close();
        return ls;
    }
    public int deleteSP(String masp)
    {
        //thu thi xoa
        int kq = db.delete("Sanpham","masp=?",new String[]{masp});
        if (kq<=0)
        {
            return -1;//insert that bai
        }else
        {
            return 1;//insert thanh cong
        }
    }
    public int Update(SanPham sp)
    {
        ContentValues contentValues = new ContentValues();//tao doi tuong chua du lieu
        //Dua du lieu vao doi tuong chua
        contentValues.put("masp",sp.getMaSp());
        contentValues.put("tensp",sp.getTenSp());
        contentValues.put("soluong",String.valueOf(sp.getSoLuong()));
        //thu thi insert
        long kq =db.update("Sanpham",contentValues,"masp=?",new String[]{sp.getMaSp()});
        //kiem tra ket qua insert
        if (kq<=0)
        {
            return -1;//insert that bai
        }else
        {
            return 1;//insert thanh cong
        }
    }
}
