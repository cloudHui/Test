package com.sc.test.study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @Author: cloud
 * @Date: 2018/12/26 15:08
 * @Version 1.0
 */
public class RandomTest {
    public static Random random = new Random();

    public static void main (String[] args){

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        Iterator<Integer> integerIterator = list.iterator();
        while (integerIterator.hasNext()) {
            list.remove(list.size() - 1);
        }
        System.out.println("数组长度:" + list.size());

        List<List<Integer>> listList = new ArrayList<>();
        for (List<Integer> list1 : listList) {
            System.out.print("  wqwe" + list1.get(0));
        }

        RandomTest randomTest = new RandomTest();
        double probability;
        double time = 10000;
        double times = 0;
        for (int i = 0 ; i < time ; i ++) {
            int value = random.nextInt((int)10000);
            if (value  <= 5000) {
                times ++;
            }
//            System.out.print(value + " ");
//            if (i % 11== 0 ) {
//                System.out.println();
//            }
        }
        System.out.println();
        probability = times /  time ;
        System.out.println("概率: " + probability);

        int id = 250014;
        String string = ",250013,250014,250015,250016,250017,250018,";
        if (string.contains("," + String.valueOf(id) + ",")) {
            System.out.print(string + " " + "包含");
        }

        int[] cards = new int[19];
        System.out.println("长度" + cards.length);
        System.out.println("之前");
        for (int i = 0 ; i < cards.length ;  i++) {
            cards[i] += 1;
            System.out.print(cards[i] +  "  ");
        }
        System.out.println();
        System.out.println("之后");
        randomTest.decrease(cards);
        for (int i = 0 ; i < cards.length ;  i++) {
            System.out.print(cards[i] +  "  ");
        }
    }

    public void decrease(int[] array){
        for (int i = 0 ; i < array.length ;  i++) {
            array[i] += 1;
        }
    }
}
