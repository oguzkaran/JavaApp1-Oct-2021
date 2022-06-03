package org.csystem.app.service.rest.weather.data.repository;

import org.csystem.app.service.rest.weather.data.entity.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWeatherInfoRepository extends JpaRepository<WeatherInfo, Long> {
    //...
}
