package com.javabase.concourrent.mutiple;

/**
 * 两个线程交替打印 0-100
 *
 * @author Mireal
 */
public class TwoThreadsAlternatelyPrints {
    private static int count = 0;
    private static final Object LOCK = new Object();
    public static void main(String[] args) {
        solution2();
    }
    public static void solution2() {
        new Thread(() -> {
            while (count < 100) {
                synchronized (LOCK) {
                    if ((count & 1) == 0) {
                        System.out.println("偶数线程 -> " + count++);
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (count < 100) {
                synchronized (LOCK) {
                    if ((count & 1) == 1) {
                        System.out.println("奇数线程 -> " + count++);
                    }
                }
            }
        }).start();
    }
} 

