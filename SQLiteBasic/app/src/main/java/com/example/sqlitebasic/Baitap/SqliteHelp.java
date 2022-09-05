package com.example.sqlitebasic.Baitap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;

public class SqliteHelp extends SQLiteOpenHelper {

    private static final String DATABASE_NOTE="NoteManager.db";
    private static final String TABLE_NOTE="Note";
    private static final String COLUMN_ID="ID_Note";
    private static final String COLUMN_TITLE="Title_Note";
    private static final String COLUMN_CONTENT="Content_Note";

    private  static final String sql ="CREATE TABLE "+TABLE_NOTE+"(" +
            COLUMN_ID +" INTEGER PRIMARY KEY,"+
            COLUMN_TITLE +" char(20) , "+
            COLUMN_CONTENT +" char(20) )";

    public SqliteHelp(@Nullable Context context) {
        super(context, DATABASE_NOTE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NOTE);
    }

    public void Add(Nut nut)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE,nut.getNoteTitle());
        values.put(COLUMN_CONTENT,nut.getNoteContent());
        sqLiteDatabase.insert(TABLE_NOTE,null,values);
        sqLiteDatabase.close();
    }
    public int getNoteCount()
    {
        String sql ="SELECT * FROM "+TABLE_NOTE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        int count = cursor.getCount();
        db.close();
        return count;
    }
    public void createDefaultNode()
    {
        int count = this.getNoteCount();
        if (count==0)
        {
            Nut nut1 = new Nut("DI DONG","THAY GIANG");
            this.Add(nut1);
        }
    }
    public ArrayList<Nut> getAllNotes()
    {
        ArrayList<Nut> lisNut= new ArrayList<>();
        String sqlQuery="SELECT * FROM "+TABLE_NOTE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery,null);
        if (cursor.moveToFirst())
        {
            do {
               Nut nut = new Nut();
               nut.setNoteID(Integer.parseInt(cursor.getString(0)));
               nut.setNoteTitle(cursor.getString(1));
               nut.setNoteContent(cursor.getString(2));
               lisNut.add(nut);
            }while (cursor.moveToNext());
        }
        return lisNut;
    }
}
