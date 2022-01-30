package org.csystem.app.function;

@FunctionalInterface
public interface IPredicate<T> {
    boolean test(T t);
}
