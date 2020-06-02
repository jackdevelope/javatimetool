package com.company.numberChartime;

import java.util.*;

public interface NumChar {
    public static final String myNum="123,456,789,123,456";
    public static final String regex="\\D";
    List<String> list=new ArrayList<>();
    List<String> list0=new ArrayList<>();
    List<String> list1=new ArrayList<>();
    HashMap<String, String> map=new HashMap<String, String>();
    Map<String,String> find();
    Map<String,String> result(List<String> list);
}
