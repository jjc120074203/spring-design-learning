package com.javabase.javaEight.lambdaAndStream.demo.validation.two;

import com.javabase.javaEight.lambdaAndStream.demo.validation.one.User;

public class Maintest {
 public static void main(String[] args) {
	 UserValidation validation = UserValidation.nameIsNotEmpty().and(UserValidation.eMailContainsAtSign());
	 User gregor = new User("", 30, "mail@mailinator.com");
	 ValidationResult result = validation.apply(gregor);
	 result.getReason().ifPresent(System.out::println); // Name is empty.
}
}
