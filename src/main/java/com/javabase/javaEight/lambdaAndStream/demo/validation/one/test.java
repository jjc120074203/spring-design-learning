package com.javabase.javaEight.lambdaAndStream.demo.validation.one;

public class test {
	public static void main(String[] args) {
		User gregor = new User("Gregor", 30, "nicemailgmail.com");
		if (UserValidation.nameIsNotEmpty().and(UserValidation.eMailContainsAtSign()).apply(gregor)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		//过滤筛选
//		List<User> users = findAllUsers()
//			    .stream().parallel()
//			    .filter(nameIsNotEmpty().and(eMailContainsAtSign())::apply) // to Predicate
//			    .collect(Collectors.toList());
		
		
	}
}
