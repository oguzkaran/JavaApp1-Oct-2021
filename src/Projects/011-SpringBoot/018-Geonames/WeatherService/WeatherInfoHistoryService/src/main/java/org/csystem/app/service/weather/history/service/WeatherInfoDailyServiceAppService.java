package org.csystem.app.service.weather.history.service;

import org.csystem.app.service.weather.history.dto.WeatherObservations;
import org.csystem.app.service.weather.history.mapper.IWeatherInfoMapper;
import org.csystem.app.weather.repository.backup.data.dal.WeatherInfoBackupAppHelper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class WeatherInfoDailyServiceAppService {
    private final WeatherInfoBackupAppHelper m_weatherInfoBackupAppHelper;
    private final IWeatherInfoMapper m_weatherInfoMapper;

    public WeatherInfoDailyServiceAppService(WeatherInfoBackupAppHelper weatherInfoBackupAppHelper, IWeatherInfoMapper weatherInfoMapper)
    {
        m_weatherInfoBackupAppHelper = weatherInfoBackupAppHelper;
        m_weatherInfoMapper = weatherInfoMapper;
    }

    public WeatherObservations findByPlaceNameAndYearAndMonth(String placeName, int year, int month)
    {
        var wis = m_weatherInfoBackupAppHelper.findByPlaceNameAndYearAndMonth(placeName, year, month);

        var wos = StreamSupport.stream(wis.spliterator(), false).map(m_weatherInfoMapper::toWeatherObservation).collect(Collectors.toList());

        return m_weatherInfoMapper.toWeatherObservations(wos);
    }


    public WeatherObservations findByPlaceNameAndMonth(String placeName, int month)
    {
        var wis = m_weatherInfoBackupAppHelper.findByPlaceNameAndMonth(placeName, month);

        var wos = StreamSupport.stream(wis.spliterator(), false).map(m_weatherInfoMapper::toWeatherObservation).collect(Collectors.toList());

        return m_weatherInfoMapper.toWeatherObservations(wos);
    }
}
