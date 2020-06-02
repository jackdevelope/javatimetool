package com.company.twoCharCompare;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FindCharImpl implements FindChar{
    private FindChar FindChar;
    static TreeSet<String> set=new TreeSet<>();
    @Override
    public FindChar twoHandle(String first2, String scound2) {
        String temp1=first2;
        String temp0=scound2;
        for (int i=0;i<temp0.length();i++){
            char temp=temp0.charAt(i);
            String te=String.valueOf(temp);
            if (te.equals(temp1)){

                set.add(te);
              // System.out.println(set);

            }
        }
        return FindChar;
    }
}
