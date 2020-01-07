package com.sc.test.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: cloud
 * @Date: 2019/9/20 14:00
 * @Version 1.0
 */
@Data
@Component
public class RedisConfig {

    /**
     * 地址
     */
    @Value("${redis.ip}")
    private String ip = "";

    /**
     * 端口
     * */
    @Value("${redis.port}")
    private int port = 1;

    /**
     * 用户名
     * */
    @Value("${redis.username}")
    private String username = "";

    /**
     * 密码
     * */
    @Value("${redis.passWord}")
    private String passWord = "";
}
