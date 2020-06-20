package com.Student1;

import com.Student1.Exception.Impl.StudentAgeExceptionImpl;
import com.Student1.Exception.Impl.StudentIdExceptionImpl;
import com.Student1.Exception.StudentAgeException;
import com.Student1.Exception.StudentIdExpection;
import com.netprogram.user.User;
import com.netprogram.user.UserMagger;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StudentMessage {
    public static void main(String[] args) {
        ArrayList<Student> arry = new ArrayList<>();
        ArrayList<Grade> arry0 = new ArrayList<>();
        ArrayList<Text> arry1= new ArrayList<>();
        while(true) {
            //这是成绩管理系统的主界面
            System.out.println("------学生管理系统------");
            System.out.println(" 1.登录");
            System.out.println(" 2.修改密码");
            System.out.println(" 3.开始考试");
            System.out.println(" 4.查询成绩");
            System.out.println(" 5.导出成绩");
            System.out.println(" 6.退出");
            Scanner sc =new Scanner(System.in);
            System.out.println("请输入序号选择相应的功能：");
            String stufunction = sc.nextLine();
            switch (stufunction) {
                case "1":
                    //登录
                    addstudent(arry);
                    break;
                case "2":
                    //修改密码
                    changestudent(arry);
                    break;
                case "3":
                    //开始考试
                    beginText(arry,arry0,arry1);
                    break;
                case "4":
                    //查询成绩
                    select(arry,arry0);
                    break;
                case "5":
                    //导出成绩
                    exportGrade(arry0);
                    break;
                case "6":
                    //退出
                    System.exit(0);//退出JVM
                    break;
                default:
                    System.out.println("谢谢你的使用.");
                    System.exit(0);//退出JVM
                    break;
            }
        }
    }
    //添加类
    public static void addstudent(ArrayList<Student> arry) {
        StudentIdExpection studentIdExpection=new StudentIdExceptionImpl();
        StudentAgeException studentAgeException=new StudentAgeExceptionImpl();
        //创建键盘录入对象
        Scanner sc= new Scanner(System.in);
        String stuId;
        while(true) {
            System.out.println("请输入学号(只能是数字)：");
            stuId = sc.nextLine();
            if (Integer.parseInt(stuId)<=0) {
                try {
                   studentIdExpection.StudentIdHanderException();
                } catch (StudentIdExceptionImpl ageException) {
                    System.out.println("学号不能为负");
                }
            }
            boolean flag = false;
            for(int i=0;i<arry.size();i++) {
                Student s = arry.get(i);
                if(s.getStdId().equals(stuId)) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                System.out.println("您输入的账号被占用！！！");
            }else {
                break;
            }
        }
        System.out.println("请输入姓名：");
        String name = sc.nextLine();
        System.out.println("请输入年龄：");
        String age = sc.nextLine();
        if (Integer.parseInt(age)<0) {
            try {
                studentAgeException.StudentAgeException();
            } catch (StudentAgeExceptionImpl ageException) {
                System.out.println("年龄不能为负");
            }
        }
        System.out.println("请输入密码：");
        String pass= sc.nextLine();
        //创建学生对象
        Student s = new Student();
        s.setStdId(stuId);
        s.setName(name);
        s.setPass(pass);
        //把学生对象添加到集合
        arry.add(s);
        System.out.println("登录成功！");
    }
    //修改类
    public static void changestudent(ArrayList<Student> arry) {
        StudentAgeException studentAgeException=new StudentAgeExceptionImpl();
        Scanner sc= new Scanner(System.in);
        System.out.print("请输入要改变的密码(只能是数字)：");
        String pass0=sc.nextLine();
        int index = -1;
        for(int i=0;i<arry.size();i++) {
            Student s = arry.get(i);
            if(s.getPass().equals(pass0)) {
                index = i;
            }
        }
        if (index==-1) {
            System.out.println("您要改变的学生不存在，请重新操作！");
        } else {
            System.out.println("请输入新姓名：");
            String name = sc.nextLine();
            System.out.println("请输入新学号：");
            String id= sc.nextLine();
            System.out.println("请输入新密码：");
            String pass=sc.nextLine();
            //创建学生对象
            Student s = new Student();
            s.setStdId(id);
            s.setName(name);
            s.setPass(pass);
            //修改学生对象
            arry.set(index,s);
            System.out.println("修改学生成功！！！");
        }
    }
    //开始考试
    public static void beginText(ArrayList<Student> arry,ArrayList<Grade> arry0, ArrayList<Text> arry1) {
        try {
            int index=-1;
            int temp=0;
            Grade grade=new Grade();
            System.out.println("请输入学号：");
            Scanner sc= new Scanner(System.in);
            String id= sc.nextLine();
            for(int i=0;i<arry.size();i++) {
                Student s = arry.get(i);
                if(s.getStdId().equals(id)) {
                    index=Integer.parseInt(s.getStdId());
                    temp=i;
                }
            }
            if (index==-1&&temp==0) {
                System.out.println("该学生无法参加考试，不存在");
            } else {
                String string=arry.get(temp).getName();
                Text text=new Text();
                text.setTextid();
                text.setTextoption();
                text.setAnswer();
                System.out.println(text.toString());
                System.out.println("请输入你的答案:");
                String answer=sc.nextLine();
                text.setYouranswer(answer);
                arry1.add(text);
                    //1.创建socker类型对象并提供服务器的主机名和端口号
                   Socket socket = new Socket("127.0.0.1",8181);
                //2. //2.使用输入输出流进行通信
                //构建输入流进行读取
                ObjectOutputStream objectOutputStream= new ObjectOutputStream(socket.getOutputStream());
                //发送
                objectOutputStream.writeObject(arry1);
                System.out.println("客户端发送内容成功!!!!");
                //3.创建输入流以读取字符串
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String s=bufferedReader.readLine();
                grade.setStdId(Integer.toString(temp));
                grade.setName(string);
                grade.setGrade(s);
                arry0.add(grade);

           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //查询学生信息及成绩成绩
        public static void select(ArrayList<Student> arry, ArrayList<Grade> arry0) {
                System.out.println("请输所查学号：");
                Scanner sc = new Scanner(System.in);
                String id0 = sc.nextLine();
                int index = -1;
                for (int i0 = 0; i0 < arry.size(); i0++) {
                    Student s = arry.get(i0);
                    if (s.getStdId().equals(id0)) {
                        index = Integer.parseInt(id0);
                    }
                }
                if (index == -1) {
                    System.out.println("该学生没有考试");
                } else {
                    for (Grade item : arry0) {
                        if (item.getStdId().toString().equals(Integer.toString(index))) {
                            System.out.println(item);
                        }
                    }

                }
            }
    //导出成绩
    public static void exportGrade(ArrayList<Grade> arry0){
        try {
            //1.创建socker类型对象并提供服务器的主机名和端口号
            Socket socket=new Socket("127.0.0.1",8888);
            //2.使用输入输出流进行通信
            //构建输入流进行读取
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(socket.getOutputStream());
            //发送
            objectOutputStream.writeObject(arry0);
            System.out.println("客户端发送内容成功!!!!");
            //3.创建输入流以读取字符串
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //4.读取
            String s=bufferedReader.readLine();
            System.out.println(s);
            if (s.contains("success")){
                System.out.println("成绩导出完毕");
            }else{
                System.out.println("失败");
            }
            //关闭输入流及输出流及客户端
            if (null!=objectOutputStream){objectOutputStream.close();}
            if (null!=socket){socket.close();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}