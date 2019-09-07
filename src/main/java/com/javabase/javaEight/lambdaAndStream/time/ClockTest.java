package com.javabase.javaEight.lambdaAndStream.time;

import java.time.Clock;

public class ClockTest {
	
	public static void main(String[] args) {
		Clock c=Clock.systemDefaultZone();
		long miles=c.millis();
		System.out.println(miles);
	}
}
