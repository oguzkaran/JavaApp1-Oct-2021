package org.csystem.app.security.service.admin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTempateConfig {
    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
