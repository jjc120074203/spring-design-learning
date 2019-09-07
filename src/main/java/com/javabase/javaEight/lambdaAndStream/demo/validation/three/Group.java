package com.javabase.javaEight.lambdaAndStream.demo.validation.three;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public final class Group implements Validator {

    private final @NotNull Collection<Validator> validators;

    public Group(final @NotNull Validator... validators) {
        this.validators = Arrays.asList(validators);
    }

    @Override
    public @NotNull Optional<String> valid() {
        return validators.stream()
                .map(Validator::valid)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }
}
