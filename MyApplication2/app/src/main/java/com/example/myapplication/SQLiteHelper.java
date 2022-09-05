package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String SQL_PRODUCT="CREATE TABLE PRODUCT( "+
            "id Integer primary key,"+
            "name text, "+
            "price real, "+
            "img real) ";

    public static final String SQL_SANPHAM="CREATE TABLE sanpham ( " +
            "masp text primary key, "+
            "tensp text, "+
            "soluongSP text)";

    public SQLiteHelper(@Nullable Context context) {
        super(context, "QLBH.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_PRODUCT);
        sqLiteDatabase.execSQL(SQL_SANPHAM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PRODUCT");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS sanpham");
    }
}
