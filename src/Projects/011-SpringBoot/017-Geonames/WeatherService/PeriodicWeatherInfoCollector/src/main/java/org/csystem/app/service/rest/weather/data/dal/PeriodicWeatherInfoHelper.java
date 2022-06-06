package org.csystem.app.service.rest.weather.data.dal;

import org.csystem.app.service.rest.weather.data.entity.PlaceInfo;
import org.csystem.app.service.rest.weather.data.repository.IPlaceInfoRepository;
import org.csystem.app.service.rest.weather.data.repository.IWeatherInfoRepository;
import org.springframework.stereotype.Component;

@Component
public class PeriodicWeatherInfoHelper {
    private final IPlaceInfoRepository m_placeInfoRepository;

    public PeriodicWeatherInfoHelper(IPlaceInfoRepository placeInfoRepository)
    {
        m_placeInfoRepository = placeInfoRepository;
    }

    public Iterable<PlaceInfo> findAllPlaces()
    {
        return m_placeInfoRepository.findAll();
    }

    public void savePlaceInfo(PlaceInfo placeInfo)
    {
        m_placeInfoRepository.save(placeInfo);
    }


    public PlaceInfo findPlaceWeatherInfoByPlaceName(String placeName)
    {
        return m_placeInfoRepository.findByPlaceName(placeName);
    }

    //...
}
