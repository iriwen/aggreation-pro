package com.java.code.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * created by yuxiaodong01 on 2020/10/30.
 */
public class DateTime {

    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        getDateByMilliSecs(1606964672084l);
        //parseNowTime();
    }

    private static void getDateByMilliSecs(long millis) {

        LocalDateTime now = LocalDateTime.now();
        now.format(dateTimeFormatter);
        LocalDate toLocalDate = now.toLocalDate();

        //System Default TimeZone : Asia/Shanghai
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //时间戳
        Instant instant = Instant.ofEpochMilli(millis);

        LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();

        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();

        System.out.println(localDate.toString());

        System.out.println(localDateTime.toString());

        System.out.println("millis : " + millis + "," +
                localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());

    }

    private static void getCurrentTimeWithSecond() {
        //获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now();

        Long nowMills = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();

        System.out.println("当前时间对应的毫秒数" + nowMills);
        //获取秒数
        long seconds = localDateTime.toEpochSecond(ZoneOffset.of("+8"));

        //对日期进行格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

        String nowTime = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);

        System.out.println("当前时间" + nowTime);

        LocalDateTime theNowDate = LocalDateTime.now();
        //获取毫秒数
        Long milliSecond = theNowDate.toInstant(ZoneOffset.of("+8")).toEpochMilli();

        Long zoneMill = theNowDate.atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli();

        LocalDateTime beforeSixMonth = localDateTime.minusMonths(6);

        String sixMonthsAgo = beforeSixMonth.format(formatter);


        System.out.println("6个月以前的时间：" + sixMonthsAgo);

        Instant toInstant = beforeSixMonth.toInstant(ZoneOffset.of("+8"));

        long epochMilli = toInstant.toEpochMilli();

        System.out.println(epochMilli);

        int a = 0;
        try {
            a = Integer.parseInt("34");
        } catch (Exception e) {
            Throwable cause = e.getCause();
        }
        System.out.println(a);

    }
}
