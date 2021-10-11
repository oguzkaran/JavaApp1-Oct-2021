package org.csystem.geonameswikipediasearcherviceapp.data.dal;

import ch.qos.logback.core.db.dialect.DBUtil;
import org.csystem.geonameswikipediasearcherviceapp.data.entity.WikipediaSearch;
import org.csystem.geonameswikipediasearcherviceapp.data.repository.IWikipediaSearchRepository;
import org.csystem.util.data.wrapper.DbUtil;
import org.springframework.stereotype.Component;

import javax.swing.text.html.HTMLEditorKit;

@Component
public class WikipediaSearchHelper {
    private final IWikipediaSearchRepository m_wikipediaSearchRepository;

    public WikipediaSearchHelper(IWikipediaSearchRepository wikipediaSearchRepository)
    {
        m_wikipediaSearchRepository = wikipediaSearchRepository;
    }

    public Iterable<WikipediaSearch> findSearchsByText(String text)
    {
        return DbUtil.doWorkForRepository(() -> m_wikipediaSearchRepository.findByText(text),"WikipediaSearchHelper.findSearchsByText");
    }

    public boolean exitsByText(String text)
    {
        return DbUtil.doWorkForRepository(() -> m_wikipediaSearchRepository.existsAllByText(text), "WikipediaSearchHelper.exitsByText");
    }

    public Iterable<WikipediaSearch> saveAllSearchs(Iterable<WikipediaSearch> wikipediaSearches)
    {
        return DbUtil.doWorkForRepository(() -> m_wikipediaSearchRepository.saveAll(wikipediaSearches), "WikipediaSearchHelper.saveAllSearchs");
    }
}
