package com.sc.test.date;

import com.alibaba.fastjson.JSONObject;
import com.sc.test.playback.GameBackCards;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * @Author: cloud
 * @Date: 2019/2/21 16:06
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) throws IOException {
        GameBackCards backCards = new GameBackCards();
        backCards.setRoomId(1111);
        String back = JSONObject.toJSONString(backCards);
        String back1 = backCards.toString();
        Random random = new Random();
        System.out.print(back + " " + backCards + " " + back1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            int value = random.nextInt();
            sb.append(i).append(" : ").append(value).append(" ");
        }
        System.out.print(sb);


    }
}
