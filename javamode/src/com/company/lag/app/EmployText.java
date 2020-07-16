package com.lag.app;

import com.lag.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class EmployText {
    public static void main(String[] args) {
        try {
            List<String> list=new ArrayList<>();
            //1.获取连接
            Connection con = DruidUtils.getConnection();
            //编写SQL
            //编写占位符SQL,获取预处理对象
            String sql="SELECT * FROM employee WHERE did!=0";
            String sql1="SELECT NAME,salary,did FROM employee";
            PreparedStatement ps=con.prepareStatement(sql);
            PreparedStatement ps0=con.prepareStatement(sql1);
            //获取数据
            ResultSet resultSet=ps.executeQuery();
            ResultSet resultSet1=ps0.executeQuery();
            System.out.println("查询所有的员工信息 (不包含没有部门的员工):");
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("NAME");
                Double age=resultSet.getDouble("age");
                String sex=resultSet.getString("sex");
                Double salary=resultSet.getDouble("salary");
                Date empdate=resultSet.getDate("empdate");
                int did=resultSet.getInt("did");
                System.out.println("id:"+id+" 姓名："+name+" 年龄："+age+" 性别: "+sex+" 薪资: "+salary+" 入职日期: "+empdate+" 所属部门: "+did);
            }
            System.out.println("查询每个员工的 姓名, 薪资 和 所属部门名称:");
            while(resultSet1.next()){
                String name =resultSet1.getString("name");
                Double salary=resultSet1.getDouble("salary");
                int did=resultSet1.getInt("did");
                System.out.println("姓名："+name+" 薪资: "+salary+" 所属部门: "+did);
            }
             //释放资源
             DruidUtils.close(con,ps,resultSet);
            DruidUtils.close(con,ps,resultSet1);
          } catch (SQLException e) {
            e.printStackTrace();
           }
    }
}
