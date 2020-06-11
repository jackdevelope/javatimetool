package com.company.netprogram;

import com.company.netprogram.user.User;
import com.company.netprogram.user.UserMagger;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String success="success";
        String fail="fail";
        try {
            Scanner scanner=new Scanner(System.in);
            System.out.println("PLease Input username:");
            String next=scanner.next();
            System.out.println("PLease Input pass:");
            String next1=scanner.next();
            UserMagger userMagger=new UserMagger();
            User user=new User();
            userMagger.setTy("temp");
            user.setUsername(next);
            user.setPass(next1);
            userMagger.setUser(user);
            //1.创建socker类型对象并提供服务器的主机名和端口号
            Socket socket=new Socket("127.0.0.1",8888);
            //2.使用输入输出流进行通信
            //构建输入流进行读取
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(socket.getOutputStream());
            //发送
            objectOutputStream.writeObject(userMagger);
            System.out.println("客户端发送内容成功!!!!");
           //3.创建输入流以读取字符串
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //4.读取
            String s=bufferedReader.readLine();
            System.out.println("接收到的内容为:"+s);
            if (s.contains(success)){
                userMagger.setTy(success);
                System.out.println("你已经登录");
                System.out.println("当前信息为:"+s);
            }else if (s.contains(fail)){
                userMagger.setTy(fail);
                System.out.println("登录失败");
                System.out.println("当前信息为:"+s);
            }
            //关闭输入流及输出流及客户端
            if (null!=scanner){scanner.close();}
            if (null!=objectOutputStream){objectOutputStream.close();}
            if (null!=socket){socket.close();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
