package org.csystem.util.io.file;

@FunctionalInterface
public interface IConsumer<T> {
    void accept(T t) throws Exception;
}
