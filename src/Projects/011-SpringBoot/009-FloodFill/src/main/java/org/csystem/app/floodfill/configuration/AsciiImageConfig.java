package org.csystem.app.floodfill.configuration;

import org.csystem.util.image.AsciiImage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AsciiImageConfig {
    @Bean
    public AsciiImage getImage(@Value("${image.ascii.row}") int row,
                               @Value("${image.ascii.col}") int col,
                               @Value("${image.ascii.path}") String path) throws IOException
    {
        return AsciiImage.of(row, col).loadImage(path);
    }
}
