package com.javabase.javaEight.lambdaAndStream.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class twoTest {
	public static  void  testProphets(){
		int[] numbers= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        List<Integer> list=new ArrayList<>();
        for(int i:numbers) {
            list.add(i);
        }
        Predicate<Integer> p1=i->i>5;
        Predicate<Integer> p2=i->i<20;
        Predicate<Integer> p3=i->i%2==0;
        List<Integer> test=list.stream().filter(p1.and(p2).and(p3)).collect(Collectors.toList());
        System.out.println(test.toString());
	}
}
