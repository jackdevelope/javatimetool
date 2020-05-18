package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class arrayadd {
    static final int ADD = 1;
    static final int DEL = 2;
    static final int QAL = 3;
    static final int QAD = 4;
    static final int UPD = 5;
    static final int EXIT = 6;

  // -- 被static修饰的只能访问static
    public static void main(String[] args) {
        // -- 设定前提不可以向数组中存放0. array[i] >= 1
        int[] array = { 1, 2, 3, 4, 5, 6, 0, 0, 0, 0 };
        Scanner scan = new Scanner(System.in);


        // Ctrl + Alt + down
        System.out.println("1.向数组中增加元素");
        System.out.println("2.从数组中删除元素");
        System.out.println("3.查询数组中全部元素");
        System.out.println("4.查询指定的元素");
        System.out.println("5.修改数组中指定元素");
        System.out.println("6.退出");


        // -- 实际已经存放的元素个数
        int count = 6;


        int num = 0;
        // -- 控制是否离开循环
        boolean isContiue = true;
        for (; isContiue;) {
            System.out.println("请输入要执行的操作:");
            // -- 接收键盘录入的选择
            int choose = scan.nextInt();
            // -- 通过switch对选择进行匹配
            switch (choose) {
                case ADD:
                    System.out.println("请输入要增加的元素");
                    // -- num接收键盘录入的用于增加的元素值.
                    num = scan.nextInt();
                    // -- 判断数组当前已经存放的元素个数是否达标整体的80%
                    if ((double) count / array.length >= 0.8) {
                        // -- 对数组做扩容处理
                        // -- 数组本身一旦声明长度是不可以变.所谓的扩容就是创建一个新数组
                        int[] temp = new int[(int) (array.length * 1.75)];
                        // -- 需要把原数组中的元素赋值到新数组中
                        for (int i = 0; i < count; i++) {
                            temp[i] = array[i];
                        }
                        // -- 把数组重新赋值给变量array
                        // -- temp和array在栈中,里面保存的是堆中数组的地址
                        // -- 把temp赋值给array等于把temp中所保存的数组地址赋值给arrya
                        // -- 赋值完成后array和temp拥有同一个数组的地址.
                        array = temp;
                    }
                    System.out.println("当前数组的长度是:\t" + array.length);
                    /*
                     * count 是已存放元素的个数 一个元素没有 count = 0 .新加入的元素下标是 0 有一个元素是 count = 1 .新加入的元素下标是 1
                     */
                    array[count] = num;
                    // -- 对count进行自增操作,上面添加元素成功,array中实际放入元素的总数量要加1.
                    count = count + 1;
                    break;
                case DEL:
                    // -- 从数组中删除元素
                    System.out.println("请输入要删除的元素");
                    // -- 录入要删除的元素
                    num = scan.nextInt();
                    // -- 判断该元素是否存在,如果遇到重复的元素只考虑第一个
                    boolean isSame = true;
                    for (int i = 0; i < count - 1; i++) {
                        // -- 对数组进行遍历.
                        if (num == array[i]) {
                            isSame = true;
                            // -- 删除;
                            array[i] = array[i + 1];
                            array[i + 1] = num;
                        } else {
                            isSame = false;
                        }
                    }
                    if (!isSame) {
                        System.out.println("你要删除的元素 不存在");
                    } else {
                        // -- 把实际存放的最后一个元素置0,否则最后一个元素会被多保存一遍.
                        array[count - 1] = 0;
                        // -- 删除成功后把总体个数减一
                        count = count - 1;
                        System.out.println("删除成功");
                    }
                case QAL:
                    // -- 查询数组中的全部实际存放元素
                    for (int i = 0; i < array.length && array[i] != 0; i++) {
                        System.out.print(array[i] + "\t");
                    }
                    System.out.println();
                    break;
                case EXIT:
                    isContiue = false;
                    break;
                default:
                    break;
            }
        }
    }
}
