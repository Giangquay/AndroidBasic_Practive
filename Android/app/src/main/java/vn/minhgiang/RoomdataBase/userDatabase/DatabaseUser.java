package vn.minhgiang.RoomdataBase.userDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import vn.minhgiang.RoomdataBase.DAO.UserDao;
import vn.minhgiang.RoomdataBase.DTO.User;

@Database(entities = {User.class},version = 1)
public abstract class DatabaseUser extends RoomDatabase {
    private static final String DB_NAME="user.db";
    private static  DatabaseUser instance;

    public static synchronized DatabaseUser getInstance(Context context)
    {
        if (instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),DatabaseUser.class,DB_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract UserDao userDao();
}
