package com.sc.test.help;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

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
    }
}
