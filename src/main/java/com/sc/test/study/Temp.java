package com.sc.test.study;

import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * * @author Cloud Liu
 *
 * @version 1.0
 * @date create time :2017年12月18日 上午8:24:00
 */

public class Temp {
    public static long currTimes;
    /**
     * 这个2是指连续数字的最少个数
     */
    public static Pattern pattern = Pattern.compile("\\d{2,}");
    ;

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("GameRuleParam{");
        sb.append("subGameId=").append(1);
        sb.append(", maxRound=").append(2);
        sb.append(", maxPlayer=").append(3);
        sb.append(", payType=").append(4);
        sb.append(", gameType=").append(5);
        sb.append('}');

        String string = sb.toString();
        String[] rules = string.substring(string.indexOf("{") + 1 , string.indexOf("}")).split(",");
        for (String temp : rules){
            System.out.print(Integer.parseInt(temp.substring(temp.indexOf("=") + 1 ))  + "   规则");
        }

        String arch = System.getProperty("sun.arch.data.model");
        System.out.println(arch+"-bit");
//        StringBuilder sb = new StringBuilder("GameRuleParam{");
//        sb.append("subGameId=").append(subGameId);
//        sb.append(", maxRound=").append(maxRound);
//        sb.append(", maxPlayer=").append(maxPlayer);
//        sb.append(", payType=").append(payType);
//        sb.append(", gameType=").append(gameType);
//        sb.append('}');

//       long currTime = System.currentTimeMillis();
//        for (int i = 0 ; i < 15; i++){
//            System.out.print(currTime + "    ");
//            sleep();
//            System.out.println(currTimes - currTime);
//            currTime = currTimes;
//        }
        List<Integer> list = new ArrayList<Integer>(20);
        for (int i : list) {
            System.out.print(i + " ");
        }
        HashMap<Integer ,String> tempMap = new HashMap<>();
        tempMap.put(1,"1");
        tempMap.put(2,"1");
        tempMap.put(3,"1");
        tempMap.put(4,"1");
        tempMap.put(5,"2");
        Iterator<Map.Entry<Integer,String>> iterator = tempMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> temp = iterator.next();
            if ("1".equals(temp.getValue())) {
                iterator.remove();
            }
        }


        String u = "abc435345defsfsaf564565fsabad5467755fewfadfgea";
        Matcher m = pattern.matcher(u);
        int i = 0;
        while (m.find()) {
            System.out.println(m.group());
            i++;
        }
        System.out.println(i);


        List<Integer> list1 = new ArrayList<Integer>(108);
        for (int j = 0; j < 108; j++) {
            int num = new Random().nextInt(100);
            list1.add(num);
        }
        Collections.shuffle(list1);
        list1.forEach(e -> System.out.print(e + " "));
        System.out.println();
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        System.out.println(String.format("直接排序耗时:%d ms", end - start));
        list1.forEach(e -> System.out.print(e + " "));
        System.out.println();
        end = System.currentTimeMillis();
        Collections.sort(list1);
        long end1 = System.currentTimeMillis();
        System.out.println(String.format("排序完成后再排序耗时:%d ms", end1 - end));
        list1.forEach(e -> System.out.print(e + " "));
        System.out.println();


        int[] cardArray = {0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1,};
        int[] t = Arrays.copyOfRange(cardArray, 2, 6);
        System.out.print(t);
        Temp temp1 = new Temp();
        if (true) {
            temp1.say();
        }
    }

    public void say() {
        if (1 > 0 ) {
            System.out.println("返回");
            return;
        }
        System.out.println("+++++++++++say");
    }

    public static void sleep() {
        try {
            Thread.sleep(1000);
            currTimes = System.currentTimeMillis();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
