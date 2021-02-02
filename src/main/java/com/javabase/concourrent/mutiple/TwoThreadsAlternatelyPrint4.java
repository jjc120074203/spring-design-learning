package com.javabase.concourrent.mutiple;

import java.util.concurrent.CompletableFuture;
/**
 * 两个线程交替打印 0-100
 *
 * @author Mireal
 */
public class TwoThreadsAlternatelyPrint4 {
    private static int count = 0;
    private static final Object LOCK = new Object();
    public static void main(String[] args) {
        solution3();
    }
    public static void solution3() {
        CompletableFuture<Void> t1 = CompletableFuture.runAsync(() -> {
            while (count < 100) {
                synchronized (LOCK) {
                    if ((count & 1) == 0) {
                        System.out.println("偶数线程 -> " + count++);
                    }
                }
            }
        });
        CompletableFuture<Void> t2 = CompletableFuture.runAsync(() -> {
            while (count < 100) {
                synchronized (LOCK) {
                    if ((count & 1) == 1) {
                        System.out.println("奇数线程 -> " + count++);
                    }
                }
            }
        });
        CompletableFuture.allOf(t1, t2).join();
    }
}
