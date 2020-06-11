package com.company.netprogram;

import com.company.netprogram.user.UserMagger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {
    public static void main(String[] args) {
        try {
            String admin="admin";
            String pass="123456";
            //1.创建 ServerSocket类
            ServerSocket serverSocket=new ServerSocket(8888);
            //2.等待客户端的连接请求,调用accept
            System.out.println("等到客户端连接.....");
            Socket accept=serverSocket.accept();
            System.out.println("客户端连接成功!");
            //3.创建输入流以读取字符串
            ObjectInputStream ois = new ObjectInputStream(accept.getInputStream());
            //4.读取
            Object obj = ois.readObject();
            String s=obj.toString();
            //5.进行回发
            if (s.contains(admin)&&s.contains(pass)){
                //System.out.println(s);
               String success0=s.replace(s.substring(15, 19), "success");
                //System.out.println(success0);
                PrintStream printStream=new PrintStream(accept.getOutputStream());
                printStream.println(success0);
               // System.out.println("yes");
            }else {
                String success1=s.replace(s.substring(15, 19), "fail");
                PrintStream printStream=new PrintStream(accept.getOutputStream());
                printStream.println(success1);
            }
            //关闭输出流及输入流及连接及服务端
           // if (null!=printStream){printStream.close();}
            if (null!=ois){ois.close();}
            if (null!=accept){accept.close();}
            if (null!=serverSocket){serverSocket.close();}
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
