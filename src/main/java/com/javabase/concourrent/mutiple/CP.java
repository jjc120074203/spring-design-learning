package com.javabase.concourrent.mutiple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CP {
 private static final AtomicInteger JOB=new AtomicInteger();
 private static final List<Integer> BOX=new ArrayList<>();
 private static final Object LOCK=new Object();
 
 public static void main(String[] args) {
	 CP cp=new CP();
	new Thread(()-> {
		try {
			cp.p1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}).start();
	new Thread(()-> {
		try {
			cp.c1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}).start();
}
 
 
private static void  c1() throws InterruptedException {
	while(true) {
		Thread.sleep(1000);
		synchronized(LOCK) {
			if (BOX.size()==0) {
				try {
					//release lock
					System.out.println("当前线程用完了,请各位为等一下哈");
					LOCK.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//扔石子
			int index=BOX.get(0);
			BOX.remove(0);
			System.out.println("消费者开始扔石子"+""+BOX.size());
			LOCK.notifyAll();
		}
	}
}

	private static void  p1() throws InterruptedException {
		
		while(true) {
			Thread.sleep(100);
			synchronized(LOCK) {
				if (BOX.size()==100) {
					try {
						//release lock
						System.out.println("当前线程满了,请各位为等一下哈");
						LOCK.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				BOX.add(JOB.incrementAndGet());
                System.out.println("produce number:" + JOB.get() + "\t" + "current size:" + BOX.size());
                LOCK.notifyAll();
			}
		}
	}
}
