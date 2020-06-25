package fr.ych.userstory.primes_portal.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.ych.userstory.primes_portal.model.AliquotNumber;

public class SigmaPairs {
	
	public static final long XMAX=10000000;
	
	
	public static void main(String[] args) throws IOException {
		double somme=0;
		for(int i=1;i<XMAX;i++)
		{
			long k=3*i+1;
			long j=3*i+2;
			AliquotNumber an=FactorizationTools.sigma(k);
			long sigma=an.getSprime();
			if(sigma<XMAX)
            somme=somme+((1.0*sigma)/j);
            
            
            
			if(i%100000==0)
			System.out.println("k="+k+" sigma="+sigma+" factors="+an.getFactors()+"  somme="+somme);
			
		}

	}

	public static void mainw(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream("c:/mesdevs/aliquot/sigmapairs.txt");
		for(int i=1;i<XMAX;i++)
		{
			long k=2*i;
			AliquotNumber an=FactorizationTools.sigma(k);
			long sigma=an.getSprime();
			fos.write((k+";"+sigma+";"+an.getFactors()+'\n').getBytes());
			if(i%1000000==0)
			System.out.println("k="+k+" sigma="+sigma+" factors="+an.getFactors());
			
		}
		fos.close();

	}
	
	public static void mainr(String[] args) throws IOException {
		Map<Long, Double> listRnValues=new HashMap<Long, Double>();
	    try {
		  FileOutputStream fos=new FileOutputStream("c:/mesdevs/aliquot/rnpairs.txt");
	      File myObj = new File("c:/mesdevs/aliquot/sigmapairs.txt");
	      Scanner myReader = new Scanner(myObj);
	      int compteur=0;
	      double[] valuesRnTab=new double[(int)XMAX];
	      while (myReader.hasNextLine()) {
	    	compteur++;
	        String data = myReader.nextLine();
	        String[] datatab=data.split(";");
	        long number=Long.parseLong(datatab[0]);
	        long sigma=Long.parseLong(datatab[1]);
	        /*Double rescur=listRnValues.get(sigma);
	        if(rescur==null)
	        {
	        	rescur=new Double(sigma);
	        }
	        else {
	        	rescur=rescur.doubleValue()+((1.0*sigma)/number);
	        }
	        listRnValues.put(sigma, rescur);*/
	        if(sigma<XMAX)
	        valuesRnTab[(int)sigma]=valuesRnTab[(int)sigma]+((1.0*sigma)/number);
	        
	        if(compteur%10000==0)
              System.out.println(data);
	      }
	      myReader.close();
	      for(int i=1;i<XMAX/2;i++)
	      {
	    	  long k=2*i;
	    	  double rn=valuesRnTab[(int)k];
			  fos.write((k+";"+rn+'\n').getBytes());
	    	  
	      }
	      fos.close();
	      
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }

	
	public static void mainanalyse(String[] args) throws IOException {
	    try {
	      File myObj = new File("c:/mesdevs/aliquot/rnpairs.txt");
	      Scanner myReader = new Scanner(myObj);
	      double somme=0;
	      double sommernsurn=0;

	      double rapprtMax=0;
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        String[] datatab=data.split(";");
	        long number=Long.parseLong(datatab[0]);
	        double rn=Double.parseDouble(datatab[1]);
	        
	       somme=somme+rn;
	       sommernsurn=sommernsurn+(rn/number);
	       
	       double rapport=rn/Math.log(number);
	       if(rapport>rapprtMax)
	       {
	    	   rapprtMax=rapport;
	       }
	        
	        if(number%100000==0)
              System.out.println("number="+number+"  sommernsurn="+sommernsurn+"  log="+Math.log(number)+"  rapprtMax="+rapprtMax);
	      }
	      myReader.close();

	      
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }

	
}
