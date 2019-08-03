package fr.ych.userstory.primes_portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ych.userstory.primes_portal.model.AliquotNumber;
import fr.ych.userstory.primes_portal.repo.AliquotNumberRepository;
import fr.ych.userstory.primes_portal.service.AliquotService;
import fr.ych.userstory.primes_portal.service.BatchComputeService;
import fr.ych.userstory.primes_portal.tools.FactorizationTools;

@Service
public class BatchComputeServiceImpl implements BatchComputeService {


    @Autowired
    private AliquotService aliquotService;
    
    @Autowired
    private AliquotNumberRepository aliquotNumberRepository;
	
	@Override
	public void startBatchComputeAliquot(long startIndex, long endIndex) {
		long debut=System.currentTimeMillis();
		
		for(long i=startIndex;i<endIndex;i++)
		{
			AliquotNumber an=FactorizationTools.sigma(i);
			aliquotNumberRepository.save(an);
			
			//AliquotNumber an=aliquotService.findById(i);


			if(i%1000==0)
			{
				System.out.println("i="+i+"  "+an);
			}
			
			
		}
		
		
		
	    long fin=System.currentTimeMillis();
	    
	    System.out.println("timing : "+(fin-debut));
	}
	
}
