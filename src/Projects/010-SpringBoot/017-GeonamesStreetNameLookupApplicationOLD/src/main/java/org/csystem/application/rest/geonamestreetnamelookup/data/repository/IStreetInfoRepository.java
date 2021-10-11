package org.csystem.application.rest.geonamestreetnamelookup.data.repository;

import org.csystem.application.rest.geonamestreetnamelookup.data.entity.StreetInfo;
import org.springframework.data.repository.CrudRepository;

public interface IStreetInfoRepository extends CrudRepository<StreetInfo, String> {

}
