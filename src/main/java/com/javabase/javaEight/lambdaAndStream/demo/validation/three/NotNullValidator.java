package com.javabase.javaEight.lambdaAndStream.demo.validation.three;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public final class NotNullValidator implements Validator {

    private final String message;

    public NotNullValidator(final Object object) {
        this.message = object != null ? null : "cannot be null";
    }

    @Override
    public @NotNull Optional<String> valid() {
        return Optional.ofNullable(message);
    }
}
