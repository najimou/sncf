package fr.upmc.bean;

import java.io.Serializable;


public class Train implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private String dateDepart;
	private String numero;
	private String miss; 
	private String term; 

	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getMiss() {
		return miss;
	}

	public void setMiss(String miss) {
		this.miss = miss;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


}
