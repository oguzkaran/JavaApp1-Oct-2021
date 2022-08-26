package org.csystem.app.randomuser.collector.configuration;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GsonConfig {
    @Bean
    public Gson getGson()
    {
        return new Gson();
    }
}
