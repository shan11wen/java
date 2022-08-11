package com.myproject.project.util;

import java.util.Random;

/**
 * @ClassName Test2
 * @description:
 * @author: xiongshanwen
 * @create: 2022-08-11 14:47
 **/
public class Test2 {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(3);
        System.out.println("i = " + i);
        switch (i){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}
