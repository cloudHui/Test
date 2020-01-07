package com.sc.test.stackTest;

import java.text.MessageFormat;

/**
 * @Author: cloud
 * @Date: 2019/9/28 11:37
 * @Version 1.0
 */
public class StackTest {

    public static void main(String [] args) {
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        if(st==null){
            System.out.println("无堆栈...");
            return;
        }
        StringBuffer sbf =new StringBuffer();
        for(StackTraceElement e:st){
            if(sbf.length()>0){
                sbf.append(" <- ");
                sbf.append(System.getProperty("line.separator"));
            }
            sbf.append(MessageFormat.format("{0}.{1}() {2}"
                    ,e.getClassName()
                    ,e.getMethodName()
                    ,e.getLineNumber()));
        }
        System.out.println(sbf.toString());
    }
}
