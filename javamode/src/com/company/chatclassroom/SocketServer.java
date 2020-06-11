package com.company.chatclassroom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) {
        initServer();
    }

    private static void initServer() {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(8888);
            System.out.println("服务器正在运行...");
            for (;;) {
                Socket client = ss.accept();
                System.out.println("新客户端链接：" + client.getPort());
                new SocketThread(client).onStart();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    static class SocketThread extends Thread {
        private Socket socket;
        private boolean flag = true;

        public SocketThread(Socket socket) {
            this.socket = socket;
        }

        public void onStart() {
            this.start();
        }

        @Override
        public void run() {
            System.out.println("链接成功！");
            BufferedReader reader = null;
            BufferedWriter writer = null;
            try {
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                while (flag) {
                    String content = reader.readLine();
                    if (content == null || content.equals("bye")) {
                        flag = false;
                        System.out.println(socket.getPort() + "已经断开链接");
                    } else {
                        System.out.println("收到消息：" + content);
						/*writer.write("我收到了您的消息！ 在" + System.currentTimeMillis());
						writer.flush();*/
                        /***
                         * 文件传输处理
                         */
                        if (content.contains("filerequest")) {
                            int port = Integer.valueOf(content.split(":")[1]);
                            new FileThread(port).start();
                            System.out.println("文件传输端口已经启动");
                        }
                        /****/
                    }

                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println(socket.getPort() + "已经断开链接");
                flag = false;
            } finally {
                try {
                    reader.close();
                    writer.close();
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }

    /***
     * 文件传输监听线程
     */
    static class FileThread extends Thread {
        // 文件传输端口5002
        private ServerSocket fileSS;
        private int port;

        public FileThread(int port) {
            this.port = port;
        }

        @Override
        public void run() {
            DataInputStream dis = null;
            Socket socket = null;
            try {
                fileSS = new ServerSocket(port);
                socket = fileSS.accept();
                System.out.println("客户端已经链接文件服务");
                // 需要传输的文件 这里是我指定的，可以让客户端指定
                File file = new File("F:\\line.zip");
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dis = new DataInputStream(new FileInputStream(file));
                // 传送文件名字
                dos.writeUTF(file.getName());
                dos.flush();
                // 传送长度
                dos.writeLong(file.length());
                dos.flush();

                System.out.println("开始传送文件...(大小："+file.getTotalSpace()+")");
                // 传送文件
                int length = -1;// 读取到的文件长度
                byte[] buff = new byte[1024];
                // 循环读取文件，直到结束
                while ((length = dis.read(buff)) > 0) {
                    dos.write(buff, 0, length);
                    dos.flush();
                }
                System.out.println("传送文件完成");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭流
                    if (dis != null) {
                        dis.close();
                    }
                    //关闭客户端口
                    if (socket != null) {
                        socket.close();
                    }
                    // 关闭服务端口
                    if (fileSS != null) {
                        fileSS.close();
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }

}
