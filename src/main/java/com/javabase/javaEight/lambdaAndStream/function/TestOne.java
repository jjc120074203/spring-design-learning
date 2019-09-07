package com.javabase.javaEight.lambdaAndStream.function;

import java.util.function.Function;

import org.junit.Test;
/**
 * 
 * All rights Reserved, Designed By 芯盾
 * @Title:  TestOne.java   
 * @Package com.javabase.javaEight.lambdaAndStream.function   
 * @Description:    Function作为一个函数式接口，主要方法apply接收一个参数，返回一个值
 * @author: chenjl     
 * @date:   2019年8月30日 下午1:59:19   
 * @version V1.0 
 * @Copyright: 2019芯盾 Inc. All rights reserved. 
 *
 */
public class TestOne {
	public static int compute(int a, Function<Integer, Integer> function) {
		Integer result = function.apply(a);
		return result;
	}
//	compose方法是一个默认方法，这个方法接收一个function作为参数
//	将参数function执行的结果作为参数给调用的function，以此来实现两个function组合的功能。
	public static int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> beForeFunction) {
	    return function1.compose(beForeFunction).apply(a);
	}
	
	// 
	public static int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> afterfunction2) {
	    return function1.andThen(afterfunction2).apply(a);
	}
	
	@Test
	public  void testFunctionApply() {
		int a=TestOne.compute(5,value -> value * value); //25 计算平方
		int a1=TestOne.compute(5,value -> value + value); //10 求和
		int a2=TestOne.compute(5,value -> value - 2); //3
		System.out.println(a+""+ "-"+a1+ "-"+a2);//25-10-3
	}
	
	@Test
	public  void testCompose() {
		int a=TestOne.compute(2, value -> value * 3, value -> value * value); 
		int a1=TestOne.compute2(2, value -> value * 3, value -> value * value); 
		System.out.println(a+"-"+a1); //12-36
	}
}
