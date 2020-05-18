package com;
import redis.clients.jedis.*;

import java.net.*;

public class Db {
    private static Jedis jd;
    public void setvalue(int cardid,String username,int accountleftmoney) {
        //连接本地的redis服务
        jd=new Jedis("localhost");
        System.out.println("successfully!");
        //查看服务器是否允许
        System.out.println("服务器正在运行:"+jd.ping());
        //设置 redis 字符串数据
        jd.set("cardid", String.valueOf(cardid));
        jd.set("username",username);
        jd.set("accountleftmoney", String.valueOf(accountleftmoney));
    }
    public void getvalue() {
        //连接本地的redis服务
        jd=new Jedis("localhost");
        System.out.println("successfully!");
        //查看服务器是否允许
        System.out.println("服务器正在运行:"+jd.ping());
        //设置 redis 字符串数据
        System.out.println(jd.get("cardid"));

    }
}
