package fr.ych.userstory.primes_portal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import fr.ych.userstory.primes_portal.model.AliquotNumber;
import fr.ych.userstory.primes_portal.repo.AliquotNumberRepository;
import fr.ych.userstory.primes_portal.service.AliquotService;
import fr.ych.userstory.primes_portal.tools.FactorizationTools;

@Service
@Transactional
public class AliquotServiceImpl implements AliquotService {

    @Autowired
    private AliquotNumberRepository aliquotNumberRepository;


    public List<AliquotNumber> findAll() {
        return aliquotNumberRepository.findAll();
    }
    
    @Cacheable("aliquotCache")
    public AliquotNumber findById(long id) {
    	AliquotNumber result=aliquotNumberRepository.findOne(id);
    	if(result==null)
    	{
    	    result=FactorizationTools.sigma(id);
    		
			//aliquotNumberRepository.save(result);
    	}
        return result;
    }

    public AliquotNumber update(AliquotNumber account) {
        return aliquotNumberRepository.save(account);
    }

}
