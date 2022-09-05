package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    private SQLiteDatabase sqLiteDatabase;
    private SQLiteHelper  dbhHelper;
    private Context context;

    public SanPhamDAO(Context context) {
        this.context = context;
        dbhHelper=new SQLiteHelper(context);
        sqLiteDatabase=dbhHelper.getWritableDatabase();
    }
    public int InsertSanPham(Product product)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("masp",product.getMaSP());
        contentValues.put("tensp",product.getTenSP());
        contentValues.put("soluongSP",String.valueOf(product.getSoluongSP()));
        //Thu thi Insert
        long ketQua = sqLiteDatabase.insert("sanpham",null,contentValues);
        if (ketQua<=0)
        {
            return -1; // Insert that bai
        }
        return 1;//Insert Thanh cong
    }
    public List<String> getAllSanPhamToString()
    {
        List<String> ls= new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query("sanpham",null,null,null
        ,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            Product product = new Product();
            product.setMaSP(cursor.getString(0));//doc du lieu truong ma san pham
            product.setTenSP(cursor.getString(1));
            product.setSoluongSP(cursor.getInt(2));
        }
        dbhHelper.close();
        return  ls;
    }


}
