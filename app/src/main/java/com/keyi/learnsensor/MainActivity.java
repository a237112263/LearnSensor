package com.keyi.learnsensor;

import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SensorManager manager;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.text1);
        textView2= (TextView) findViewById(R.id.text2);
        textView3= (TextView) findViewById(R.id.text3);
        textView4= (TextView) findViewById(R.id.text4);
        manager= (SensorManager) getSystemService(SENSOR_SERVICE);
    }
    private SensorListener sensorListener=new SensorListener() {
        @Override
        public void onSensorChanged(int i, float[] floats) {
            if (i==SensorManager.SENSOR_ACCELEROMETER){
                textView.setText(floats[0]+"");
                textView2.setText(floats[1]+"");
                textView3.setText(floats[2]+"");
                textView4.setText(floats[3]+"");
            }
        }

        @Override
        public void onAccuracyChanged(int i, int i1) {

        }
    };

    @Override
    protected void onResume() {
        manager.registerListener(sensorListener,SensorManager.SENSOR_ACCELEROMETER,SensorManager.SENSOR_DELAY_UI);
        super.onResume();
    }

    @Override
    protected void onPause() {
        manager.unregisterListener(sensorListener);
        super.onPause();

    }
}
