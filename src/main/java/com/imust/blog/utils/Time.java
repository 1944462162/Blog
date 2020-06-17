package com.imust.blog.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Author: wangJianBo
 * Date: 2020/6/17 15:25
 * Content:
 */
public class Time {

    public LocalDate getNowDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }
}
