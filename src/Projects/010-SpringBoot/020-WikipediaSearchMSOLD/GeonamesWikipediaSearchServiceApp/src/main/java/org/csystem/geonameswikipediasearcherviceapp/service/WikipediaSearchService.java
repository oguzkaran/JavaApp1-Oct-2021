package org.csystem.geonameswikipediasearcherviceapp.service;

import org.csystem.geonameswikipediasearcherviceapp.data.dal.WikipediaSearchHelper;
import org.csystem.geonameswikipediasearcherviceapp.data.entity.WikipediaSearch;
import org.csystem.geonameswikipediasearcherviceapp.service.mapper.IWikipediaSearchMapper;
import org.csystem.geonameswikipediasearcherviceapp.viewmodel.WikipediaSearchViewModel;
import org.csystem.util.data.wrapper.DbUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class WikipediaSearchService {
    private final WikipediaSearchHelper m_wikipediaSearchHelper;
    private final RestTemplate m_restTemplate;
    private final IWikipediaSearchMapper m_wikipediaSearchMapper;
    @Value("${geonames.url}")
    private String m_urlTemplate;

    private WikipediaSearchViewModel getByRest(String text)
    {
        var url = String.format(m_urlTemplate, text);

        return m_restTemplate.getForObject(url, WikipediaSearchViewModel.class);
    }

    private WikipediaSearchViewModel getBySearchs(Iterable<WikipediaSearch> wikipediaSearches)
    {
        return new WikipediaSearchViewModel(StreamSupport.stream(wikipediaSearches.spliterator(), false)
                .map(m_wikipediaSearchMapper::wikipediaSearchToWikipediaSearchInfo)
                .collect(Collectors.toList()));
    }

    private WikipediaSearchViewModel getSearchInfoCallback(String text)
    {
        if (m_wikipediaSearchHelper.exitsByText(text))
            return getBySearchs(m_wikipediaSearchHelper.findSearchsByText(text));

        var model = getByRest(text);
        var list = model.getGeonames().stream()
                .map(m_wikipediaSearchMapper::wikipediaSearchInfoToWikipediaSearch)
                .peek(ws -> ws.setText(text))
                .collect(Collectors.toList());

        m_wikipediaSearchHelper.saveAllSearchs(list);

        return model;
    }

    public WikipediaSearchService(WikipediaSearchHelper wikipediaSearchHelper, RestTemplate restTemplate, IWikipediaSearchMapper wikipediaSearchMapper)
    {
        m_wikipediaSearchHelper = wikipediaSearchHelper;
        m_restTemplate = restTemplate;
        m_wikipediaSearchMapper = wikipediaSearchMapper;
    }

    public WikipediaSearchViewModel getSearchInfo(String text)
    {
        return DbUtil.doWorkForService(() -> getSearchInfoCallback(text), "WikipediaSearchService.getSearchInfo");
    }
}
