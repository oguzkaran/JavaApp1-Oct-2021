package org.csystem.app.randomgenerator.configuration;

import org.csystem.app.randomgenerator.data.Language;
import org.csystem.app.randomgenerator.data.NumberType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LanguageConfig {
    @Bean
    public Language[] getLanguageValues()
    {
        return Language.values();
    }
}
