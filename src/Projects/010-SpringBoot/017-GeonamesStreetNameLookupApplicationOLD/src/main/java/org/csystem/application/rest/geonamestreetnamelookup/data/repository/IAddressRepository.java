package org.csystem.application.rest.geonamestreetnamelookup.data.repository;

import org.csystem.application.rest.geonamestreetnamelookup.data.entity.AddressInfo;
import org.springframework.data.repository.CrudRepository;

public interface IAddressRepository extends CrudRepository<AddressInfo, String> {

}
