package com.company.twoCharCompare;

import java.util.Scanner;
import java.util.TreeSet;

public class CharCompareText {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       MyTool myTool=new ToolRealize();
       System.out.println("PLease input a small length String:");
       String first=sc.next();
       System.out.println("PLease input a big length String more than first String:");
       String second=sc.next();
       boolean sign=myTool.totalHandle(first,second).isEmpty();
       if (sign){
           System.out.println("It is  equality");
       }else {
           System.out.println("Maximal the same string:"+myTool.totalHandle(first,second));
       }
    }
}
