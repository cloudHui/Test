package com.sc.test.imp;

import com.sc.test.inter.HelloWorld;

/**
 * @Author: cloud
 * @Date: 2019/2/11 15:29
 * @Version 1.0
 */
public class OneHello implements HelloWorld {
    @Override
    public void sayHello() {
        System.out.println("One Say Hello" + this.getClass().getSimpleName());
    }
}
