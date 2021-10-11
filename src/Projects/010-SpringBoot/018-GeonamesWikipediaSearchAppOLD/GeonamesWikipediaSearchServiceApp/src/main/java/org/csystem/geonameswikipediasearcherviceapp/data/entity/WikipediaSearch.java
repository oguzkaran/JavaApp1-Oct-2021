package org.csystem.geonameswikipediasearcherviceapp.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="wiki_searchs")
public class WikipediaSearch { //POJO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wiki_search_id")
    private long m_id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "elevation", nullable = false)
    private int elevation;

    @Column(name = "geoname_id")
    private int geoNameId;

    @Column(name = "feature")
    private String feature;

    @Column(name = "longitude", nullable = false)
    private double lng;

    @Column(name = "latitude", nullable = false)
    private double lat;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(name = "rank", nullable = false)
    private int rank;

    @Column(name = "thumbnail_image")
    private String thumbnailImg;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "wikipedia_url", nullable = false)
    private String wikiUrl;

    @Column(name = "query_datetime", nullable = false)
    private LocalDateTime queryDateTime = LocalDateTime.now();

    public long getId()
    {
        return m_id;
    }

    public void setId(long id)
    {
        m_id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public int getElevation()
    {
        return elevation;
    }

    public void setElevation(int elevation)
    {
        this.elevation = elevation;
    }

    public int getGeoNameId()
    {
        return geoNameId;
    }

    public void setGeoNameId(int geoNameId)
    {
        this.geoNameId = geoNameId;
    }

    public String getFeature()
    {
        return feature;
    }

    public void setFeature(String feature)
    {
        this.feature = feature;
    }

    public double getLng()
    {
        return lng;
    }

    public void setLng(double lng)
    {
        this.lng = lng;
    }

    public double getLat()
    {
        return lat;
    }

    public void setLat(double lat)
    {
        this.lat = lat;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    public int getRank()
    {
        return rank;
    }

    public void setRank(int rank)
    {
        this.rank = rank;
    }

    public String getThumbnailImg()
    {
        return thumbnailImg;
    }

    public void setThumbnailImg(String thumbnailImg)
    {
        this.thumbnailImg = thumbnailImg;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getWikiUrl()
    {
        return wikiUrl;
    }

    public void setWikiUrl(String wikiUrl)
    {
        this.wikiUrl = wikiUrl;
    }

    public LocalDateTime getQueryDateTime()
    {
        return queryDateTime;
    }

    public void setQueryDateTime(LocalDateTime queryDateTime)
    {
        this.queryDateTime = queryDateTime;
    }
}
