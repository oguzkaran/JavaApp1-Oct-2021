package org.csystem.app.service.rest.weather.geonames.scheduler;

import org.csystem.app.service.rest.weather.data.dal.PeriodicWeatherInfoHelper;
import org.csystem.app.service.rest.weather.data.entity.PlaceInfo;
import org.csystem.app.service.rest.weather.data.entity.WeatherInfo;
import org.csystem.app.service.rest.weather.geonames.WeatherObservations;
import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
public class WeatherInfoScheduler {
    private final PeriodicWeatherInfoHelper m_periodicWeatherInfoHelper;
    private final RestTemplate m_restTemplate;

    @Value("${geonames.url}")
    private String m_urlTemplate;

    private void weatherInfoCallback(PlaceInfo placeInfo)
    {
        var url = String.format(m_urlTemplate, placeInfo.north, placeInfo.south, placeInfo.east, placeInfo.west);
        var wis = m_restTemplate.getForObject(url, WeatherObservations.class);

        wis.weatherObservations.forEach(Console::writeLine);
        Console.writeLine("--------------------------------------");
    }

    public WeatherInfoScheduler(PeriodicWeatherInfoHelper periodicWeatherInfoHelper, RestTemplate restTemplate)
    {
        m_periodicWeatherInfoHelper = periodicWeatherInfoHelper;
        m_restTemplate = restTemplate;
    }

    //@Scheduled(fixedRate = 1, timeUnit = TimeUnit.DAYS)
    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS)
    public void schedulerCallback()
    {
        var places = m_periodicWeatherInfoHelper.findAllPlaces();

        places.forEach(this::weatherInfoCallback);
    }
}
