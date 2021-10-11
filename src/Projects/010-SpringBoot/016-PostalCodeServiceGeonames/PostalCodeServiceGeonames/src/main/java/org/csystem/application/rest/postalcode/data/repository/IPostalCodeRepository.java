package org.csystem.application.rest.postalcode.data.repository;

import org.csystem.application.rest.postalcode.data.entity.PostalCode;
import org.springframework.data.repository.CrudRepository;

public interface IPostalCodeRepository extends CrudRepository<PostalCode, Integer> {

}
