package org.csystem.geonameswikipediasearcherviceapp.viewmodel;

import java.util.List;

public class WikipediaSearchViewModel {
    private List<WikipediaSearchInfo> m_geonames;

    public WikipediaSearchViewModel()
    {}

    public WikipediaSearchViewModel(List<WikipediaSearchInfo> geonames)
    {
        m_geonames = geonames;
    }

    public List<WikipediaSearchInfo> getGeonames()
    {
        return m_geonames;
    }

    public void setGeonames(List<WikipediaSearchInfo> geonames)
    {
        m_geonames = geonames;
    }
}
