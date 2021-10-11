package org.csystem.library.parser;

@FunctionalInterface
public interface ISource {
    int nextChar() throws Exception;
    default void reset() throws Exception
    {
        throw new UnsupportedOperationException();
    }
}
