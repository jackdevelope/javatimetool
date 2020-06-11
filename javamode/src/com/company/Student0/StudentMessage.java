package com.company.Student0;

import com.company.Student0.Exception.Impl.StudentAgeExceptionImpl;
import com.company.Student0.Exception.Impl.StudentIdExceptionImpl;
import com.company.Student0.Exception.StudentAgeException;
import com.company.Student0.Exception.StudentIdExpection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMessage {
    public static void main(String[] args) {
        ArrayList<Student> arry = new ArrayList<>();
        //启动时读取文件
        readFile();
        while(true) {
            //这是成绩管理系统的主界面
            System.out.println("------学生管理系统------");
            System.out.println(" 1.查看所有学生");
            System.out.println(" 2.增加学生");
            System.out.println(" 3.删除学生");
            System.out.println(" 4.修改学生");
            System.out.println(" 5.退出");
            Scanner sc =new Scanner(System.in);
            System.out.println("请输入序号选择相应的功能：");
            String stufunction = sc.nextLine();
            switch (stufunction) {
                case "1":
                    //查看所有学生
                    findstudent(arry);
                    break;
                case "2":
                    //增加学生
                    addstudent(arry);
                    break;
                case "3":
                    //删除学生
                    deletestudent(arry);
                    break;
                case "4":
                    //修改学生
                    changestudent(arry);
                    break;
                case "5":
                    //退出
                default:
                    System.out.println("谢谢你的使用.");
                    writeFile(arry);
                    System.exit(0);//退出JVM
                    break;
            }
        }
    }
    //查找类
    public static void findstudent(ArrayList<Student> arry) {
        if(arry.size()==0) {
            System.out.println("不好意思，目前还没有学生的信息可供查询，请返回重新操作！");
            return;
        }
        System.out.println("学号\t姓名\t年龄\t居住地");
        for(int i=0;i<arry.size();i++) {
            Student s = arry.get(i);
            System.out.println(s.getStdId()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getPlace());
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
        System.out.println("请输入居住地：");
        String place = sc.nextLine();
        //创建学生对象
        Student s = new Student();
        s.setStdId(stuId);
        s.setName(name);
        s.setAge(age);
        s.setPlace(place);
        //把学生对象添加到集合
        arry.add(s);
        System.out.println("添加学生成功！");
    }
    //删除类
    public static void deletestudent(ArrayList<Student> arry) {
            Scanner sc= new Scanner(System.in);
            System.out.print("请输入要删除的学号(只能是数字)：");
            String deleId = sc.nextLine();
            int index = -1;
            for(int i=0;i<arry.size();i++) {
                Student s = arry.get(i);
                if (s.getStdId().equals(deleId)) {
                    index = i;
                }
                if (index == -1) {
                    System.out.println("你要删除的学生不存在，请重新选择！");
                } else {
                    arry.remove(index);
                    System.out.println("删除学生成功！！");
                }
            }
    }
    //修改类
    public static void changestudent(ArrayList<Student> arry) {
        StudentIdExpection studentIdExpection=new StudentIdExceptionImpl();
        StudentAgeException studentAgeException=new StudentAgeExceptionImpl();
        Scanner sc= new Scanner(System.in);
        System.out.print("请输入要改变的学号(只能是数字)：");
        String changeId = sc.nextLine();
        if (Integer.parseInt(changeId)<=0) {
            try {
                studentIdExpection.StudentIdHanderException();
            } catch (StudentIdExceptionImpl ageException) {
                System.out.println("学号不能为负");
            }
        }
        int index = -1;
        for(int i=0;i<arry.size();i++) {
            Student s = arry.get(i);
            if(s.getStdId().equals(changeId)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("您要改变的学生不存在，请重新操作！");
        } else {
            System.out.println("请输入新姓名：");
            String name = sc.nextLine();
            System.out.println("请输入新年龄：");
            String age = sc.nextLine();
            if (Integer.parseInt(age)<0) {
                try {
                    studentAgeException.StudentAgeException();
                } catch (StudentAgeExceptionImpl ageException) {
                    System.out.println("年龄不能为负");
                }
            }
            System.out.println("请输入新居住地：");
            String place = sc.nextLine();
            //创建学生对象
            Student s = new Student();
            s.setStdId(changeId);
            s.setName(name);
            s.setAge(age);
            s.setPlace(place);
            //修改学生对象
            arry.set(index,s);
            System.out.println("修改学生成功！！！");
        }
    }
    //文件写入
    public static void writeFile(ArrayList<Student> arry) {
        FileWriter  fw = null;
        try {
            fw = new FileWriter("e:file01.txt",true);
            String s = arry.toString();
            fw.write(s);
            fw.write("\r\n");
            //关闭流
            if(null!=fw){
                try {
                    fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFile(){
        List<String> list=new ArrayList<>();
        String regex="[^},]+";
        String regex0="[^}]]+";
        try {
            StringBuilder stringBuilder=new StringBuilder();
            File file=new File("e:file01.txt");
          if (file.exists()){
            FileReader fileReader= null;
            fileReader = new FileReader(file);
            int res=0;
            while ((res=fileReader.read())!=-1){
              stringBuilder.append((char)res);
            }
             // System.out.println(stringBuilder);
              stringBuilder.delete(0,4);
              //System.out.println(stringBuilder);
              String s=stringBuilder.toString();
              list.add(s);
              System.out.println("正在从文件读取过去的学生信息");
              System.out.println(list);
              //if (s.split(regex)||s.split(regex0))

          }else {
            System.out.println("No file,Don't Read!");
          }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}