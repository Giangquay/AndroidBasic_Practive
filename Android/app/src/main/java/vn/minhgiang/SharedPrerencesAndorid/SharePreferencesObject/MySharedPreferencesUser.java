package vn.minhgiang.SharedPrerencesAndorid.SharePreferencesObject;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferencesUser {
    private Context mContext;
    private static final String My_Send_Preferences="MY_DATA_PREFERENCES";

    public MySharedPreferencesUser(Context context) {
        this.mContext = context;
    }
    public void putStringvalues(String key,String values)
    {
        SharedPreferences mSharedPreferences=mContext.getSharedPreferences(My_Send_Preferences,Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor=mSharedPreferences.edit();
        mEditor.putString(key,values);
        mEditor.apply();
    }
    public String getStringvalues(String key)
    {
        SharedPreferences mSharedPreferences=mContext.getSharedPreferences(My_Send_Preferences,Context.MODE_PRIVATE);
        return mSharedPreferences.getString(key,"");
    }
}
