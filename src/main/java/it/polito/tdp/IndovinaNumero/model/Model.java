package it.polito.tdp.IndovinaNumero.model;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class Model {
	
	private final int nmax =100; 
	private final int tmax = 10; 
	private int segreto ; 
	private int tentativifatti; 
	private boolean ingame = false; 
	
	private Set<Integer> tentativi1;
	
	public Model() {
		this.ingame = false; 
		this.tentativifatti = 0; 
		
	}
	
	public void nuovaParitita() { 
		
		this.segreto = (int)(Math.random() * nmax)+1; 
    	
    	
	    this.tentativifatti = 0; 
	    this.ingame = true; 
	    this.tentativi1=new HashSet<Integer>(); 
	}
	
	public int tentativo(int tentativo) {
		
		//controllo se la partita è in corso
		
		if(!ingame) {
			throw new IllegalStateException("La partita è già terminata !!");
		}
		
		
		//controllo l'input
		
		if(!tentativoValido(tentativo)) {
			throw new InvalidParameterException("Devi inserire un numero che non hai ancora utilizzato tra 1 e "+nmax + "\n"); 
			
		}
		
		//il tentativo e valido --> possiamo provarlo 
		this.tentativifatti++; 
		
		if(this.tentativifatti== tmax) {
			this.ingame = false; 
		}
		
		this.tentativi1.add(tentativo);
		
    	
		if(tentativo == this.segreto) {
			this.ingame = false; 
			return 0; 
		}
		
		//non ho indovinato 
		
		if(tentativo < this.segreto) {
			return -1; 
		}
		
		else {
			return 1; 
		}
	
		
	}
	
	private boolean tentativoValido(int tentativo) {
		if(tentativo<1 || tentativo>nmax) {
			return false;
		}
		else {
			if(this.tentativi1.contains(tentativo)){
				return false;
			}
			return true; 
		}
	}

	public int getSegreto() {
		return segreto;
	}

	public void setSegreto(int segreto) {
		this.segreto = segreto;
	}

	public int getTentativifatti() {
		return tentativifatti;
	}

	public void setTentativifatti(int tentativifatti) {
		this.tentativifatti = tentativifatti;
	}

	public int getTmax() {
		return tmax;
	}
}
