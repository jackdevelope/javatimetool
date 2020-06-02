package com.company.charCalculate;

public class UseFindImpl implements MyChara{
    private String bigCharRegex="[A-Z]";
    private String smallCharRegex="[a-z]";
    private String numRegex="[0-9]";
    @Override
    public StringBuilder find() {
        UseFindImpl usf=new UseFindImpl();
        int bigCharCount=0;
        int smallCharCount=0;
        int numCount=0;
        int otherCount=0;
        for (int i=0;i<str.length();i++){
            char signalChar=str.charAt(i);
            String s=String.valueOf(signalChar);
            if (s.matches(bigCharRegex)){
                bigCharCount+=1;
            }else if(s.matches(smallCharRegex)){
                smallCharCount+=1;
            }else if (s.matches(numRegex)){
                numCount+=1;
            }else{
                otherCount+=1;
            }
        }
        StringBuilder reult=usf.record(bigCharCount,smallCharCount,numCount,otherCount);
        return reult;
    }

}
