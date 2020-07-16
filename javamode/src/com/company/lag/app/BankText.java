package com.lag.app;


import com.lag.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class BankText {
    public static void main(String[] args) {
        try {
            String regex="^[0-9]*$";

        //提供数据库池连接对象
        QueryRunner queryRunner=new QueryRunner(DruidUtils.getDataSource());
        //编写SQL
        //输入转出信息
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入当前卡号");
        String currcard=scanner.next();
        System.out.println("请输入转入卡号");
        String ordercard=scanner.next();
        System.out.println("请输入转入金额");
        String many=scanner.next();
        String current=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        List<String> list=new ArrayList<>();
        //编写占位符SQL
        String sql="select id,card,balance-? AS mynany FROM account WHERE card=?";
        String sql1="insert into transaction(cardid,tratype,tramoney,tradate) value(?,?,?,?)";
        String sql2="update account set balance=balance+? where card=?";
        String sql3="update account set balance=balance-? where card=?";
        //执行select方法
        List<Object[]> query=queryRunner.query(sql, new ArrayListHandler(),many,currcard);
        for (Object[] objects:query){
            //System.out.println();
           if(objects[2].toString().contains("-")){
                System.out.println("余额不足");
                System.exit(0);
            }else {
               List<Object> objects1=Arrays.asList(objects);
               ArrayList<Object> objects2=new ArrayList<>(objects1);
               Iterator<Object> iterator=objects2.iterator();
               while(iterator.hasNext()){
                   list.add(iterator.next().toString());
               }
               int temp=queryRunner.update(sql1,list.get(1), "转出", list.get(2), current);
               int temp8= queryRunner.update(sql1, ordercard, "转入", many, current);
               int temp0=queryRunner.update(sql2,many,ordercard);
               int temp1=queryRunner.update(sql3,many,currcard);
               System.out.println(temp);
               System.out.println(temp0);
               System.out.println(temp1);
               System.out.println(temp8);
               System.exit(0);
               //System.out.println(list.size());
               //System.out.println(list.get(1));
            }
        }

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
