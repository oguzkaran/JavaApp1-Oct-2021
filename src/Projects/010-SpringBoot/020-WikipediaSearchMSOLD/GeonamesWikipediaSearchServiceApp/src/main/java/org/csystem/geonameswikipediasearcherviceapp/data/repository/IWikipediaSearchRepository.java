package org.csystem.geonameswikipediasearcherviceapp.data.repository;

import org.csystem.geonameswikipediasearcherviceapp.data.entity.WikipediaSearch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IWikipediaSearchRepository extends CrudRepository<WikipediaSearch, Long> {
    //@Query("from WikipediaSearch w where w.text=:text")
    Iterable<WikipediaSearch> findByText(String text);
    boolean existsAllByText(String text);
}
