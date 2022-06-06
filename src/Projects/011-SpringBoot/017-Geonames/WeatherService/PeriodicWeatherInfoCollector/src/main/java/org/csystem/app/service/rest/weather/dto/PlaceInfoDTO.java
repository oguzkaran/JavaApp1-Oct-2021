package org.csystem.app.service.rest.weather.dto;

import org.csystem.app.service.rest.weather.data.entity.WeatherInfo;

import java.util.List;
import java.util.Set;

public class PlaceInfoDTO {
    private String m_name;

    private double m_north;

    private double m_south;

    private double m_east;

    private double m_west;

    private List<WeatherInfo> m_weatherInfos;

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public double getNorth()
    {
        return m_north;
    }

    public void setNorth(double north)
    {
        m_north = north;
    }

    public double getSouth()
    {
        return m_south;
    }

    public void setSouth(double south)
    {
        m_south = south;
    }

    public double getEast()
    {
        return m_east;
    }

    public void setEast(double east)
    {
        m_east = east;
    }

    public double getWest()
    {
        return m_west;
    }

    public void setWest(double west)
    {
        m_west = west;
    }

    public List<WeatherInfo> getWeatherInfos()
    {
        return m_weatherInfos;
    }

    public void setWeatherInfos(List<WeatherInfo> weatherInfos)
    {
        m_weatherInfos = weatherInfos;
    }
}
