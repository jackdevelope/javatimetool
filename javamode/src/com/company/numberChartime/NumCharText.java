package com.company.numberChartime;

import com.company.twoCharCompare.MyTool;
import com.company.twoCharCompare.ToolRealize;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumCharText {
    public static void main(String[] args) {
        HashMap<String,String> map=new HashMap<>();
      NumChar nct=new NumCharImpl();
        Map<String, String> stringIntegerMap = nct.find();
        System.out.println(stringIntegerMap);

    }
}
