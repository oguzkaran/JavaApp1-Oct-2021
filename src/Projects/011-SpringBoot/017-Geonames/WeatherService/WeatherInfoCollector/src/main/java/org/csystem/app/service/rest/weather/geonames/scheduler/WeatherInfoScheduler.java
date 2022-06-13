package org.csystem.app.service.rest.weather.geonames.scheduler;

import org.csystem.app.service.rest.weather.data.dal.WeatherInfoCollectorAppHelper;
import org.csystem.app.service.rest.weather.data.entity.PlaceInfo;
import org.csystem.app.service.rest.weather.data.entity.WeatherInfo;
import org.csystem.app.service.rest.weather.geonames.WeatherObservations;
import org.csystem.app.service.rest.weather.mapper.IWeatherInfoMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
public class WeatherInfoScheduler {
    private final WeatherInfoCollectorAppHelper m_weatherInfoCollectorAppHelper;
    private final RestTemplate m_restTemplate;
    private final IWeatherInfoMapper m_weatherMapper;

    @Value("${geonames.url}")
    private String m_urlTemplate;

    private void weatherInfoCallback(WeatherInfo wi, PlaceInfo pi)
    {
        wi.placeInfo = pi;
        m_weatherInfoCollectorAppHelper.saveWeatherInfo(wi);
    }

    private void schedulerCallback(PlaceInfo pi)
    {
        var url = String.format(m_urlTemplate, pi.north, pi.south, pi.east, pi.west);
        var wos = m_restTemplate.getForObject(url, WeatherObservations.class);


        wos.weatherObservations.stream().map(m_weatherMapper::toWeatherInfo).forEach(wi -> weatherInfoCallback(wi, pi));
    }

    public WeatherInfoScheduler(WeatherInfoCollectorAppHelper weatherInfoCollectorAppHelper, RestTemplate restTemplate, IWeatherInfoMapper weatherMapper)
    {
        m_weatherInfoCollectorAppHelper = weatherInfoCollectorAppHelper;
        m_restTemplate = restTemplate;
        m_weatherMapper = weatherMapper;
    }

    //@Scheduled(fixedRate = 1, timeUnit = TimeUnit.DAYS)
    @Scheduled(cron = "0 54 23 * * *")
    public void schedulerCallback()
    {
        var places = m_weatherInfoCollectorAppHelper.findAllPlaces();

        places.forEach(this::schedulerCallback);
    }
}
