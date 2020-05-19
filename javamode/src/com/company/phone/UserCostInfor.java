package com.company.phone;

import com.company.phone.*;

import java.util.Random;
import java.util.Scanner;

public class UserCostInfor extends Calculate{
      private int cellMinute;
      private int  myNetFlow;
      private int  eachMonthCost;
      private CellService cellService;
      private NetService netService;
      public static int count;

    CellPhoneCard cpc=new CellPhoneCard();
    public int getCellMinute() {
        return cellMinute;
    }

    public void setCellMinute(int cellMinute) {
        this.cellMinute = cellMinute;
    }

    public int getMyNetFlow() {
        return myNetFlow;
    }

    public void setMyNetFlow(int myNetFlow) {
        this.myNetFlow = myNetFlow;
    }

    public int getEachMonthCost() {
        return eachMonthCost;
    }

    public void setEachMonthCost(int eachMonthCost) {
        this.eachMonthCost = eachMonthCost;
    }

    public CellService getCellService() {
        return cellService;
    }

    public void setCellService(CellService cellService) {
        this.cellService = cellService;
    }

    public NetService getNetService() {
        return netService;
    }

    public void setNetService(NetService netService) {
        this.netService = netService;
    }

    //用户信息
    public void userShow(){
        System.out.println("请输入当前用户名:");
        Scanner sc=new Scanner(System.in);
        String username=sc.next();
        cpc.setUserName(username);
        System.out.println("请输入当前用户密码:");
        Scanner sc0=new Scanner(System.in);
        String userpassword=sc0.next();
        cpc.setUserPassword(userpassword);
        //卡号
        Random random = new Random();
        int cardid=random.nextInt();
        cpc.setCardId(cardid);
        System.out.println("请输入你的卡类型:1.bigCard 2.mediumCard 3.smallCard");
        Scanner sc1=new Scanner(System.in);
        int cardtype=sc1.nextInt();
        if (cardtype==1){
            cpc.setCardType(CellPhoneCard.PhoneCardInfor.bigCard.getDes());

        }
        else if (cardtype==2){
            cpc.setCardType(CellPhoneCard.PhoneCardInfor.mediumCard.getDes());
        }
        else if (cardtype==3){
            cpc.setCardType(CellPhoneCard.PhoneCardInfor.smallCard.getDes());
        }
        else {
            System.out.println("Don't this type!");
        }
        System.out.println("请输入你账户金额:");
        Scanner sc2=new Scanner(System.in);
        int account=sc2.nextInt();
        cpc.setAccountLeftMoney(account);

    }

    //统计通话时长
    public void myCellMinute(){

          int cellMinute=cpc.getCellMinute();
          setCellMinute(cellMinute);
    }
    //统计上网流量
    public void myNetFlow(){

        int net=cpc.getCellMinute()*5;
        setCellMinute(cellMinute);
    }
    //每月消费金额:上网流量的资费+通话时长的资费
    public void eachMonthCost(){
        int cell=new CellServiceImpl().cellCost();
        int net=new NetServiceImpl().netCost();
        count=cell+net;
        System.out.println("每月消费金额"+count);
    }
    public void showAll(){
        cpc.show();
        System.out.println("当前卡的类型为:"+cpc.getCardType());
        new CellServiceImpl().myCellMeal();
        new NetServiceImpl().myNetMeal();
    }
    @Override
    public int cal() {
        if (cpc.getAccountLeftMoney()-count!= 0) {
            return cpc.getAccountLeftMoney()-count;
        } else if (cpc.getAccountLeftMoney()-count== 0) {
            return 0;
        } else {
            return 0;
        }
     }
    }


