package com.keyi.learnsensor.sample1;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by Administrator on 2016/10/27.
 */
public class DrawThread extends Thread{
    BallView bv;
    SurfaceHolder surfaceHolder;
    boolean flag=false;
    int sleepSpan=30;
    long start= System.nanoTime();
    int count=0;

    public DrawThread(BallView ballView, SurfaceHolder holder) {
        this.bv=ballView;
        this.surfaceHolder=holder;
        this.flag=true;
    }

    //方法：线程的执行方法，用于绘制屏幕和计算帧速率
    @Override
    public void run(){
        Canvas canvas = null;//声明一个Canvas对象
        while(flag){
            try{
                canvas = surfaceHolder.lockCanvas(null);//获取BallView的画布
                synchronized(surfaceHolder){
                    bv.doDraw(canvas);		//调用BallView的doDraw方法进行绘制
                }
            }
            catch(Exception e){
                e.printStackTrace();			//捕获并打印异常
            }
            finally{
                if(canvas != null){		//如果canvas不为空
                    surfaceHolder.unlockCanvasAndPost(canvas);//surfaceHolder解锁并将画布对象传回
                }
            }
            this.count++;
            if(count == 20){	//如果计满20帧
                count = 0;		//清空计数器
                long tempStamp = System.nanoTime();//获取当前时间
                long span = tempStamp - start;		//获取时间间隔
                start = tempStamp;					//为start重新赋值
                double fps = Math.round(100000000000.0/span*20)/100.0;//计算帧速率
                bv.fps = "FPS:"+fps;//将计算出的帧速率设置到BallView的相应字符串对象中
            }
            try{
                Thread.sleep(sleepSpan);		//线程休眠一段时间
            }
            catch(Exception e){
                e.printStackTrace();		//捕获并打印异常
            }
        }
    }
}
