package com.sc.test.imp;

import com.sc.test.config.RedisConfig;
import com.sc.test.inter.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: cloud
 * @Date: 2019/2/11 15:29
 * @Version 1.0
 */
public class OneHello implements HelloWorld {


    @Autowired
    private RedisConfig redisConfig;

    @Override
    public void sayHello() {
        System.out.println("One Say Hello" + this.getClass().getSimpleName());
    }
}
