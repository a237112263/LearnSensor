package com.keyi.learnsensor.sample1;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.keyi.learnsensor.R;

/**
 * Created by Administrator on 2016/10/28.
 */
public class Learning extends Activity{
    private TextView textView,textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        TextView textView=new TextView(this);
        WindowManager manager=this.getWindowManager();
        int width=manager.getDefaultDisplay().getWidth();
        int height=manager.getDefaultDisplay().getHeight();
    }
}
