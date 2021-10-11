package org.csystem.geonameswikipediasearcherviceapp.service.mapper;

import org.csystem.geonameswikipediasearcherviceapp.data.entity.WikipediaSearch;
import org.csystem.geonameswikipediasearcherviceapp.viewmodel.WikipediaSearchInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(implementationName = "WikipediaSearchMapperImpl", componentModel = "spring")
public interface IWikipediaSearchMapper {
    @Mappings({
            @Mapping(target = "lat", source = "wikipediaSearchInfo.latitude"),
            @Mapping(target = "lng", source = "wikipediaSearchInfo.longitude"),
            @Mapping(target = "wikiUrl", source = "wikipediaSearchInfo.wikipediaUrl"),
            @Mapping(target = "queryDateTime", source = "wikipediaSearchInfo.queryDate"),
    })
    WikipediaSearch wikipediaSearchInfoToWikipediaSearch(WikipediaSearchInfo wikipediaSearchInfo);

    @Mappings({
            @Mapping(target = "latitude", source = "wikipediaSearch.lat"),
            @Mapping(target = "longitude", source = "wikipediaSearch.lng"),
            @Mapping(target = "wikipediaUrl", source = "wikipediaSearch.wikiUrl"),
            @Mapping(target = "queryDate", source = "wikipediaSearch.queryDateTime"),
    })
    WikipediaSearchInfo wikipediaSearchToWikipediaSearchInfo(WikipediaSearch wikipediaSearch);
}
