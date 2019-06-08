package fr.ych.userstory.primes_portal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import fr.ych.userstory.primes_portal.model.AliquotNumber;
import fr.ych.userstory.primes_portal.repo.AliquotNumberRepository;
import fr.ych.userstory.primes_portal.service.AliquotService;

@Service
@Transactional
public class AliquotServiceImpl implements AliquotService {

    @Autowired
    private AliquotNumberRepository aliquotNumberRepository;


    @Cacheable("aliquotCache")
    public List<AliquotNumber> findAll() {
        return aliquotNumberRepository.findAll();
    }
    
    @Cacheable("aliquotCache")
    public AliquotNumber findById(long id) {
        return aliquotNumberRepository.findOne(id);
    }

    public AliquotNumber update(AliquotNumber account) {
        return aliquotNumberRepository.save(account);
    }

}
