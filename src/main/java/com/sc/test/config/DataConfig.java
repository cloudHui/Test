package com.sc.test.config;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author: cloud
 * @Date: 2019/9/18 15:56
 * @Version 1.0
 */
@Data
@XmlRootElement(name = "DataConfig")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataConfig {

    @XmlElements(value = { @XmlElement (name="DataConf")})
    private List<DataConf> dataConf;

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class DataConf {
        /**
         * 地址
         * */
        @XmlElement(name = "Ip")
        private int ip = 1;

        /**
         * 端口
         * */
        @XmlElement(name = "Port")
        private int port = 1;

        /**
         * 用户名
         * */
        @XmlElement(name = "Username")
        private String username = "";

        /**
         * 密码
         * */
        @XmlElement(name = "PassWord")
        private String passWord = "";
    }
}
