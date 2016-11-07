package com.keyi.learnsensor.Sample2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/10/27.
 */
public class SampleActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {		//重写onCreate方法
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);		//设置不显示标题
        getWindow().setFlags(									//设置为全屏模式
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WindowManager wm = this.getWindowManager();
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        ParticleView lz = new ParticleView(this,width,height);		//创建一个LiZiView对象
        setContentView(lz);								//将屏幕设置为ParticleView对象
    }
}
