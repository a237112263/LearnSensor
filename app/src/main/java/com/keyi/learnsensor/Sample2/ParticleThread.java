package com.keyi.learnsensor.Sample2;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/27.
 */
public class ParticleThread extends Thread {
    boolean flag;
    ParticleView father;
    int sleepSpan=80;
    double time=0;
    double span=0.15;//物理引擎的时间轴
    int width;
    int height;

    public ParticleThread(ParticleView father, int width, int height){
        this.father=father;
        this.flag=true;
        this.width=width;
        this.height=height;
    }
    @Override
    public void run() {
        while(flag){
            father.ps.add(10, time,width,height);	//每次添加10个粒子
            ArrayList<Particle> tempSet = father.ps.particleSet;//获取粒子集合
            int count = tempSet.size();		//记录粒子集合的大小
            for(int i=0; i<count; i++){		//遍历粒子集合，修改其轨迹
                Particle particle = tempSet.get(i);
                double timeSpan = time - particle.startTime;	//计算从程序开始到现在经过的时间间隔
                int tempx = (int)(particle.startX+particle.horizontal_v*timeSpan);	//计算出粒子的X坐标
                int tempy = (int)(particle.startY + 4.9*timeSpan*timeSpan + particle.vertical_v*timeSpan);
                if(tempy>ParticleView.DIE_OUT_LINE){						//如果超过屏幕下边沿
                    tempSet.remove(particle);		//从粒子集合冲移除该Particle对象
                    count = tempSet.size();//重新设置粒子个数

                }
                particle.x = tempx;					//修改粒子的X坐标
                particle.y = tempy;					//修改粒子的Y坐标
            }
            time += span;								//将时间延长
            try{
                Thread.sleep(sleepSpan);					//休眠一段时间
            }
            catch(Exception e){
                e.printStackTrace();				//捕获并打印异常
            }
        }
    }
}
