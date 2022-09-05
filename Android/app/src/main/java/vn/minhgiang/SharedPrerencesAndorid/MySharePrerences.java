package vn.minhgiang.SharedPrerencesAndorid;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class MySharePrerences {
    public static final String MY_SHARED_PREFERENCES="MY_PREFERENCES";
    private Context mContext;

    public MySharePrerences(Context mContext) {
        this.mContext = mContext;
    }

    public void putBooleanValue(String key, boolean values)
    {
        SharedPreferences mSharedPreferences= mContext.getSharedPreferences(MY_SHARED_PREFERENCES,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=mSharedPreferences.edit();
        editor.putBoolean(key, values);
        editor.apply();
    }
    public boolean getBooleanValue(String key)
    {
        SharedPreferences mSharedPreferences = mContext.getSharedPreferences(MY_SHARED_PREFERENCES,Context.MODE_PRIVATE);
        return mSharedPreferences.getBoolean(key,false);
    }
    public void putIntValue(String key,int values)
    {
        SharedPreferences mSharedPreferences=mContext.getSharedPreferences(MY_SHARED_PREFERENCES,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =mSharedPreferences.edit();
        editor.putInt(key,values);
        editor.apply();
    }
    public int getIntValue(String key)
    {
        SharedPreferences mSharedPreferences=mContext.getSharedPreferences(MY_SHARED_PREFERENCES,Context.MODE_PRIVATE);
        return mSharedPreferences.getInt(key,0);
    }
    public void putStringSetValue(String key, Set<String> values)
    {
        SharedPreferences mSharedPreferences=mContext.getSharedPreferences(MY_SHARED_PREFERENCES,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =mSharedPreferences.edit();
        editor.putStringSet(key,values);
        editor.apply();
    }
    public Set<String> getStringSetValue(String key)
    {
        SharedPreferences mSharedPreferences=mContext.getSharedPreferences(MY_SHARED_PREFERENCES,Context.MODE_PRIVATE);
        Set<String> valuesDefault=new HashSet<>();
        return mSharedPreferences.getStringSet(key,valuesDefault);
    }

}
