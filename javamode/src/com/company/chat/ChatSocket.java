package com.company.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/*使用socket获得数据流，达到传输数据的目的*/
public class ChatSocket implements Runnable{
    private Socket socket = null;
    private DataInputStream inputStream = null;
    private DataOutputStream outputStream = null;

    public DataInputStream getInputStream() {
        return inputStream;
    }

    public DataOutputStream getOutputStream() {
        return outputStream;
    }

    public ChatSocket(Socket socket) {
        this.socket = socket;
        try {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void send(String send) { //向客户端发送数据
        try {
            outputStream.writeUTF(send);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() { //循环读取客户端发来的数据
        String accept = null;

        while (true) {
            try {
                accept = inputStream.readUTF();

                ClientMannager.sendAll(this, accept);
            } catch (IOException e) {
                ClientMannager.sockets.remove(this);
            }
        }
    }
}
