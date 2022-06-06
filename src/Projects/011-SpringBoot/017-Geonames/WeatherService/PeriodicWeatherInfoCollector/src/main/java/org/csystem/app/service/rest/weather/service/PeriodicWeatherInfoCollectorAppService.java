package org.csystem.app.service.rest.weather.service;

import org.csystem.app.service.rest.weather.data.dal.PeriodicWeatherInfoHelper;
import org.csystem.app.service.rest.weather.data.entity.PlaceInfo;
import org.springframework.stereotype.Component;

@Component
public class PeriodicWeatherInfoCollectorAppService {
    private final PeriodicWeatherInfoHelper m_periodicWeatherInfoHelper;

    public PeriodicWeatherInfoCollectorAppService(PeriodicWeatherInfoHelper periodicWeatherInfoHelper)
    {
        m_periodicWeatherInfoHelper = periodicWeatherInfoHelper;
    }

    public PlaceInfo findPlaceWeatherInfoByPlaceName(String placeName)
    {
        return m_periodicWeatherInfoHelper.findPlaceWeatherInfoByPlaceName(placeName);
    }

    //...
}
