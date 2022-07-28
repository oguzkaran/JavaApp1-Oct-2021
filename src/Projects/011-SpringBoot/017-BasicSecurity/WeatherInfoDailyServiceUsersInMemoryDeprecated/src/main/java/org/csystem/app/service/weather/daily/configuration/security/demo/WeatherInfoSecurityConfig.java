package org.csystem.app.service.weather.daily.configuration.security.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Configuration
@Profile({"demo", "deprecated"})
public class WeatherInfoSecurityConfig extends WebSecurityConfigurerAdapter {
    private final List<UserDetails> m_userDetails;

    public WeatherInfoSecurityConfig(List<UserDetails> userDetails)
    {
        m_userDetails = userDetails;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        var manager = auth.inMemoryAuthentication();
        for (var ud : m_userDetails)
            manager.withUser(ud);
    }
}
