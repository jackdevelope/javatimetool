package com.lag.app;

import com.lag.utils.DruidUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class PriceText{
    public static void main(String[] args) {
        try {
            List<String> list=new ArrayList<>();
            //1.获取连接
            Connection con = DruidUtils.getConnection();
            //编写SQL
            //编写占位符SQL,获取预处理对象
            String sql="SELECT * FROM phone WHERE price>2000 AND prodate<'2019-1-1'";
            String sql1="SELECT * FROM phone WHERE color='白色'";
            PreparedStatement ps=con.prepareStatement(sql);
            PreparedStatement ps0=con.prepareStatement(sql1);
            //获取数据
            ResultSet resultSet=ps.executeQuery();
            ResultSet resultSet1=ps0.executeQuery();
            System.out.println("查询价格高于2000元，生产日期是2019年之前的所有手机:");
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String pname=resultSet.getString("pname");
                Double price=resultSet.getDouble("price");
                Date prodate=resultSet.getDate("prodate");
                String color=resultSet.getString("color");
                System.out.println("id:"+id+" 手机名："+pname+" 价格："+price+" 日期: "+prodate+" 颜色: "+color);
            }
            System.out.println("查询所有颜色是白色的手机信息:");
            while(resultSet1.next()){
                int id=resultSet1.getInt("id");
                String pname=resultSet1.getString("pname");
                Double price=resultSet1.getDouble("price");
                Date prodate=resultSet1.getDate("prodate");
                String color=resultSet1.getString("color");
                System.out.println("id:"+id+" 手机名："+pname+" 价格："+price+" 日期: "+prodate+" 颜色: "+color);
            }
            //释放资源
            DruidUtils.close(con,ps,resultSet);
            DruidUtils.close(con,ps,resultSet1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

