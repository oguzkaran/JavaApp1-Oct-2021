package org.csystem.app.service.weather.daily.conbfiguration.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("demo")
public class UsersInMemoryConfig {
    @Bean
    public List<UserDetails> userDetails()
    {
        var uds =new ArrayList<UserDetails>();

        uds.add(User.withDefaultPasswordEncoder()
                .username("oguz")
                .password("csd1993")
                .authorities("ADMIN")
                .build());

       uds.add(User.withDefaultPasswordEncoder()
                .username("olcay")
                .password("oc1234")
                .authorities("USER")
                .build());

        uds.add(User.withDefaultPasswordEncoder()
                .username("ceyhun")
                .password("cs1234")
                .authorities("VIEWER")
                .build());

        return uds;
    }
}
