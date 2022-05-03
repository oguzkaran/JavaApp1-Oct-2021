package org.csystem.app.security.service.admin.data.repository;

import org.csystem.app.security.service.admin.data.entity.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface IMemberRepository extends CrudRepository<Member, Integer> {
    @Query("from Member m where m.enabled = :enabled and m.username = :username and m.password = :password") //JQL ve HQL gösterimi için yazıldı yazılmasa da olur
    Optional<Member> findByEnabledAndUsernameAndPassword(boolean enabled, String username, String password);

    //@Query("from Member m where m.enabled = :enabled") //JQL ve HQL gösterimi için yazıldı yazılmasa da olur
    Iterable<Member> findByEnabled(@Param("enabled") boolean enabled);

    @Query("select m from Member m where m.registerDate = :registerDate") //JQL ve HQL gösterimi için yazıldı yazılmasa da olur
    Iterable<Member> findByRegisterDate(LocalDate registerDate);

    @Query(value = "select * from members where date_part('year', register_date) = :year", nativeQuery = true)
    Iterable<Member> findByYear(int year);
}
