package com.company;

public class ChessBoard {
    //定义棋盘大小
    private static final int BOARD_SIZE=17;
    //定义一个二维数组来充当棋盘
    private static String[][] board;
    public static void initial() {

        //初始化棋盘数组
        board=new String[BOARD_SIZE][BOARD_SIZE];
        for (int i=0;i<BOARD_SIZE;i++){
            for (int j=0;j<BOARD_SIZE;j++){
                if (i==0&&j==0){
                    board[i][j]="  ";
                }
                else if (i==0||j==0){
                    if (i==0){
                        if (j==1){board[i][j]=" 0 ";}
                        if (j==2){board[i][j]=" 1 ";}
                        if (j==3){board[i][j]=" 2 ";}
                        if (j==4){board[i][j]=" 3 ";}
                        if (j==5){board[i][j]=" 4 ";}
                        if (j==6){board[i][j]=" 5 ";}
                        if (j==7){board[i][j]=" 6 ";}
                        if (j==8){board[i][j]=" 7 ";}
                        if (j==9){board[i][j]=" 8 ";}
                        if (j==10){board[i][j]=" 9 ";}
                        if (j==11){board[i][j]=" a ";}
                        if (j==12){board[i][j]=" b ";}
                        if (j==13){board[i][j]=" c ";}
                        if (j==14){board[i][j]=" d ";}
                        if (j==15){board[i][j]=" e ";}
                        if (j==16){board[i][j]=" f ";}
                    }else {
                        if (i==1){board[i][j]=" 0 ";}
                        if (i==2){board[i][j]=" 1 ";}
                        if (i==3){board[i][j]=" 2 ";}
                        if (i==4){board[i][j]=" 3 ";}
                        if (i==5){board[i][j]=" 4 ";}
                        if (i==6){board[i][j]=" 5 ";}
                        if (i==7){board[i][j]=" 6 ";}
                        if (i==8){board[i][j]=" 7 ";}
                        if (i==9){board[i][j]=" 8 ";}
                        if (i==10){board[i][j]=" 9 ";}
                        if (i==11){board[i][j]=" a ";}
                        if (i==12){board[i][j]=" b ";}
                        if (i==13){board[i][j]=" c ";}
                        if (i==14){board[i][j]=" d ";}
                        if (i==15){board[i][j]=" e ";}
                        if (i==16){board[i][j]=" f ";}
                    }
                }else {
                    board[i][j]=" + ";
                }
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }

    }
}
