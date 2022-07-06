package org.csystem.app.service.weather.daily.service;

import org.csystem.app.service.weather.daily.dto.WeatherObservations;
import org.csystem.app.service.weather.daily.mapper.IWeatherInfoMapper;
import org.csystem.app.weather.repository.data.dal.WeatherInfoAppHelper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class WeatherInfoDailyServiceAppService {
    private final WeatherInfoAppHelper m_weatherInfoAppHelper;
    private final IWeatherInfoMapper m_weatherInfoMapper;

    public WeatherInfoDailyServiceAppService(WeatherInfoAppHelper weatherInfoAppHelper, IWeatherInfoMapper weatherInfoMapper)
    {
        m_weatherInfoAppHelper = weatherInfoAppHelper;
        m_weatherInfoMapper = weatherInfoMapper;
    }

    public WeatherObservations findWeatherInfoByPlaceName(String placeName)
    {
        return m_weatherInfoMapper.toWeatherObservations(
                StreamSupport.stream(m_weatherInfoAppHelper.findWeatherInfoByPlaceName(placeName).spliterator(), false)
                .map(m_weatherInfoMapper::toWeatherObservation).collect(Collectors.toList()));
    }

    public WeatherObservations findWeatherInfoByPlaceNameAndHourAndMinute(String placeName, int hour, int minute)
    {
        return m_weatherInfoMapper.toWeatherObservations(
                StreamSupport.stream(m_weatherInfoAppHelper.findByPlaceNameAndHourAndMinute(placeName, hour, minute).spliterator(), false)
                        .map(m_weatherInfoMapper::toWeatherObservation).collect(Collectors.toList()));
    }
}
