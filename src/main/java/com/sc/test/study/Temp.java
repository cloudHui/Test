package com.sc.test.study;

import com.alibaba.fastjson.JSONArray;
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

        System.out.println(String.format("%06d%01d%01d%02d", new Object[]{102001, 0, 3, 16}));

        String ip = CustomSystemUtil.INTERNET_IP;
        System.out.println("ip :" + ip);

        List<Integer> list = new ArrayList<>();
        for (int i = 9; i > 0; i--) {
            list.add(i);
        }

        System.out.println("余数" + (5 % 2));

        System.out.println("list:" + list);
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i + 3 <= list.size(); i += 3) {
            List<Integer> arrayList = list.subList(i, i + 3);
            System.out.print(arrayList + "  ");
            tmp.addAll(arrayList);
        }
        System.out.println("排序后");
        Collections.sort(list);
        for (int i = 0; i + 3 <= list.size(); i += 3) {
            List<Integer> arrayList = list.subList(i, i + 3);
            System.out.print(arrayList + "  ");
        }
        System.out.println();
        System.out.println("tmp:" + tmp);
        System.exit(0);
//        Map<String , Object> map = new HashMap<>();
//        map.put("name", null);
//        String nameMap = (String) map.get("name");
//        if (nameMap != null) {
//            System.out.println(nameMap);
//        }
//        List<Integer> testList = new ArrayList<>();
//        testList.add(121);
//        testList.add(12);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name", "张三");
//        jsonObject.put("sex", "male");
//        jsonObject.put("playerList",testList);
//        String jsonString = JSONObject.toJSONString(jsonObject);
//        StringBuilder stringBuilder = new StringBuilder();
//        JSONObject jsonObjectTest = JSONObject.parseObject(jsonString);
//        stringBuilder.append("name:").append(jsonObjectTest.getString("name"));
//        stringBuilder.append(",sex:").append(jsonObjectTest.getString("sex"));
//        stringBuilder.append(",name:").append(jsonObjectTest.getString("name"));
//        stringBuilder.append(",sex:").append(jsonObjectTest.getString("sex"));
//        stringBuilder.append(",name:").append(jsonObjectTest.getString("name"));
//        JSONArray jsonArray = jsonObject.getJSONArray("playerList");
//        jsonArray.subList(0,jsonArray.size());
//        jsonArray.size();
//        jsonObject.put("playerList",jsonArray);
//
//
//        StringBuilder sb = new StringBuilder("GameRuleParam{");
//        sb.append("subGameId=").append(1);
//        sb.append(", maxRound=").append(2);
//        sb.append(", maxPlayer=").append(3);
//        sb.append(", payType=").append(4);
//        sb.append(", gameType=").append(5);
//        sb.append('}');
//
//        String string = sb.toString();
//        String[] rules = string.substring(string.indexOf("{") + 1 , string.indexOf("}")).split(",");
//        for (String temp : rules){
//            System.out.print(Integer.parseInt(temp.substring(temp.indexOf("=") + 1 ))  + "   规则");
//        }
//
//        String arch = System.getProperty("sun.arch.data.model");
//        System.out.println(arch+"-bit");
//        List<Integer> list = new ArrayList<Integer>(20);
//        for (int i : list) {
//            System.out.print(i + " ");
//        }
//        HashMap<Integer ,String> tempMap = new HashMap<>();
//        tempMap.put(1,"1");
//        tempMap.put(2,"1");
//        tempMap.put(3,"1");
//        tempMap.put(4,"1");
//        tempMap.put(5,"2");
//        Iterator<Map.Entry<Integer,String>> iterator = tempMap.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<Integer,String> temp = iterator.next();
//            if ("1".equals(temp.getValue())) {
//                iterator.remove();
//            }
//        }
//
//
//        String u = "abc435345defsfsaf564565fsabad5467755fewfadfgea";
//        Matcher m = pattern.matcher(u);
//        int i = 0;
//        while (m.find()) {
//            System.out.println(m.group());
//            i++;
//        }
//        System.out.println(i);
//
//
//        List<Integer> list1 = new ArrayList<Integer>(108);
//        for (int j = 0; j < 108; j++) {
//            int num = new Random().nextInt(100);
//            list1.add(num);
//        }
//        Collections.shuffle(list1);
//        list1.forEach(e -> System.out.print(e + " "));
//        System.out.println();
//        long start = System.currentTimeMillis();
//        long end = System.currentTimeMillis();
//        System.out.println(String.format("直接排序耗时:%d ms", end - start));
//        list1.forEach(e -> System.out.print(e + " "));
//        System.out.println();
//        end = System.currentTimeMillis();
//        Collections.sort(list1);
//        long end1 = System.currentTimeMillis();
//        System.out.println(String.format("排序完成后再排序耗时:%d ms", end1 - end));
//        list1.forEach(e -> System.out.print(e + " "));
//        System.out.println();
//
//
//        int[] cardArray = {0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1,};
//        int[] t = Arrays.copyOfRange(cardArray, 2, 6);
//        System.out.print(t);
//        Temp temp1 = new Temp();
//        if (true) {
//            temp1.say();
//        }
//        System.out.print("走到了");
    }

    public void say() {
        if (1 > 0) {
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
