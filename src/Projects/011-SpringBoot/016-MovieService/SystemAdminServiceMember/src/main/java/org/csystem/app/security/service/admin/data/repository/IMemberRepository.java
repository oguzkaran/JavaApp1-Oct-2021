package org.csystem.app.security.service.admin.data.repository;

import org.csystem.app.security.service.admin.data.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMemberRepository extends CrudRepository<Member, Integer> {
    Optional<Member> findByEnabledAndUsernameAndPassword(boolean enabled, String username, String password);
    Iterable<Member> findByEnabled(boolean enabled);
}
