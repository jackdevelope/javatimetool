package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dijitian {
    private static final String yearregEx = "^\\d{4}$";
    private static final String monthregEx = "^[1-12]{1,2}$";
    private static final String dayregEx = "/^[1-31]{1,2}$/";
    public static void main(String[] args) {
        //进行正则装配，以进行位数限制
        Pattern yearpattern=Pattern.compile(yearregEx);
        Pattern monthpattern=Pattern.compile(monthregEx);
        Pattern daypattern=Pattern.compile(dayregEx);
        //年份输入
        System.out.println("Please Input year");
        Scanner year=new Scanner(System.in);
        int yearinfor=year.nextInt();
        String yearresult=String.valueOf(yearinfor);
        Matcher  yearmatcher=yearpattern.matcher(yearresult);//匹配器进行位数匹配
        //月份输入
        System.out.println("Please Input month");
        Scanner month=new Scanner(System.in);
        int monthinfor=month.nextInt();
        String monthresult=String.valueOf(monthinfor);
        Matcher  monthmatcher=monthpattern.matcher(monthresult);//匹配器进行位数匹配
        //日输入
        System.out.println("Please Input day");
        Scanner day=new Scanner(System.in);
        int dayinfor=day.nextInt();
        String dayresult=String.valueOf(dayinfor);
        Matcher  daymatcher=daypattern.matcher(dayresult);//匹配器进行位数匹配
    /*      System.out.println(yearmatcher.find());
        System.out.println(monthmatcher.find());
      System.out.println(daymatcher.find());*/
       //进行月份数组创建
        int [] montharrays=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int sum;
        if (yearmatcher.find()){
            if ((yearinfor%4==0&&yearinfor%100!=0)||(yearinfor%400==0)){
                montharrays[1]+=1;
                for (int i=0;i<montharrays.length;i++){
                    if (i==monthinfor-1){
                     /* System.out.println(i);
                        System.out.println(monthinfor-1);*/
                      if (i==0){System.out.println("现在是第"+dayinfor+"天");break;}
                      switch (i){
                          case 1: sum=31+dayinfor; System.out.println("现在是第"+sum+"天");break;
                          case 2: sum=31+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                          case 3: sum=31+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                          case 4: sum=31+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                          case 5: sum=31+montharrays[i-4]+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                          case 6: sum=31+montharrays[i-5]+montharrays[i-4]+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                          case 7: sum=31+montharrays[i-6]+montharrays[i-5]+montharrays[i-4]+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                          case 8: sum=31+montharrays[i-7]+montharrays[i-6]+montharrays[i-5]+montharrays[i-4]+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                          case 9: sum=31+montharrays[i-8]+montharrays[i-7]+montharrays[i-6]+montharrays[i-5]+montharrays[i-4]+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                          case 10: sum=31+montharrays[i-9]+montharrays[i-8]+montharrays[i-7]+montharrays[i-6]+montharrays[i-5]+montharrays[i-4]+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                          case 11: sum=31+montharrays[i-10]+montharrays[i-9]+montharrays[i-8]+montharrays[i-7]+montharrays[i-6]+montharrays[i-5]+montharrays[i-4]+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                      }
                    /*  int sum=montharrays[0]+montharrays[i]+montharrays[i+1]+dayinfor;
                      System.out.println("现在是第"+sum+"天");*/
                    }
                  //  System.out.println(montharrays[i]);
                }
            }else {
                //System.out.println("平年");
                montharrays[1]-=1;
                for (int i=0;i<montharrays.length;i++){
                    if (i==monthinfor-1){
                     /* System.out.println(i);
                        System.out.println(monthinfor-1);*/
                        if (i==0){System.out.println("现在是第"+dayinfor+"天");break;}
                        switch (i){
                            case 1: sum=31+dayinfor; System.out.println("现在是第"+sum+"天");break;
                            case 2: sum=31+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                            case 3: sum=31+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                            case 4: sum=31+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                            case 5: sum=31+montharrays[i-4]+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                            case 6: sum=31+montharrays[i-5]+montharrays[i-4]+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                            case 7: sum=31+montharrays[i-6]+montharrays[i-5]+montharrays[i-4]+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                            case 8: sum=31+montharrays[i-7]+montharrays[i-6]+montharrays[i-5]+montharrays[i-4]+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                            case 9: sum=31+montharrays[i-8]+montharrays[i-7]+montharrays[i-6]+montharrays[i-5]+montharrays[i-4]+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                            case 10: sum=31+montharrays[i-9]+montharrays[i-8]+montharrays[i-7]+montharrays[i-6]+montharrays[i-5]+montharrays[i-4]+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                            case 11: sum=31+montharrays[i-10]+montharrays[i-9]+montharrays[i-8]+montharrays[i-7]+montharrays[i-6]+montharrays[i-5]+montharrays[i-4]+montharrays[i-3]+montharrays[i-2]+montharrays[i-1]+dayinfor;System.out.println("现在是第"+sum+"天");break;
                        }
                    /*  int sum=montharrays[0]+montharrays[i]+montharrays[i+1]+dayinfor;
                      System.out.println("现在是第"+sum+"天");*/
                    }
                    //  System.out.println(montharrays[i]);
                }

            }
        } else {
            System.out.println("Warmimg!!!!You must check your year and month,day about its numbers");
            System.out.println("We advice that you should resume load,because it is four time at year and one to two time at month and day");

        }
    }
}
/*缺陷:1.无法限制月,日,位数
       2.平年总是少一天
       3.对于位数限制的错误处理没有更好的解决办法*/