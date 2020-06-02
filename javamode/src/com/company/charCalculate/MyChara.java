package com.company.charCalculate;

import java.util.*;

public interface MyChara {
    public static final String str="ABCD123!@#$%ab";
    public StringBuilder find();
    default StringBuilder record(int bigChar, int smallChar, int numCount, int otherChar){
        Collection ca=new ArrayList();
        //preparing a resulting container
        HashMap<String,Integer> hashMap=new HashMap<>();
        hashMap.put("bigCharCount",bigChar);
        hashMap.put("smallCharCount",smallChar);
        hashMap.put("numCount",numCount);
        hashMap.put("otherCharCount",otherChar);
        //preparing a joint container
        StringBuilder stringBuilder=new StringBuilder();
        //beginning adding
        int bigCharResult=hashMap.get("bigCharCount");
        int smallCharResult=hashMap.get("smallCharCount");
        int numCountResult=hashMap.get("numCount");
        int otherCharResult=hashMap.get("otherCharCount");
        stringBuilder.append("{bigCharCount:"+bigCharResult+","+"smallCharCount:"+smallCharResult+","+"numCount:"+numCountResult+","+"otherCharCount:"+otherCharResult+"}");
        return stringBuilder;
    }
}
