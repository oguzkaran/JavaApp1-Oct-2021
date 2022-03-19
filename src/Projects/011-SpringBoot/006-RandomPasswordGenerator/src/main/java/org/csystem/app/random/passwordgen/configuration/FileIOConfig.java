package org.csystem.app.random.passwordgen.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Configuration
public class FileIOConfig {
    @Bean("bufferedWriterPath1")
    public BufferedWriter getBufferedWriterPath1(@Value("${path1}") String path) throws IOException
    {
        return Files.newBufferedWriter(Path.of(path), StandardCharsets.UTF_8);
    }

    @Bean("bufferedWriterPath2")
    public BufferedWriter getBufferedWriterPath2(@Value("${path2}") String path) throws IOException
    {
        return Files.newBufferedWriter(Path.of(path), StandardCharsets.UTF_8, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }
}
