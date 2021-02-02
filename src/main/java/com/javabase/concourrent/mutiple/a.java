package com.javabase.concourrent.mutiple;

import java.util.concurrent.CompletableFuture;

public class a {
	
	private static int count = 0;
	public static final Object aa=new Object();
	
	public static void main(String[] args) {
		testT1();
		testT2();
		testT3();
	}
	//同步锁解决此类 
	private static void testT1() {
		new Thread(()->{
			while(count<100)
			synchronized(aa) {
				if ((count&1)==0) {
					System.out.println("当前偶数"+count++);
				}
			}
		}).start();
		new Thread(()-> {
			while(count<100) {
	    		synchronized(aa) {
	    			if ((count&1)==1) {
					  System.out.println("当前奇数"+count++);	
					}
	    		}
	    	}
	    }).start();
	}
	//notify 展现的此类问题
	private static void testT2() {
		 Runnable haha=()->{
			while (count<=100) {
				synchronized(aa) {
				System.out.println(Thread.currentThread().getName()+"->"+count++);
				aa.notify();
					if (count<=100) {
						try {
							aa.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		CompletableFuture.allOf(CompletableFuture.runAsync(haha),CompletableFuture.runAsync(haha)).join();
	}
	
    //利用CompletableFuture特性独立打印相关数据
	private static void testT3() {
		CompletableFuture<Void> t1=CompletableFuture.runAsync(()->{
			while(count<100) {
				synchronized (aa) {
					if ((count&1)==1) {
						System.out.println("当前数组"+count++);
					}
				}
			}
		});
		CompletableFuture<Void> t2=CompletableFuture.runAsync(()->{
			while(count<100) {
				synchronized (aa) {
					if ((count&1)==0) {
						System.out.println("当前测试"+count++);
					}
				}
			}
		});
		CompletableFuture.allOf(t1,t2).join();
		
	}
	
	
}
