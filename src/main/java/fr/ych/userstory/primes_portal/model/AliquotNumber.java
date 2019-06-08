package fr.ych.userstory.primes_portal.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aliquot_seq_factors")
public class AliquotNumber implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4117654738441594965L;

	@Id
    @Column
    private long number;

    @Column
    private String factors;
    @Column
    private long sprime;
    
    @Column
    private long sprime2;

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getFactors() {
		return factors;
	}

	public void setFactors(String factors) {
		this.factors = factors;
	}

	public long getSprime() {
		return sprime;
	}

	public void setSprime(long sprime) {
		this.sprime = sprime;
	}

	public long getSprime2() {
		return sprime2;
	}

	public void setSprime2(long sprime2) {
		this.sprime2 = sprime2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
