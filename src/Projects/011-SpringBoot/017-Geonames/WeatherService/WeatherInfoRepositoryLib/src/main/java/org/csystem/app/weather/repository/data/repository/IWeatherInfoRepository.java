package org.csystem.app.weather.repository.data.repository;

import org.csystem.app.weather.repository.data.entity.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWeatherInfoRepository extends JpaRepository<WeatherInfo, Long> {

}
