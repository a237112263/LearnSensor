package com.keyi.learnsensor.Sample3;

/**
 * Created by Administrator on 2016/10/27.
 */
public class MapList {
    static int[] source={2,2};//出发点
    static int[][] target={//目标点坐标数组
            {13,2},{4,22},{0,11},{9,10},{21,22}
    };
    static int[][][] map = new int[][][]//地图数组
            {
                    {
                            {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,0,0,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
                            {1,0,0,0,0,0,1,1,0,0,1,1,0,0,0,0,1,1,0,0,0,0},
                            {1,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,1,1,0,0,0,0},
                            {1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,1,1,1,0,0,0},
                            {1,0,0,0,0,0,1,1,1,0,1,1,0,0,0,0,1,1,0,0,0,0},
                            {1,0,0,0,0,0,1,1,1,0,1,1,0,0,0,0,1,1,0,0,0,0},
                            {1,0,0,0,0,0,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0},
                            {1,1,1,0,0,1,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0},
                            {1,1,1,0,0,1,1,1,1,0,1,1,0,0,0,0,0,1,1,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0},
                            {0,0,1,0,0,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,0,0},
                            {1,1,1,0,0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,0,0},
                            {1,1,1,0,0,1,1,1,1,1,1,1,1,1,0,0,0,1,1,0,0,0},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,0},
                            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0},
                            {0,0,0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,1,0,0,0,0},
                            {1,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0},
                            {1,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0},
                            {1,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0}
                    }
            };
}