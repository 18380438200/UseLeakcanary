package com.example.useleakcanary;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.lang.ref.WeakReference;

public class TestActivity extends AppCompatActivity {
    private Handler handler = new MyHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },10000);
        finish();

        //context引用造成内存泄露
        //SingletonManager.getInstance(this);
    }

    public static class MyHandler extends Handler{
        private WeakReference<TestActivity> mActivity;

        public MyHandler(TestActivity activity){
            mActivity = new WeakReference(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            if (mActivity.get() == null) {
                return;
            }

            //接受到消息的处理
        }
    }
}
