package org.csystem.app.weather.repository.data.repository;

import org.csystem.app.weather.repository.data.entity.PlaceInfo;
import org.csystem.app.weather.repository.data.entity.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface IWeatherInfoRepository extends JpaRepository<WeatherInfo, Long> {
    boolean existsByPlaceInfoAndDatetime(@Param("pi") PlaceInfo pi, @Param("dateTime") LocalDateTime dateTime);
}
