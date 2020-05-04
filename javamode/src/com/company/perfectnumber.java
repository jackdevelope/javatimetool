package com.company;

import java.util.*;

public class perfectnumber {
    public static void main(String[] args) {
        System.out.println("Please Input number");
        Scanner nu=new Scanner(System.in);
        int n=nu.nextInt();
        for (int i=2;i<n;i++) {// 遍历1000以内的所有整数
            int sum=0;// 定义和变量
            for (int j=1;j<i;j++) {
                if (i%j==0) {// 满足是i的因子,就累加
                    sum+=j;
                }
            }
            if (sum==i) {// 满足因子之和等于i就打印该完数
                System.out.println(n+"以内的所有完数有：");
                System.out.print(i + " ");
            }
        }
    }
}
