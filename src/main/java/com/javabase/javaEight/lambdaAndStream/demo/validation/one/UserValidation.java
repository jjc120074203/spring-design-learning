package com.javabase.javaEight.lambdaAndStream.demo.validation.one;

import java.util.function.Function;

public interface UserValidation extends Function<User, Boolean> {
	static UserValidation nameIsNotEmpty() {
		return user -> !user.name.trim().isEmpty();
	}

	static UserValidation eMailContainsAtSign() {
		return user -> user.email.contains("@");
	}

	default UserValidation and(UserValidation other) {
		return user -> this.apply(user) && other.apply(user);
	}
}
