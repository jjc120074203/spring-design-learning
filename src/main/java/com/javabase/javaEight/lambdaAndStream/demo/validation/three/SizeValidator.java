package com.javabase.javaEight.lambdaAndStream.demo.validation.three;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Optional;

public class SizeValidator implements Validator {

    private final String message;

    private SizeValidator(final String message) {
        this.message = message;
    }

    @Override
    public @NotNull
    Optional<String> valid() {
        return Optional.ofNullable(message);
    }

    public static <T extends Comparable<T>> @NotNull Validator range(
            final @Nullable T val,
            final @NotNull T min,
            final @NotNull T max
    ) {
        if (val == null) {
            return new SizeValidator(null);
        }

        if (val.compareTo(min) == -1) {
            return new SizeValidator(String.format("size is below minimum required %s", min.toString()));
        }

        if (val.compareTo(max) == 1) {
            return new SizeValidator(String.format("size is above maximum allowed %s", max.toString()));
        }

        return new SizeValidator(null);
    }

    public static @NotNull Validator range(final Collection<?> val, final int min, final int max) {
        if (val == null) {
            return new SizeValidator(null);
        }

        return range(val.size(), min, max);
    }

    public static @NotNull Validator range(final String val, final int min, final int max) {
        if (val == null) {
            return new SizeValidator(null);
        }

        return range(val.length(), min, max);
    }
}