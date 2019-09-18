package com.sc.test.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: cloud
 * @Date: 2019/2/18 18:05
 * @Version 1.0
 */
public class CompareTest {


    public static void main(String[] args) {
        System.out.println((52));
        Compare compare = new Compare(1,2,3);
        Compare compare1 = new Compare(1,2,4);
        Compare compare2 = new Compare(2,2,3);
        Compare compare3 = new Compare(1,3,3);
        List<Compare> list = new ArrayList<>();
        list.add(compare);
        list.add(compare1);
        list.add(compare2);
        list.add(compare3);

        System.out.println("之前:" + list);
        Collections.sort(list);
        System.out.println("之后:" + list);

        System.out.println(" 4: " + getNext(4, 0));

        List<Integer> integerList = new ArrayList<>(11);
        System.out.print(integerList + "  1长度:"+ integerList.size());
        integerList.add(1);
        integerList.add(2);
        StringBuilder sb = new StringBuilder();
        sb.append(integerList).append(" 长度:").append(integerList.size());
        System.out.println("before:" + sb);
        appendDesc(sb);
        System.out.println("after:" + sb);
    }

    public static int getNext(int num ,int sum) {
        if (num == 1) {
            return sum;
        } else {
            num -= 1;
            sum += num;
            return getNext(num,sum);
        }
    }

    public static void appendDesc(StringBuilder sb) {
        sb.append("我就是要添加的描述");
    }
}
