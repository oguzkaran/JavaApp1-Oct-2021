package org.csystem.app.service.rest.weather.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather_information")
public class WeatherInfo { //POJO (Plain Old Java Object)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_informaiton_id")
    public long id;
    public double lng;
    public String observation;
    public String iCAO;
    public String clouds;
    public String dewPoint;
    public String cloudsCode;
    public String datetime;
    public String temperature;
    public int humidity;
    public String stationName;
    public String weatherCondition;
    public int windDirection;
    public String windSpeed;
    public double lat;
    public String weatherConditionCode;
    public double seaLevelPressure;
    public int hectoPascAltimeter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_info_id", nullable = false)
    public PlaceInfo placeInfo;
}
