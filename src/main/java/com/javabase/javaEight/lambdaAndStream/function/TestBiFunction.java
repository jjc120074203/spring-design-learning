package com.javabase.javaEight.lambdaAndStream.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class TestBiFunction {
	
	public  void demoOne(){
	  Map<Integer,String> map = new HashMap<>();
      map.put(1, "A");
      map.put(2, "B");
      map.put(3, "C");
      BiConsumer<Integer,String> biConsumer = (key,value) -> 
						System.out.println("Key:"+ key+" Value:"+ value);
      map.forEach(biConsumer);
	}
	public  void demoOnes(){
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		BiConsumer<Integer,String> biConsumer = (key,value) -> 
		System.out.println("Key:"+ key+" Value:"+ value);
		map.forEach(biConsumer);
	}
	public  void demoTwo(){
	        BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Result:" +(num1 + num2);
	        System.out.println(biFunction.apply(20,25));
	}
	public  void demoThree(){
		  BiPredicate<Integer, String> condition = (i,s)-> i>20 && s.startsWith("R");
	      System.out.println(condition.test(10,"Ram"));
	      System.out.println(condition.test(30,"Shyam"));
	      System.out.println(condition.test(30,"Ram"));
	}
}
