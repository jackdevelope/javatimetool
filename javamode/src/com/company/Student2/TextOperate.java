package com.Student1;

import com.Student1.Text;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TextOperate {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(8181);
            //2.等待客户端的连接请求,调用accept
            System.out.println("等到客户端连接.....");
            Socket accept=serverSocket.accept();
            System.out.println("客户端连接成功!");
            //3.创建输入流以读取字符串
            ObjectInputStream ois = new ObjectInputStream(accept.getInputStream());
            //4.读取
            Object o=ois.readObject();
            if (o.equals(new Text())){
                System.out.println("不及格！");
                //5.进行回发
                String grade="50";
                //System.out.println(success0);
                PrintStream printStream=new PrintStream(accept.getOutputStream());
                printStream.println(grade);
            } else {
                System.out.println("及格！");
                //5.进行回发
                String grade="80";
                //System.out.println(success0);
                PrintStream printStream=new PrintStream(accept.getOutputStream());
                printStream.println(grade);
            }
            // System.out.println("yes");
            if (null!=serverSocket){serverSocket.close();}
            if (null!=ois){ois.close();}
            if (null!=accept){accept.close();}
            if (null!=serverSocket){serverSocket.close();}
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
