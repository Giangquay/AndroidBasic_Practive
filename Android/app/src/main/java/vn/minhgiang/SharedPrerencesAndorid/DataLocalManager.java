package vn.minhgiang.SharedPrerencesAndorid;

import android.content.Context;

import java.util.Set;

public class DataLocalManager {
    private static final String FREF_FIRST_INSTALL = "FREF_FIRST_INSTALL";
    private static final String PRE_NAME_USER = "FREF_FIRST_INSTALL";
    private static DataLocalManager instance;
    private MySharePrerences mySharedPreences;

    public static void init(Context context)
    {
        instance=new DataLocalManager();
        instance.mySharedPreences =new MySharePrerences(context);

    }
    public static DataLocalManager getInstance(){
        if (instance==null)
        {
            instance=new DataLocalManager();
        }
        return instance;
    }
    public static void setFistInstalled(boolean isFirst)
    {
        DataLocalManager.getInstance().mySharedPreences.putBooleanValue(FREF_FIRST_INSTALL,isFirst);
    }
    public static boolean getFistInstalled()
    {
        return DataLocalManager.getInstance().mySharedPreences.getBooleanValue(FREF_FIRST_INSTALL);
    }

    public static void setNameInstalled(Set<String> isFirst)
    {
        DataLocalManager.getInstance().mySharedPreences.putStringSetValue(PRE_NAME_USER,isFirst);
    }

    public static Set<String> getnameInstalled()
    {
        return DataLocalManager.getInstance().mySharedPreences.getStringSetValue(FREF_FIRST_INSTALL);
    }
}
