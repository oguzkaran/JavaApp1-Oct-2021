package org.csystem.geonameswikipediasearcherviceapp.viewmodel;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDateTime;

public class WikipediaSearchInfo {
    private int m_elevation;
    private int m_geoNameId;
    private String m_feature;
    private double m_longitude;
    private double m_latitude;
    private String m_countryCode;
    private int m_rank;
    private String m_thumbnailImg;
    private String m_language;
    private String m_title;
    private String m_wikipediaUrl;
    private LocalDateTime m_queryDate = LocalDateTime.now();

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public int getElevation()
    {
        return m_elevation;
    }

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public void setElevation(int elevation)
    {
        m_elevation = elevation;
    }

    public int getGeoNameId()
    {
        return m_geoNameId;
    }

    public void setGeoNameId(int geoNameId)
    {
        m_geoNameId = geoNameId;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getFeature()
    {
        return m_feature;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setFeature(String feature)
    {
        m_feature = feature;
    }

    @JsonGetter("longitude")
    public double getLongitude()
    {
        return m_longitude;
    }

    @JsonSetter("lng")
    public void setLongitude(double longitude)
    {
        m_longitude = longitude;
    }

    @JsonProperty("latitude")
    public double getLatitude()
    {
        return m_latitude;
    }

    @JsonProperty("lat")
    public void setLatitude(double latitude)
    {
        m_latitude = latitude;
    }

    public String getCountryCode()
    {
        return m_countryCode;
    }

    public void setCountryCode(String countryCode)
    {
        m_countryCode = countryCode;
    }

    public int getRank()
    {
        return m_rank;
    }

    public void setRank(int rank)
    {
        m_rank = rank;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getThumbnailImg()
    {
        return m_thumbnailImg;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setThumbnailImg(String thumbnailImg)
    {
        m_thumbnailImg = thumbnailImg;
    }

    @JsonGetter("language")
    public String getLanguage()
    {
        return m_language;
    }

    @JsonSetter("lang")
    public void setLanguage(String language)
    {
        m_language = language;
    }

    public String getTitle()
    {
        return m_title;
    }

    public void setTitle(String title)
    {
        m_title = title;
    }

    public String getWikipediaUrl()
    {
        return m_wikipediaUrl;
    }

    public void setWikipediaUrl(String wikipediaUrl)
    {
        m_wikipediaUrl = wikipediaUrl;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @JsonIgnore(value = true)
    public LocalDateTime getQueryDate()
    {
        return m_queryDate;
    }

    public void setQueryDate(LocalDateTime queryDate)
    {
        m_queryDate = queryDate;
    }
}
