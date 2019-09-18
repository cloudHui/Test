package com.sc.test.imp;

import com.sc.test.inter.HelloWorld;

/**
 * @Author: cloud
 * @Date: 2019/2/11 15:30
 * @Version 1.0
 */
public class TwoHello implements HelloWorld {
    @Override
    public void sayHello() {
        System.out.println("Two Say Hello" + this.getClass().getSimpleName());
    }
}
