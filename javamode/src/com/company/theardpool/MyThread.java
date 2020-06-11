package com.company.theardpool;

import java.io.*;

public class MyThread implements Runnable {
    @Override
    public void run() {
        try {
            //准备缓冲区数组
            byte[] bytes=new byte[1024];
            int res=0;
            //读入到输入流
            FileInputStream fileInputStream=new FileInputStream("e:辞九门回忆-等什么君.mp3");
            //写入到输出流
            FileOutputStream fileOutputStream=new FileOutputStream("f:辞九门回忆-等什么.mp3");
            while((res=fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,res);
            }
            System.out.println("文件拷贝成功!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
