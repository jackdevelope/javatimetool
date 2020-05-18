package com.company.phone;

import java.util.Calendar;
import java.util.Date;

public class CellPhoneCard {
    enum PhoneCardInfor {
        //定义枚举
        bigCard("big"),mediumCard("small"),smallCard("minitype");
        //定义描述器
        private final String des;
        //私有化构造方法,只能在类内部
        private PhoneCardInfor(String des) {
            this.des=des;
        }
        //通过公有的get方法可以在本类的外部访问该类的成员变量
        public String getDes() {

            return des;
        }
    }
    private int cardId;      //卡id
    private String cardType; //卡类型
    private String userName; //用户姓名
    private String userPassword;  //用户密码
    private int accountLeftMoney;  //账户剩余金额
    private int cellMinute;        //通话时间
    private int netDataAmounts;    //上网流量
    public int getCardId() {
        return cardId;
    }
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;

    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getAccountLeftMoney() {
        return accountLeftMoney;
    }

    public void setAccountLeftMoney(int accountLeftMoney) {
        if (accountLeftMoney- UserCostInfor.count!=0){
        this.accountLeftMoney = accountLeftMoney-UserCostInfor.count;}
        else if (accountLeftMoney-UserCostInfor.count==0){
            this.accountLeftMoney=0;}
        else{
            this.accountLeftMoney=0;}
    }

    public int getCellMinute() {
        return cellMinute;
    }
    public void setCellMinute() {
        Date todaytime=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(todaytime);
        this.cellMinute=calendar.get(Calendar.MINUTE);
    }
    public int getNetDataAmounts() {
        return netDataAmounts;
    }

    public void setNetDataAmounts(int netDataAmounts) {
        this.netDataAmounts = netDataAmounts;
    }

    public void show(){
        StringBuffer gb=new StringBuffer();
        String result0="cardid:"+getCardId()+',';
        String result1="username:"+getUserName()+',';
        String result2="accountleftmoney:"+getAccountLeftMoney();
        gb.append(result0);
        gb.append(result1);
        gb.append(result2);
        System.out.println(gb);
    }
}
