package org.csystem.app.weather.repository.data.dal;

import org.csystem.app.weather.repository.data.entity.PlaceInfo;
import org.csystem.app.weather.repository.data.entity.WeatherInfo;
import org.csystem.app.weather.repository.data.repository.IPlaceInfoRepository;
import org.csystem.app.weather.repository.data.repository.IWeatherInfoRepository;
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
