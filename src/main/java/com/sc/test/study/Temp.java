package com.sc.test.study;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * * @author Cloud Liu
 *
 * @version 1.0
 * @date create time :2017年12月18日 上午8:24:00
 */

public class Temp {

    public static void main(String[] args) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
        try {
            Date endDate = dft.parse(dft.format(date.getTime()));
            System.out.println(dft.format(endDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = 1533617941451L;
       System.out.println(dft.format(new Date(time)) + " " + dft.format(1533617948730L));
        try {
            date.setTime(dft.parse("19761212"));
            System.out.print(date.getTimeInMillis() + "   " + new Date().getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int[] array = new int[10];
        for(int i = 0 ; i < 10 ; i++){
            array[i] = i;
        }
        List<Integer> list = new ArrayList<Integer>();
    }
}
