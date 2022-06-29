package com.myproject.project.util;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Test
 * @description:
 * @author: xiongshanwen
 * @create: 2021-11-10 14:56
 **/
public class Test {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        /*String format = simpleDateFormat.format(new Date(1636523492000l));
        System.out.println("format = " + format);*/

        /*Date parse = simpleDateFormat.parse("2021-11-10 15:01:53");
        System.out.println("parse = " + parse);

        *//*Date date = new Date("1636611373799000");
        String format = simpleDateFormat.format(date);
        System.out.println("format = " + format);*//*

        Date date1 = new Date(1635920300041L);
        System.out.println(date1);*/
        //System.out.println("date = " + date1.getTime());

        Date parse = simpleDateFormat.parse("2022-06-18");
        //System.out.println("parse = " + parse.getTime()/(60 * 1000));

        List<String> list = new ArrayList<>();
        list.add(null);
        list.add("1");
        System.out.println("list = " + list);
        List<String> collect = list.stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }
}
