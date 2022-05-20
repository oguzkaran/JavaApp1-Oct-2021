package org.csystem.app.service.geonames.wikisearch.wikisearch;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class WikiSearchGeo {
    public ArrayList<WikiSearchInfoGeo> m_wikiSearchInfoGeos;

    public ArrayList<WikiSearchInfoGeo> getWikiSearchGeos()
    {
        return m_wikiSearchInfoGeos;
    }

    @JsonProperty("geonames")
    public void setWikiSearchGeos(ArrayList<WikiSearchInfoGeo> wikiSearchInfoGeos)
    {
        m_wikiSearchInfoGeos = wikiSearchInfoGeos;
    }
}