package com.myproject.project.common;

import java.util.Random;

/**
 * @ClassName RandomSend
 * @description:
 * @author: xiongshanwen
 * @create: 2022-06-30 15:05
 **/
public class RandomSend {
    public static void main(String[] args) {
        RandomSend rt = new RandomSend();
        rt.testRandom();
    }

    public void testRandom() {
        System.out.println("Random不设置种子：");
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + random.nextInt(2000) + ", ");
            }
            System.out.println("");
        }
        System.out.println("");

        System.out.println("Random设置种子：");
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            random.setSeed(21321321);
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + random.nextInt(2000) + ", ");
            }
            System.out.println("");
        }



    }



}
