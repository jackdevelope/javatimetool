package com.company.chessboard;

import java.util.Scanner;

public class BoardRun {
    public static void main(String[] args) {
        int flage0=0;
        int flage1=1;
        System.out.println("请输入你的棋子位置:");
        Scanner sc=new Scanner(System.in);
        int first=sc.nextInt();
        Scanner sc0=new Scanner(System.in);
        int secound=sc0.nextInt();
        ChessBoard cb=new ChessBoard();
        cb.initial(first,secound,flage0);
        System.out.println("请输入你的棋子位置:");
        Scanner sc1=new Scanner(System.in);
        int first0=sc1.nextInt();
        Scanner sc2=new Scanner(System.in);
        int secound0=sc2.nextInt();
        ChessBoard cb0=new ChessBoard();
        cb0.initial(first,secound,flage1);

    }
}
