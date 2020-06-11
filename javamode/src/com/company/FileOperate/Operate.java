package com.company.FileOperate;

import java.io.File;

public class Operate {
    public static void main(String[] args) {
        File delfile=new File("e:\\kk");
        File[] files=delfile.listFiles();
        for(int i=0;i<files.length;i++){
            if(files[i].isDirectory()){
                files[i].delete();
            }
         }
        System.out.println("子目录删除成功！");
        delfile.delete();
        System.out.println("根目录删除成功！");
    }
}
