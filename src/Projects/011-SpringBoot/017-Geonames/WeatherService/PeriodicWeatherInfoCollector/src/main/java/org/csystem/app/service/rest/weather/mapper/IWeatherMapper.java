package org.csystem.app.service.rest.weather.mapper;

import org.csystem.app.service.rest.weather.data.entity.PlaceInfo;
import org.csystem.app.service.rest.weather.data.entity.WeatherInfo;
import org.csystem.app.service.rest.weather.geonames.WeatherObservation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "PlaceInfoMapperImpl", componentModel = "spring")
public interface IWeatherMapper {
    WeatherInfo toWeatherInfo(WeatherObservation weatherObservation);
}
