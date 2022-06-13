package com.olcaycetin.app.service.rest.place.data.repository;

import com.olcaycetin.app.service.rest.place.data.entity.PlaceInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceInfoRepository extends CrudRepository<PlaceInfo, Integer> {
    //...
}