package com.javabase.javaEight.lambdaAndStream.demo.validation.three;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.junit.Test;

public class UserTest {

    private static Validator userValidator(final User user) {
        return user == null ? Optional::empty : new Group(
                Field.of("username", new Group(
                        new NotNullValidator(user.username()),
                        SizeValidator.range(user.username(), 1, 16)
                )),
                Field.of("roles", new Group(
                        new NotNullValidator(user.roles()),
                        SizeValidator.range(user.roles(), 1, Integer.MAX_VALUE)
                ))
        );
    }

    @Test
    public void shouldPassOnValidUser() {
        final User user = new User("gediminas", new HashSet<>(Arrays.asList("admin", "guest")));
        if (userValidator(user).valid() != null) {
			
		}
    }

    @Test
    public void shouldFailIfUsernameLengthIsAboveValid() {
        final User user = new User(String.format("%17d", 1), null);
//        assertThat(userValidator(user).valid(), hasValue("\"username\" size is above maximum allowed 16"));
    }
}
