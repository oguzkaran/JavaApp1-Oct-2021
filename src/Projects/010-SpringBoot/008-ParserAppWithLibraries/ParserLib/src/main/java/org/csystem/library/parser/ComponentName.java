package org.csystem.library.parser;

public final class ComponentName {
    private ComponentName()
    {}

    public static final String PARSER = "org.csystem.library.parser.parser";
    public static final String CHAR_ARRAY_SOURCE = "org.csystem.library.parser.source.chararray";
    public static final String STRING_SOURCE = "org.csystem.library.parser.source.string";
    public static final String FILE_SOURCE = "org.csystem.library.parser.source.file";
    public static final String CHAR_ARRAY_SOURCE_INJECT_BEAN_NAME = "org.csystem.library.parser.source.chararray.string";
    public static final String STRING_SOURCE_INJECT_BEAN_NAME = "org.csystem.library.parser.source.string.string";
    public static final String FILE_SOURCE_INJECT_BEAN_NAME = "org.csystem.library.parser.source.file.name";

    public static final String PARSER_INJECT_BEAN_NAME = "org.csystem.library.parser.parser.source";
}
