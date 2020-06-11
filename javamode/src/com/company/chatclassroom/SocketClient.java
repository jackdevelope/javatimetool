package com.company.chatclassroom;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {

    public static void main(String[] args) {
        initClient();
    }

    private static void initClient() {
        try {
            boolean flag = true;
            Socket socket = new Socket("127.0.0.1",8888);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os,"UTF-8"), true);
            Scanner scanner = new Scanner(System.in);
            while (flag) {
                String content = scanner.next();
                System.out.println("client 等待用户输入：");
                writer.println(content + ":" + System.currentTimeMillis());
                /**
                 * 文件接收线程
                 */
                if (content.contains("filerequest")) {
                    int port = Integer.valueOf(content.split(":")[1]);
                    new FileThread(port).start();
                    System.out.println("接收文件线程已经启动");
                }
            }
            scanner.close();
            reader.close();
            writer.close();
            socket.close();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /***
     * 文件传输监听线程
     */
    static class FileThread extends Thread {
        private int port;

        public FileThread(int port) {
            this.port = port;
        }

        @Override
        public void run() {
            Socket socket = null;
            DataOutputStream dos = null;
            try {
                socket = new Socket("127.0.0.1",8888);
                System.out.println("客户端已经链接文件服务");
                // 需要传输的文件 这里是我指定的，可以让客户端指定
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                //获取服务器传过来的文件名字
                File file = new File("G:\\"+dis.readUTF());
                //获取服务器传过来的文件大小
                double totleLength = dis.readLong();
                dos = new DataOutputStream(new FileOutputStream(file));
                //开始接收文件
                System.out.println("开始接收："+totleLength);
                int length=-1;
                byte[] buff= new byte[1024];
                double curLength = 0;
                while((length=dis.read(buff))>0){
                    dos.write(buff, 0, length);
                    curLength+=length;
                    //System.out.println("传输进度："+(curLength/totleLength*100)+"%");
                    System.out.println("传输进度："+(curLength/totleLength*100)+"%");
                }
                dos.flush();
                System.out.println("接收文件完成");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭流
                    if (dos != null) {
                        dos.close();
                    }
                    //关闭客户端口
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }

}
