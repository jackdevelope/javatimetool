package com.company.playingcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DouDiZhu {
    public static void main(String[] args) {
                 //1. 组合牌
                 //创建Map集合,键是编号, 值是牌
            HashMap<Integer, String> pooker = new HashMap<Integer, String>();
                //创建List集合存储编号
                 List<Integer> pookerNum = new ArrayList<Integer>();
                 //创建花色数组
                 String[] colors = {"♥", "♣", "♠", "♦"};
                 //创建点数数组
                 String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
                 //定义整型数组，作为键出现
                int index = 2;
               //遍历数组：花色+点数进行组合，存储到Map集合中
                for(String number : numbers) {
                         for(String color : colors) {
                                 pooker.put(index, color + number);
                                pookerNum.add(index);
                                 index++;
                             }
                     }
                //存储大王、小王到Map集合中
                 pooker.put(0, "大王");
                 pookerNum.add(0);
                 pooker.put(1, "小王");
                 pookerNum.add(1);

                 //2. 洗牌,将牌的编号打乱
                 Collections.shuffle(pookerNum);

                 //3. 发牌
                 //定义三个玩家和底牌集合
                 List<Integer> play1 = new ArrayList<Integer>();
                 List<Integer> play2 = new ArrayList<Integer>();
                 List<Integer> play3 = new ArrayList<Integer>();
                 List<Integer> bottom = new ArrayList<Integer>();
                 for(int i = 0; i < pookerNum.size(); i++) {
                        //先存底牌
                         if(i < 3) {
                                 //存底牌
                                 bottom.add(pookerNum.get(i));
                                 //对索引%3判断
                             } else if(i % 3 == 0) {
                                 //发给玩家1
                                 play1.add(pookerNum.get(i));
                             } else if(i %3 == 1) {
                                 //发给玩家2
                                 play2.add(pookerNum.get(i));
                             } else if(i % 3 == 2) {
                                 //发给玩家3
                                 play3.add(pookerNum.get(i));
                             }
                    }
                //各个玩家的牌排序
                 Collections.sort(play1);
                 Collections.sort(play2);
                 Collections.sort(play3);

                 //4. 看牌
                 look("玩家1", play1, pooker);
                 look("玩家2", play2, pooker);
                 look("玩家3", play3, pooker);
                 look("底牌", bottom, pooker);


             }

             /**
       * 看牌的方法
       * 将玩家手中的编号，到Mpa集合中查找
       * @param name
      * @param play
       * @param pooker
              * */
             private static void look(String name, List<Integer> play, HashMap<Integer, String> pooker) {
                 //遍历ArrayList集合，获取元素，作为键到Map集合中查找
                 System.out.print(name + ":");
                 for(Integer key : play) {
                         String value = pooker.get(key);
                         System.out.print(value + " ");
                     }
                 System.out.println();
            }
}
