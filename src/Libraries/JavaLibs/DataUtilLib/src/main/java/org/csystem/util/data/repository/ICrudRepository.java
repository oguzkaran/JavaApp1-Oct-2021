package org.csystem.util.data.repository;

import java.util.Optional;

public interface ICrudRepository<Entity, ID> {
    long count();
    void delete(Entity entity);
    void deleteAll();
    void deleteAll(Iterable<? extends Entity> entities);
    void deleteById(ID id);
    boolean existsById(ID id);
    Iterable<Entity> findAll();
    Iterable<Entity> findAllById(Iterable<ID> ids);
    Optional<Entity> findById(ID id);
    <S extends Entity> S save(S entity);
    <S extends Entity> Iterable<S> save(Iterable<S> entities);
}
