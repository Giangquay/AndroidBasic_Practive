package vn.minhgiang.SharedPrerencesAndorid.SharePreferencesObject;

import android.content.Context;

import com.google.gson.Gson;

import vn.minhgiang.SharedPrerencesAndorid.Model.User;

public class DataLocalManga {
    private static final String KEY_OBJECT_USER = "KEY_OBJECT_USER";
    private static DataLocalManga instance;
    private  MySharedPreferencesUser mySharedPreences;

    public static void init(Context context)
    {
        instance=new DataLocalManga();
        instance.mySharedPreences= new MySharedPreferencesUser(context);

    }
    public static DataLocalManga getInstance(){
        if (instance==null)
        {
            instance=new DataLocalManga();
        }
        return instance;
    }
    public static void setUser(User user)
    {
        Gson gson= new Gson();
        String strJsonUser=gson.toJson(user);
        DataLocalManga.getInstance().mySharedPreences.putStringvalues(KEY_OBJECT_USER,strJsonUser);
    }
    public static User getUser()
    {
        String strJsonUser=DataLocalManga.getInstance().mySharedPreences.getStringvalues(KEY_OBJECT_USER);
        Gson gson = new Gson();
        User user=gson.fromJson(strJsonUser,User.class);
        return user;
    }
}
