package org.csystem.app.function;

@FunctionalInterface
public interface IConsumer<T> {
    void accept(T t);
}
