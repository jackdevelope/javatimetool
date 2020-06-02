package com.company.twoCharCompare;
import com.sun.source.tree.Tree;

import java.util.*;

public class ToolRealize extends MyTool{
    TreeSet<String> set=new TreeSet<>();
    private FindChar findChar;
    public FindChar getFindChar() {
        return findChar;
    }

    public void setFindChar(FindChar findChar) {
        this.findChar = findChar;
    }
    @Override
    TreeSet<String> firstHandle(String first0,String scound0) {
        int n=first0.length()-1;
        for (int i=n;i>=0;i--){
            char temp0=first0.charAt(i);
            String temp1=String.valueOf(temp0);
            this.setFindChar(new FindCharImpl().twoHandle(temp1,scound0));
        }
        this.set=FindCharImpl.set;
      //  System.out.println(set);
        return set;
    }
    @Override
    TreeSet<String> totalHandle(String total0, String total1) {
       // System.out.println(total0.equals(total1));
        if (total0.equals(total1)==false){
                if (total0.length()<total1.length()){
                     this.firstHandle(total0,total1);
                     return set;
                }else {

                }
        }
        return set;
    }
}
