package fr.ych.userstory.primes_portal.repo;

import org.springframework.data.repository.Repository;

import fr.ych.userstory.primes_portal.model.AliquotNumber;

import java.util.List;

public interface AliquotNumberRepository extends Repository<AliquotNumber, Long> {


    List<AliquotNumber> findAll();
    
    AliquotNumber findOne(long id);

    AliquotNumber save(AliquotNumber client);
}
