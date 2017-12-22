package com.example.useleakcanary;

import android.app.Application;
import android.content.Context;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by libo on 2017/12/21.
 */

public class MyApplication extends Application{
    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        refWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context){
        MyApplication application = (MyApplication)context.getApplicationContext();
        return application.refWatcher;
    }
}
