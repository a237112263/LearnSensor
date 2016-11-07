package com.keyi.learnsensor;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/10/29.
 */
public class MyIntentService extends IntentService {
    private String ex = "";
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(MyIntentService.this,"-e"+ex,Toast.LENGTH_SHORT).show();
        }
    };

    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        /*
            模拟耗时任务，
            因为在子线程中执行，所以需要handle是跟主线成通讯
         */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mHandler.sendEmptyMessage(0);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ex=intent.getStringExtra("start");
        return super.onStartCommand(intent, flags, startId);
    }
}
