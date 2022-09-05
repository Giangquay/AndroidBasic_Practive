package com.example.sqlitebasic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class KetnoiDatabase extends SQLiteOpenHelper {
    private static final String SQL_SANPHAM="CREATE TABLE Sanpham (" +
            "masp text PRIMARY KEY,"+
            "tensp text,"+
            "soluong number)";
    public KetnoiDatabase(Context context) {
        super(context, "QLBH.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_SANPHAM);//lenh tao bang San pham
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Sanpham");//Xoa bang cu / tao bang moi
    }
}
