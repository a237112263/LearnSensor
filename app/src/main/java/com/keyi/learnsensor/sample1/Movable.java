package com.keyi.learnsensor.sample1;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Administrator on 2016/10/27.
 */
public class Movable {
     int startX=0;//初始X坐标
     int startY=0;//初始Y坐标
     int x;//实时X坐标
     int y;//实时Y坐标
     float startVX=0f;//初始竖直方向的速度
     float startVY=0f;//初始水平方向的速度
     float v_x=0f;//实时水平方向的速度
     float v_y=0f;//实时竖直方向的速度
    int r;//可移动物体的半径
    double timeX;//X方向运动的时间
    double timeY;//Y方向运动的时间
    Bitmap bitmap=null;//可移动物体的图片
    BallThread thread=null;//负责小球运动时的线程
    boolean bFall=false;//小球是否从木板下落
    float impactFactor=0.25f;//小球撞地后的损失系数

    //初始化小球的数据，并开启线程管理类
    public Movable(int x, int y, int r, Bitmap bitmap, int GROUND_LING) {
        this.bitmap = bitmap;
        this.r = r;
        y = y;
        x = x;
        this.startX=x;
        this.startY=y;
        timeX=System.nanoTime();
        this.v_x=BallView.V_MIN+(int)((BallView.V_MAX-BallView.V_MIN)*Math.random());
        thread=new BallThread(this,GROUND_LING);
        thread.start();
    }
    public void drawSelf(Canvas canvas){
        canvas.drawBitmap(this.bitmap,x,y,null);
    }
}
