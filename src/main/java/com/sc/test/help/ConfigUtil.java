package com.sc.test.help;

import javax.xml.bind.JAXBContext;
import java.io.File;

/**
 * @Author: cloud
 * @Date: 2019/9/18 15:50
 * @Version 1.0
 */
public class ConfigUtil {

   public static <T> T loadConfig (String filePath, Class<T> transType) {
       try {
           return (T) JAXBContext.newInstance(transType).createUnmarshaller().unmarshal(new File(filePath));
       } catch (Exception e) {
           e.printStackTrace();
       }
       return null;

   }
}
