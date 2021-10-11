package net.tanergenc.application.parser.runner;

import com.beyzayazici.lib.parser.component.ParserApp;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ParserAppRunner implements ApplicationRunner {
    private final ParserApp m_parserApp;

    public ParserAppRunner(ParserApp parserApp)
    {
        m_parserApp = parserApp;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_parserApp.run();
    }
}
