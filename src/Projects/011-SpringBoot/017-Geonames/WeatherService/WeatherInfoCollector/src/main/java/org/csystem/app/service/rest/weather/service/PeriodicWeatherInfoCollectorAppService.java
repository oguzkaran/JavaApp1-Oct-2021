package org.csystem.app.service.rest.weather.service;

import org.csystem.app.service.rest.weather.data.dal.WeatherInfoCollectorAppHelper;
import org.csystem.app.service.rest.weather.data.entity.PlaceInfo;
import org.springframework.stereotype.Component;

@Component
public class PeriodicWeatherInfoCollectorAppService {
    private final WeatherInfoCollectorAppHelper m_periodicWeatherInfoHelper;

    public PeriodicWeatherInfoCollectorAppService(WeatherInfoCollectorAppHelper periodicWeatherInfoHelper)
    {
        m_periodicWeatherInfoHelper = periodicWeatherInfoHelper;
    }

    public PlaceInfo findPlaceWeatherInfoByPlaceName(String placeName)
    {
        return m_periodicWeatherInfoHelper.findPlaceWeatherInfoByPlaceName(placeName);
    }

    //...
}
