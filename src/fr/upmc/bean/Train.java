package fr.upmc.bean;

import java.io.Serializable;


public class Train extends MasterBEAN implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	private int number;
	
	private char status;

	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	
	
	

}
