package com.company.chatfile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {
    public static void main(String[] args) throws Exception {
        //创建服务端的Socket服务，指定端口号
        ServerSocket serverSocket=new ServerSocket(8888);

        while(true){
            //通过accept方法获取连接过来的Socket对象
            Socket socket=serverSocket.accept();
            new MyThread(socket).start();
        }

    }
}

class MyThread extends Thread{
    private Socket socket;

    public MyThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println(socket.getInetAddress().getHostAddress()+"上传文件");
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter =new PrintWriter(new FileOutputStream("f://"+System.currentTimeMillis()+".txt"),true);

            String line=null;
            while((line=bufferedReader.readLine())!=null){
                printWriter.println(line);
            }

            bufferedReader.close();
            printWriter.close();
            socket.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
