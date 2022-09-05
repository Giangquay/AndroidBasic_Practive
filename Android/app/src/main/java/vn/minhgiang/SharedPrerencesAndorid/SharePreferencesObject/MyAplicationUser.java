package vn.minhgiang.SharedPrerencesAndorid.SharePreferencesObject;

import android.app.Application;

public class MyAplicationUser extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManga.init(this);
    }
}
