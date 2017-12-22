package com.example.useleakcanary;

import android.content.Context;

/**
 * Created by libo on 2017/12/21.
 */

public class SingletonManager {
    private Context mContext;
    private static SingletonManager instance;

    private SingletonManager(Context context){
        mContext = context;
    }

    public static synchronized SingletonManager getInstance(Context context){
        if(instance == null){
            instance = new SingletonManager(context);
        }
        return instance;
    }
}
