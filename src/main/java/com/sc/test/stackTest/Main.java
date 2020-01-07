package com.sc.test.stackTest;

public class Main {

    public static void main(String[] args) throws Exception {
//        new Runtime().addShutdownHook(new MyHook());
        System.out.println("结束吧");
    }

    public static class MyHook extends Thread {
        @Override
        public void run() {
            System.out.println("你先走，我垫后");
        }
    }
}