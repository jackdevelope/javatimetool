package com.company.numberChartime;

import java.util.*;

public class NumCharImpl implements NumChar{
    @Override
    public Map<String, String> find() {
        String[] split = myNum.split(regex);
        int n=split.length;
        for (int i=0;i<n;i++){
            String splitnum=split[i].toString();
            list.add(splitnum);
        }
        return  this.result(list);
        // System.out.println(list.size());
    }

    @Override
    public Map<String,String> result(List<String> list) {
        int mycount=0;
        int n=list.size();
        if (!list.isEmpty()){
            for (int i=0;i<n/2+1;i++){
                list0.add(list.get(i));
            }
            for (int j=n/2+1;j<n;j++){
                list1.add(list.get(j));
            }
            int m=list0.size();
            int e=list1.size();
            for (int a=0;a<m;a++){
                for (int b=0;b<e;b++){
                    if (list1.get(b).equals(list0.get(a))){
                       /* System.out.println(list1.get(a));
                        System.out.println(list1.get(b));*/
                        mycount++;
                       // System.out.println(mycount);
                        map.put(list1.get(b),"为"+String.valueOf(mycount)+"次");
                        map.put(list0.get(list0.size()-1),"为"+0+"次");
                    }
                }
                mycount=0;
            }

            //System.out.println(list0);
            //System.out.println(list1);

        }

        return map;
    }

}
