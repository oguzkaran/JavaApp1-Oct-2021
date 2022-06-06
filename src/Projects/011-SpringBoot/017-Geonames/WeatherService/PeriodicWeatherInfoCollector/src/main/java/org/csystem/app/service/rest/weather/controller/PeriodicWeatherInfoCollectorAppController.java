package org.csystem.app.service.rest.weather.controller;

import org.csystem.app.service.rest.weather.data.entity.PlaceInfo;
import org.csystem.app.service.rest.weather.service.PeriodicWeatherInfoCollectorAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weather/info")
public class PeriodicWeatherInfoCollectorAppController {
    private final PeriodicWeatherInfoCollectorAppService m_periodicWeatherInfoCollectorAppService;

    public PeriodicWeatherInfoCollectorAppController(PeriodicWeatherInfoCollectorAppService periodicWeatherInfoCollectorAppService)
    {
        m_periodicWeatherInfoCollectorAppService = periodicWeatherInfoCollectorAppService;
    }

    @GetMapping("place/name")
    public PlaceInfo findPlaceWeatherInfoByPlaceName(@RequestParam("n") String placeName)
    {
        return m_periodicWeatherInfoCollectorAppService.findPlaceWeatherInfoByPlaceName(placeName);
    }
}
