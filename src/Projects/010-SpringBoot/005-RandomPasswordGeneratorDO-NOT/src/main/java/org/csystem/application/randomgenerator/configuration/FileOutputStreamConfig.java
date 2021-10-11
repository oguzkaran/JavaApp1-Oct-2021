package org.csystem.application.randomgenerator.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileOutputStream;
import java.io.IOException;

@Configuration
public class FileOutputStreamConfig {
    @Value("${filename1}")
    private String m_filename1;

    @Value("${filename2}")
    private String m_filename2;

    @Bean("fileOutputStream.first")
    public FileOutputStream getFirst() throws IOException
    {
        return new FileOutputStream(m_filename1, true);
    }

    @Bean("fileOutputStream.second")
    public FileOutputStream getSecond() throws IOException
    {
        return new FileOutputStream(m_filename2, true);
    }
}
