package com.company.charCalculate;

public class CharText {
    public static void main(String[] args) {
        MyChara useFind=new UseFindImpl();
        StringBuilder stringBuilder = useFind.find();
        System.out.println(stringBuilder);
    }
}
