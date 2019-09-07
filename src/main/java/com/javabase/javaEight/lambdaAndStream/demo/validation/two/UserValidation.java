package com.javabase.javaEight.lambdaAndStream.demo.validation.two;

import java.util.function.Function;
import java.util.function.Predicate;

import com.javabase.javaEight.lambdaAndStream.demo.validation.one.User;

interface UserValidation extends Function<User, ValidationResult> {
	static UserValidation nameIsNotEmpty() {
		return holds(user -> !user.name.trim().isEmpty(), "Name is empty.");
	}

	static UserValidation eMailContainsAtSign() {
		return holds(user -> user.email.contains("@"), "Missing @-sign.");
	}

	static UserValidation holds(Predicate<User> p, String message) {
		return user -> p.test(user) ? ValidationResult.valid() : ValidationResult.invalid(message);
	}

	default UserValidation and(UserValidation other) {
		return user -> {
			final ValidationResult result = this.apply(user);
			return result.isValid() ? other.apply(user) : result;
		};
	}
}
