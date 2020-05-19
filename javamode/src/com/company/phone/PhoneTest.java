package com.company.phone;

public class PhoneTest {
    public static void main(String[] args) {
        UserCostInfor uct=new UserCostInfor();
        uct.userShow();
        uct.showAll();
        uct.eachMonthCost();
        System.out.println("你的剩余金额为:"+uct.cal());

    }
}
