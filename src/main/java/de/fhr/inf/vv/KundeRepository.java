package de.fhr.inf.vv;

import org.springframework.data.repository.CrudRepository;

public interface KundeRepository extends
        CrudRepository<Kunde, Long> {

    Iterable<Kunde> findAll();

    Iterable<Kunde> findById(Long id);
}
