package org.csystem.app.service.rest.weather.mapper;

import org.csystem.app.service.rest.weather.data.entity.PlaceInfo;
import org.csystem.app.service.rest.weather.data.entity.WeatherInfo;
import org.csystem.app.service.rest.weather.dto.PlaceInfoDTO;
import org.csystem.app.service.rest.weather.geonames.WeatherObservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "WeatherInfoMapperImpl", componentModel = "spring")
public interface IWeatherInfoMapper {
    WeatherInfo toWeatherInfo(WeatherObservation weatherObservation);

    @Mapping(source = "placeName", target = "name")
    PlaceInfoDTO toPlaceInfo(PlaceInfo placeInfo);
}
