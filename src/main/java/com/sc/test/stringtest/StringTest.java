package com.sc.test.stringtest;

import java.util.*;

/**
 * @Author: cloud
 * @Date: 2019/3/15 14:08
 * @Version 1.0
 */
public class StringTest {

    public static void main(String[] args){
        Map<String, String> map = new HashMap<>(4,0.5f);

        if ("false".equalsIgnoreCase(null)) {

        }

        String[] payTypes = { "0", "1", "2","6"};
        String[] playerCounts = { "2", "3", "4","5","6" };
        // 参与人数
        String[] roundCounts = { "08", "09","10", "16","18", "20","36" };
        // 局数
        List<String> integerList = new ArrayList<>();
        for (String payType : payTypes) {
            for (String playerCount : playerCounts) {
                for (String roundCount : roundCounts) {
                    integerList.add((payType + playerCount + roundCount));
                }
            }
        }

        integerList.forEach((i) -> System.out.print(" " + i));
        System.out.println();

        String subGameIds = "201101,201201,201301";
        String s  = ",";
        for (String subGameIdStr : subGameIds.split(s)) {
            System.out.println(subGameIdStr);
        }


        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        List<Integer> integerss = new ArrayList<>();
        integerss.add(1);
        integerss.add(2);
        System.out.println(integers);
        System.out.println(integerss);
        integers.removeAll(integerss);
        System.out.println(integers);
    }
}
