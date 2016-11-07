package com.keyi.learnsensor;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.keyi.learnsensor.Sample2.SampleActivity;
import com.keyi.learnsensor.Sample3.Sample3;
import com.keyi.learnsensor.sample1.GameSample1;

/**
 * Created by Administrator on 2016/10/27.
 */
public class OneActivity extends Activity implements View.OnClickListener {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        button1= (Button) findViewById(R.id.bt1);
        button2= (Button) findViewById(R.id.bt2);
        button3= (Button) findViewById(R.id.bt3);
        button4= (Button) findViewById(R.id.bt4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        MyReceiver receiver=new MyReceiver();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("android.intent.action.MY_PACKAGE_REPLACED");
        registerReceiver(receiver, intentFilter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt1:
                Intent intent1=new Intent(OneActivity.this,MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.bt2:
                Intent intent2=new Intent(OneActivity.this,GameSample1.class);
                startActivity(intent2);
                break;
            case R.id.bt3:
                Intent intent3=new Intent(OneActivity.this,SampleActivity.class);
                startActivity(intent3);
                break;
            case R.id.bt4:
                Intent intent4=new Intent(OneActivity.this,Sample3.class);
                startActivity(intent4);
                break;

        }
    }


}
