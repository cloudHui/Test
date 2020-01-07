package com.sc.test.help;

import com.sc.test.config.DataConfig;
import com.sc.test.config.RedisConfig;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: cloud
 * @Date: 2019/7/16 19:32
 * @Version 1.0
 */
public class Testing {

    final DateTime DISTRIBUTION_TIME_SPLIT_TIME = new DateTime().withTime(15,0,0,0);

    private Date calculateDistributionTimeByOrderCreateTime(Date orderCreateTime){
        DateTime orderCreateDateTime = new DateTime(orderCreateTime);
        Date tomorrow = orderCreateDateTime.plusDays(1).toDate();
        Date theDayAfterTomorrow = orderCreateDateTime.plusDays(2).toDate();
        return orderCreateDateTime.isAfter(DISTRIBUTION_TIME_SPLIT_TIME) ? wrapDistributionTime(theDayAfterTomorrow) : wrapDistributionTime(tomorrow);
    }
    private Date wrapDistributionTime(Date distributionTime){
        DateTime currentDistributionDateTime = new DateTime(distributionTime);
        DateTime plusOneDay = currentDistributionDateTime.plusDays(1);
        boolean isSunday = (DateTimeConstants.SUNDAY == currentDistributionDateTime.getDayOfWeek());
        return isSunday ? plusOneDay.toDate() : currentDistributionDateTime.toDate() ;
    }

    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
//        DateTime dateTimeBefor = dateTime.minusYears(1).monthOfYear().setCopy(3).dayOfMonth().withMaximumValue();
        DateTime dateTimeBefore = dateTime.minusMonths(1);
        System.out.println(dateTimeBefore.toString("yyyy-MM-dd HH:mm:ss"));//2017-09-30

        DataConfig  config = ConfigUtil.loadConfig("Config" + File.separator + "DataBaseConfig.xml", DataConfig.class);
        DataConfig.DataConf conf = config.getDataConf().get(0);
//        RedisConfig redisConfig =  RedisConfig.getInstance();
//        System.out.print(redisConfig + ":" + conf);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        for (int before = 0; before < 8; before++) {
            int beforeDay = 1;
            if (before == 0) {
                beforeDay = 0;
            }
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - beforeDay);
            System.out.println(sdf.format(calendar.getTime()));
        }
    }
}
