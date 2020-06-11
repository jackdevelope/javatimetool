package com.company.chatfile;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class UploadClient {

    public static void main(String[] args) throws Exception, IOException {
        //创建客户端的Socket服务，指定目的主机和端口号
        Socket socket=new Socket("127.0.0.1",8888);

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream("e://1.txt")));
        PrintWriter printWriter =new PrintWriter(socket.getOutputStream(),true);

        String line=null;
        while((line=bufferedReader.readLine())!=null){
            printWriter.println(line);
        }
        bufferedReader.close();
        printWriter.close();
        socket.close();
    }
}
