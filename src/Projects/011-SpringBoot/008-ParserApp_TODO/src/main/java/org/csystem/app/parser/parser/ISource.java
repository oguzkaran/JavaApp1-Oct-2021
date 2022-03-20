package org.csystem.app.parser.parser;

public interface ISource {
    int nextChar() throws Exception;

    default void reset() throws Exception
    {
        throw new UnsupportedOperationException();
    }
}
