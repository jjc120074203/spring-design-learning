package com.javabase.concourrent.mutiple;

import java.util.concurrent.CompletableFuture;
/**
 * 两个线程交替打印 0-100
 *
 * @author Mireal
 */
public class TwoThreadsAlternatelyPrint {
    private static int count = 0;
    private static final Object LOCK = new Object();
    public static void main(String[] args) {
        solution1();
    }
    public static void solution1() {
        Runnable printer = () -> {
            while (count <= 100) {
                synchronized (LOCK) {
                    System.out.println(Thread.currentThread().getName() + " -> " + count++);
                    LOCK.notify();
                    if (count <= 100) {
                        try {
                            // 让出当前的 
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        CompletableFuture.allOf(
                CompletableFuture.runAsync(printer),
                CompletableFuture.runAsync(printer)
        ).join();
    }
}