package org.csystem.app.randomuser.collector.data.repository;

import org.csystem.app.randomuser.collector.data.entity.RandomUserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRandomUserInfoRepository extends CrudRepository<RandomUserInfo, Integer> {

}
