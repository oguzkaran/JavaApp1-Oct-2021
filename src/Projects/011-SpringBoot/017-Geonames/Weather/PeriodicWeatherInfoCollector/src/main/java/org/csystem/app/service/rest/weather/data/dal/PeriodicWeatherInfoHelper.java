package org.csystem.app.service.rest.weather.data.dal;

import org.csystem.app.service.rest.weather.data.entity.PlaceInfo;
import org.csystem.app.service.rest.weather.data.repository.IPlaceInfoRepository;
import org.csystem.app.service.rest.weather.data.repository.IWeatherInfoRepository;
import org.springframework.stereotype.Component;

@Component
public class PeriodicWeatherInfoHelper {
    private final IWeatherInfoRepository m_weatherInfoRepository;
    private final IPlaceInfoRepository m_placeInfoRepository;

    public PeriodicWeatherInfoHelper(IWeatherInfoRepository weatherInfoRepository, IPlaceInfoRepository placeInfoRepository)
    {
        m_weatherInfoRepository = weatherInfoRepository;
        m_placeInfoRepository = placeInfoRepository;
    }

    public Iterable<PlaceInfo> findAllPlaces()
    {
        return m_placeInfoRepository.findAll();
    }

    //...
}
