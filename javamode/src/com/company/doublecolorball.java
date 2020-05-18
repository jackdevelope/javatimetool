package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class doublecolorball {


    public static void main(String[] args) {
        StringBuffer pd= new StringBuffer();
        System.out.println("开始生成中奖号");
        int[] redcolor=new int[6];
        Random redball=new Random();
        for(int i=0;i<redcolor.length;i++){
            redcolor[i]=redball.nextInt(33);
            //System.out.println(redcolor[i]);
            pd.append(redcolor[i]);
        }
        int bluecolor;
        Random blueball=new Random();
        bluecolor=blueball.nextInt(16);
        //System.out.println(pd);
       System.out.println(pd.append(bluecolor));
    }
}
