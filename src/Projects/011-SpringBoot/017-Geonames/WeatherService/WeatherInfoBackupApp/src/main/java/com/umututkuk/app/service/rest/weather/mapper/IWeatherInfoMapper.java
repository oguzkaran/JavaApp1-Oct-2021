package com.umututkuk.app.service.rest.weather.mapper;

import org.csystem.app.weather.repository.backup.data.entity.WeatherInfo;
import org.mapstruct.Mapper;

@Mapper(implementationName = "WeatherInfoMapperImpl", componentModel = "spring")
public interface IWeatherInfoMapper {
    WeatherInfo toWeatherInfoBackup(org.csystem.app.weather.repository.data.entity.WeatherInfo weatherInfo);
}
