package com.javabase.javaEight.lambdaAndStream.demo.validation.three;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public final class Field implements Validator {

    private final Validator validator;
    private final String field;

    private Field(final String field, final Validator validator) {
        this.validator = validator;
        this.field = field;
    }

    @Override
    public @NotNull Optional<String> valid() {
        return validator.valid().map(this::message);
    }

    public static Validator of(final @NotNull String field, final @NotNull Validator validator) {
        return new Field(field, validator);
    }

    private @NotNull String message(final @NotNull String msg) {
        if (!msg.startsWith("\"")) {
            return String.format("\"%s\" %s", field, msg);
        }
        return String.format("\"%s.%s", field, msg.substring(1));
    }
}
