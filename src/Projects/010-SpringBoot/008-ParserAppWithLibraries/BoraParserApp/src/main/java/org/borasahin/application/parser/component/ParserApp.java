package org.borasahin.application.parser.component;

import org.csystem.library.parser.ComponentName;
import org.csystem.library.parser.ISource;
import org.csystem.library.parser.Parser;
import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ParserApp {
    private final Collection<ISource> m_sources;
    private final Parser m_parser;

    private void consumerCallback(Parser p)
    {
        try {
            Console.writeLine("Number of Digits:%d", p.countDigits());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ParserApp(Collection<ISource> sources, @Qualifier(ComponentName.PARSER) Parser parser)
    {
        m_sources = sources;
        m_parser = parser;
    }

    public void run()
    {
        m_sources.stream().map(m_parser::setSource).forEach(this::consumerCallback);
    }
}
