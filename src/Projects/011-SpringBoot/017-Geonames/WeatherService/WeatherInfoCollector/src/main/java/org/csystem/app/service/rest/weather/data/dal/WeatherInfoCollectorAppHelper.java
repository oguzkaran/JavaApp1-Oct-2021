package org.csystem.app.service.rest.weather.data.dal;

import org.csystem.app.service.rest.weather.data.entity.PlaceInfo;
import org.csystem.app.service.rest.weather.data.entity.WeatherInfo;
import org.csystem.app.service.rest.weather.data.repository.IPlaceInfoRepository;
import org.csystem.app.service.rest.weather.data.repository.IWeatherInfoRepository;
import org.springframework.stereotype.Component;

@Component
public class WeatherInfoCollectorAppHelper {
    private final IPlaceInfoRepository m_placeInfoRepository;
    private final IWeatherInfoRepository m_weatherInfoRepository;

    public WeatherInfoCollectorAppHelper(IPlaceInfoRepository placeInfoRepository, IWeatherInfoRepository weatherInfoRepository)
    {
        m_placeInfoRepository = placeInfoRepository;
        m_weatherInfoRepository = weatherInfoRepository;
    }

    public Iterable<PlaceInfo> findAllPlaces()
    {
        return m_placeInfoRepository.findAll();
    }

    public void saveWeatherInfo(WeatherInfo weatherInfo)
    {
        m_weatherInfoRepository.save(weatherInfo);
    }


    public PlaceInfo findPlaceWeatherInfoByPlaceName(String placeName)
    {
        return m_placeInfoRepository.findByPlaceName(placeName);
    }

    //...
}
