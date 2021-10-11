package org.csystem.geonameswikipediasearcherviceapp.controller;

import org.csystem.geonameswikipediasearcherviceapp.service.WikipediaSearchService;
import org.csystem.geonameswikipediasearcherviceapp.viewmodel.WikipediaSearchInfo;
import org.csystem.geonameswikipediasearcherviceapp.viewmodel.WikipediaSearchViewModel;
import org.csystem.util.exception.ExceptionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/wikipedia")
public class WikipediaSearchRestController {
    private final WikipediaSearchService m_wikipediaSearchService;

    public WikipediaSearchRestController(WikipediaSearchService wikipediaSearchService)
    {
        m_wikipediaSearchService = wikipediaSearchService;
    }

    @GetMapping("/search")
    public WikipediaSearchViewModel getSearchInfo(@RequestParam("q") String text)
    {
        return ExceptionUtil.subscribe(() -> m_wikipediaSearchService.getSearchInfo(text), ex -> new WikipediaSearchViewModel());
    }

    @GetMapping("/searchiter")
    public Iterable<WikipediaSearchInfo> getSearchInfoIterable(@RequestParam("q") String text)
    {
        return ExceptionUtil.subscribe(() -> getSearchInfo(text).getGeonames(), ex -> new ArrayList<>());
    }
}
