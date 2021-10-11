package org.csystem.application.rest.postalcode.data.repository;

import org.csystem.application.rest.postalcode.data.entity.PostalCodeInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IPostalCodeInfoRepository extends CrudRepository<PostalCodeInfo, Long> {
    @Query("select pi from PostalCodeInfo pi where pi.postalCode.postalCode = :postalCode")
    Iterable<PostalCodeInfo> findByPostalCode(int postalCode);
}
