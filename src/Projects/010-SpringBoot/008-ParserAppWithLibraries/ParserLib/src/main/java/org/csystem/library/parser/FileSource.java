package org.csystem.library.parser;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@Component(ComponentName.FILE_SOURCE)
public class FileSource implements ISource {
    private BufferedReader m_file;
    private final Path m_path;

    public FileSource(@Qualifier(ComponentName.FILE_SOURCE_INJECT_BEAN_NAME) String path) throws IOException
    {
        m_path = Path.of(path);
        m_file = Files.newBufferedReader(m_path, StandardCharsets.UTF_8);
    }

    @Override
    public int nextChar() throws Exception
    {
        var ch = m_file.read();

        if (ch == -1) {
            m_file.close();
            m_file = null;
        }
        return ch;
    }

    @Override
    public void reset() throws Exception
    {
        if (m_file != null)
            m_file.close();
        m_file = Files.newBufferedReader(m_path, StandardCharsets.UTF_8);
    }
}
