package com.javabase.javaEight.lambdaAndStream.demo.validation.four;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Class representing Monad design pattern. Monad is a way of chaining operations on the
 * given object together step by step. In Validator each step results in either success or
 * failure indicator, giving a way of receiving each of them easily and finally getting
 * validated object or list of exceptions.
 *
 * @param <T> Placeholder for an object.
 */
public class Validator<T> {

  private final T t;


  private final List<Throwable> exceptions = new ArrayList<>();

 
  private Validator(T t) {
    this.t = t;
  }


  public static <T> Validator<T> of(T t) {
    return new Validator<>(Objects.requireNonNull(t));
  }

  public Validator<T> validate(Predicate<T> validation, String message) {
    if (!validation.test(t)) {
      exceptions.add(new IllegalStateException(message));
    }
    return this;
  }

 
  public <U> Validator<T> validate(Function<T, U> projection, Predicate<U> validation,
                                   String message) {
    return validate(projection.andThen(validation::test)::apply, message);
  }

  /**
   * Receives validated object or throws exception when invalid.
   *
   * @return object that was validated
   * @throws IllegalStateException when any validation step results with failure
   */
  public T get() throws IllegalStateException {
    if (exceptions.isEmpty()) {
      return t;
    }
    IllegalStateException e = new IllegalStateException();
    exceptions.forEach(e::addSuppressed);
    throw e;
  }
}