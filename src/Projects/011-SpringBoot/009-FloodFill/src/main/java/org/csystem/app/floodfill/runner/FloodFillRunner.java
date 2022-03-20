package org.csystem.app.floodfill.runner;

import org.csystem.util.console.Console;
import org.csystem.util.image.AsciiImage;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FloodFillRunner implements ApplicationRunner {
    private final AsciiImage m_asciiImage;

    public FloodFillRunner(AsciiImage asciiImage)
    {
        m_asciiImage = asciiImage;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_asciiImage.floodFill(4, 4, '-', '#');
        Console.writeLine(m_asciiImage);
        m_asciiImage.saveImage("filled.txt");
    }
}
