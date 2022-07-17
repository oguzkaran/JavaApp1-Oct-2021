package com.cagilcebeci.app.service.rest.weather.scheduler;


import com.cagilcebeci.app.service.rest.weather.mapper.IPlaceInfoMapper;
import com.cagilcebeci.app.service.rest.weather.mapper.IWeatherInfoMapper;
import org.csystem.app.weather.repository.backup.data.dal.WeatherInfoBackupAppHelper;
import org.csystem.app.weather.repository.backup.data.entity.PlaceInfo;
import org.csystem.app.weather.repository.data.dal.WeatherInfoAppHelper;
import org.csystem.util.console.Console;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class WeatherInfoScheduler {
    private final WeatherInfoAppHelper m_weatherInfoAppHelper;
    private final WeatherInfoBackupAppHelper m_weatherInfoBackupAppHelper;
    private final IWeatherInfoMapper m_weatherMapper;
    private final IPlaceInfoMapper m_placeInfoMapper;

    private void schedulerCallback(PlaceInfo pi)
    {
        Console.writeLine(pi.placeName);
    }

    public WeatherInfoScheduler(WeatherInfoAppHelper weatherInfoAppHelper,
                                WeatherInfoBackupAppHelper weatherInfoBackupAppHelper,
                                IWeatherInfoMapper weatherMapper, IPlaceInfoMapper placeInfoMapper)
    {
        m_weatherInfoAppHelper = weatherInfoAppHelper;
        m_weatherInfoBackupAppHelper = weatherInfoBackupAppHelper;
        m_weatherMapper = weatherMapper;
        m_placeInfoMapper = placeInfoMapper;
    }

    @Scheduled(cron = "0 6 15 * * *")
    //@Scheduled(cron = "0 55 23 * * *")
    public void schedulerCallback()
    {
        Console.writeLine("Schedule");
        var places = m_weatherInfoBackupAppHelper.findAllPlaces();

        places.forEach(this::schedulerCallback);
        //m_weatherInfoAppHelper.deleteAllWeatherInfo();
    }
}
