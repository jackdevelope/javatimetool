package com.Student1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ExportResult {
    public static void main(String[] args) {
        try {
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
            File file = new File("e:/a.txt");
            PrintStream ps = new PrintStream(new FileOutputStream(file,true));
            ps.append(s);
        //5.进行回发
            String success="success";
            //System.out.println(success0);
            PrintStream printStream=new PrintStream(accept.getOutputStream());
            printStream.println(success);
            // System.out.println("yes");
            if (null!=ois){ois.close();}
            if (null!=accept){accept.close();}
            if (null!=serverSocket){serverSocket.close();}
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
