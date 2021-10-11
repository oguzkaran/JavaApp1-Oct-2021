package org.csystem.geonameswikipediasearcherviceapp.data.repository;

import org.csystem.geonameswikipediasearcherviceapp.data.entity.WikipediaSearch;
import org.springframework.data.repository.CrudRepository;

public interface IWikipediaSearchRepository extends CrudRepository<WikipediaSearch, Long> {
    Iterable<WikipediaSearch> findByText(String text);

    boolean existsAllByText(String text);
}
