package fr.ych.userstory.primes_portal.service;

import java.util.List;

import fr.ych.userstory.primes_portal.model.AliquotNumber;


public interface AliquotService {

    List<AliquotNumber> findAll();

    AliquotNumber findById(long id);
    
    AliquotNumber update(AliquotNumber account);
    
}


