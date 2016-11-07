package com.keyi.learnsensor.sample1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/10/27.
 */
public class GameSample1 extends Activity{
    BallView bv;		//BallView对象引用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);		//设置不显示标题
        getWindow().setFlags(									//设置为全屏模式
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WindowManager wm = this.getWindowManager();

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        Log.e("height",height+"");
        bv = new BallView(this,width,height);	//创建BallView对象
        setContentView(bv);			//将屏幕设置为BallView对象
    }
}
