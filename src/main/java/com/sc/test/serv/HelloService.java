package com.sc.test.serv;

import com.sc.test.inter.HelloWorld;

/**
 * @Author: cloud
 * @Date: 2019/2/11 15:31
 * @Version 1.0
 */
public class HelloService {

    private HelloWorld helloWorld;


    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }
}
