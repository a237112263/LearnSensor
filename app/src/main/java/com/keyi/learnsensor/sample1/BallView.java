package com.keyi.learnsensor.sample1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.keyi.learnsensor.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2016/10/27.
 */
public class BallView extends SurfaceView implements SurfaceHolder.Callback {
    public static final  int V_MAX=35;
    public static final int V_MIN=15;
    public static final int WOOD_EDGE=60;
     int GROUND_LING;
    public static final int UP_ZERO=30;
    public static final int DOWN_ZERO=60;
    Bitmap[] bitmapArray= new Bitmap[6];
    Bitmap bmpBack;
    Bitmap bmpWood;
    String fps="FPS:N/A";
    int ballNumber=8;
    ArrayList<Movable> alMovable=new ArrayList<>();
    DrawThread dt;
   private int height;
    private int width;
    public BallView(Context context, int width, int height) {
        super(context);
        getHolder().addCallback(this);
        initBitmaps(getResources());
        initMovable(height);
        dt=new DrawThread(this,getHolder());
        this.height=height;
        this.width=width;
    }

    private void initMovable(int height) {
        Random r = new Random();	//创建一个Random对象
        for(int i=0;i<ballNumber;i++){
            int index = r.nextInt(32);		//产生随机数
            Bitmap tempBitmap=null;			//声明一个Bitmap图片引用
            if(i<ballNumber/2){
                tempBitmap = bitmapArray[3+index%3];//如果是初始化前一半球，就从大球中随机找一个
            }
            else{
                tempBitmap = bitmapArray[index%3];//如果是初始化后一半球，就从小球中随机找一个
            }
            Log.e("height",height+"");
            Movable m = new Movable(0,70-tempBitmap.getHeight(),tempBitmap.getWidth()/2,tempBitmap,height);	//创建Movable对象
            alMovable.add(m);	//将新建的Movable对象添加到ArrayList列表中
        }
    }

    //方法：绘制程序中所需要的图片等信息
    public void doDraw(Canvas canvas) {
        bmpBack = Bitmap.createScaledBitmap(bmpBack, width, height, true);
        canvas.drawBitmap(bmpBack, 0, 0, null);	//绘制背景图片
        canvas.drawBitmap(bmpWood, 0, 60, null);//绘制木板图片
        for(Movable m:alMovable){	//遍历Movable列表，绘制每个Movable对象
            m.drawSelf(canvas);
        }
        Paint p = new Paint();	//创建画笔对象
        p.setColor(Color.BLUE);	//为画笔设置颜色
        p.setTextSize(18);		//为画笔设置字体大小
        p.setAntiAlias(true);	//设置抗锯齿
        canvas.drawText(fps, 30, 30, p);	//画出帧速率字符串
    }
    private void initBitmaps(Resources r) {
        bitmapArray[0] = BitmapFactory.decodeResource(r, R.drawable.ball_red_small);	//红色较小球
        bitmapArray[1] = BitmapFactory.decodeResource(r, R.drawable.ball_purple_small);	//紫色较小球
        bitmapArray[2] = BitmapFactory.decodeResource(r, R.drawable.ball_green_small);	//绿色较小球
        bitmapArray[3] = BitmapFactory.decodeResource(r, R.drawable.ball_red);			//红色较大球
        bitmapArray[4] = BitmapFactory.decodeResource(r, R.drawable.ball_purple);		//紫色较大球
        bitmapArray[5] = BitmapFactory.decodeResource(r, R.drawable.ball_green);		//绿色较大球
        bmpBack = BitmapFactory.decodeResource(r, R.drawable.back);						//背景砖墙
        bmpWood = BitmapFactory.decodeResource(r, R.drawable.wood);						//木板
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!dt.isAlive()){
            dt.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        dt.flag=false;
        dt=null;
    }
}
