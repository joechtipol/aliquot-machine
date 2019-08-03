package fr.ych.userstory.primes_portal.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import fr.ych.userstory.primes_portal.model.AliquotNumber;

public class FactorizationTools {
	
	public static AliquotNumber sigma(long N)
	{
		AliquotNumber an=new AliquotNumber();
		Map<Long,Long> mapfactors = primeFactorsMap(N);
		an.setFactors(mapfactors.toString());
        long sommeDiviseur=1;
		Iterator<Long> ite=mapfactors.keySet().iterator();
		
		
		while(ite.hasNext())
		{
			long prime=ite.next();
			long power=mapfactors.get(prime);
			
			sommeDiviseur=sommeDiviseur*getSommeDiviserurPrimeProper(prime,power);
			
		}
		
		sommeDiviseur=sommeDiviseur-N;

		an.setSprime(sommeDiviseur);
		return an;
		
	}
	
	
	public static Map<Long,Long> primeFactorsMap(long numbers) {
	    long n = numbers;
	    List<Long> factors = new ArrayList<Long>();
	    
	    Map<Long,Long> factorsMap = new HashMap<Long, Long>();

	    for (long i = 2; i <= n / i; i++) {
	      while (n % i == 0) {
	        factors.add(i);
	        
	        long compteur=0;
		      if(factorsMap.get(i)!=null)
		      {
		    	  compteur=factorsMap.get(i);
		      }
		      factorsMap.put(i, compteur+1);
	        
	        n /= i;
	      }
	    }
	    if (n > 1) {
	      factors.add(n);
	      long compteur=0;
	      if(factorsMap.get(n)!=null)
	      {
	    	  compteur=factorsMap.get(n);
	      }
	      factorsMap.put(n, compteur+1);
	      
	      
	    }
	    return factorsMap;
	  }
	
	public static long getSommeDiviserurPrimeProper(long prime,long power)
	{
		long resultat=0;
		for(int i=0;i<power+1;i++)
		{
			resultat=resultat+(int) Math.pow(prime, i);
		}
		
		
		return resultat;
	}
  

}
