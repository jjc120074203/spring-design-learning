package com.javabase.javaEight.lambdaAndStream.demo.validation.three;

import java.util.Set;

public final class User {
    private final String username;
    private final Set<String> roles;

    public User(final String username, final Set<String> roles) {
        this.username = username;
        this.roles = roles;
    }

    public String username() {
        return username;
    }

    public Set<String> roles() {
        return roles;
    }
}
