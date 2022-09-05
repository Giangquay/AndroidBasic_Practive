package vn.minhgiang.SharedPrerencesAndorid;

import android.app.Application;

public class MyAplicationshare extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManager.init(this);
    }
}
