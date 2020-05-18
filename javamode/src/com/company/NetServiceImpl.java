package com.company.phone;

public class NetServiceImpl implements NetService{
    private  static final int netFlow=20;
    private  static final int eachMonthCost=30;
    @Override
    public void myNetMeal() {
        System.out.println("上网流量:"+netFlow);
        System.out.println("每月资费:"+eachMonthCost);
    }
    public int netCost(){
        int netcost=netFlow*eachMonthCost;
        return netcost;
    }
}
