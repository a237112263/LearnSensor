package com.keyi.learnsensor.Sample2;

import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/27.
 */
public class ParticleSet {
    ArrayList<Particle> particleSet;

    public ParticleSet() {
        particleSet = new ArrayList<>();
    }
    public void add(int count,double startTime,int width,int height){
        for (int i=0;i<count;i++){
            int tempColor=this.getColor(i);
            int tempR=5;
            double temp_v=-30+10*(Math.random());
            double temp_h=10-20*(Math.random());
            int tempX=width/2;
            int tempY=(int) (200-10*(Math.random()));

            Particle particle=new Particle(tempColor,tempR,temp_v,temp_h,tempX,tempY,startTime);
            particleSet.add(particle);
        }
    }

    private int getColor(int i) {
        int color= Color.RED;
        switch (i%5){
            case 0:
                color=Color.RED;
                break;
            case 1:
                color=Color.GREEN;
                break;
            case 2:
                color=Color.YELLOW;
                break;
            case 3:
                color=Color.GRAY;
                break;
            case 4:
                color=Color.WHITE;
                break;
        }
        return color;
    }
}
