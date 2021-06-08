package com.manjaro.code.date;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * created by iriwen on 2021/04/22.
 */
@Slf4j
public class LocalDateDay01 {

    public static void main(String[] args) {

        String date1 = "2020-11-12";
        String date2 = "2020-12-12";

        LocalDate start = LocalDate.parse(date1);
        LocalDate end = LocalDate.parse(date2);


        LocalDate now = LocalDate.now();

        LocalDate yesterday = now.minusDays(1);
        LocalDate beforeYesterday = yesterday.minusDays(1);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String qiantian = beforeYesterday.format(formatter);

        String zuotian = yesterday.format(formatter);

        String jintian = now.format(formatter);

        log.info("today:{} , yesterday:{} , beforeYesterday:{}",jintian, zuotian,qiantian);
    }
}
