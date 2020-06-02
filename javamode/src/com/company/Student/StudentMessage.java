package com.company.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMessage {
    public static void main(String[] args) {
        ArrayList<Student> arry = new ArrayList<>();
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
        //创建键盘录入对象
        Scanner sc= new Scanner(System.in);
        String stuId;
        while(true) {
            System.out.println("请输入学号：");
            stuId = sc.nextLine();
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
        System.out.print("请输入要删除的学号：");
        String deleId = sc.nextLine();
        int index = -1;
        for(int i=0;i<arry.size();i++) {
            Student s = arry.get(i);
            if(s.getStdId().equals(deleId)) {
                index=i;
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
        Scanner sc= new Scanner(System.in);
        System.out.print("请输入要改变的学号：");
        String changeId = sc.nextLine();
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
}
