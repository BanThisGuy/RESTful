package de.fhr.inf.vv;

import org.springframework.data.repository.CrudRepository;

public interface VertraegeRepository extends CrudRepository<Vertraege, Long> {

    Iterable<Vertraege> findAll();

    Iterable<Vertraege> findById(Long id);
}