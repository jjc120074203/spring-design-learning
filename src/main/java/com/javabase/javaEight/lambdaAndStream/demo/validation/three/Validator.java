package com.javabase.javaEight.lambdaAndStream.demo.validation.three;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

@FunctionalInterface
public interface Validator {

    /**
     * Validates and maybe returns an error message
     *
     * @return maybe error message
     */
    @NotNull Optional<String> valid();
}
