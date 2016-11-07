package com.keyi.learnsensor.Sample2;

/**
 * Created by Administrator on 2016/10/27.
 */
public class Particle {
    int color;//粒子颜色
    int r;//粒子半径
    double vertical_v;//垂直速度
    double horizontal_v;//水平速度
    int startX;//初始x坐标
    int startY;//初始y坐标
    int x;//实时x坐标
    int y;//实时y坐标
    double startTime;//起始时间
    public Particle(int tempColor, int tempR, double temp_v, double temp_h, int tempX, int tempY, double startTime) {
        this.color = tempColor;
        this.r = tempR;
        this.vertical_v = temp_v;
        this.horizontal_v = temp_h;
        this.startX = tempX;
        this.startY = tempY;
        this.x = tempX;
        this.y = tempY;
        this.startTime = startTime;
    }
}
