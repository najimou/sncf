package fr.upmc.bean;

/***********************************************************************
 * Module:  Voyage.java
 * Author:  Nicolas Pigeot
 * Purpose: Defines the Class Voyage
 ***********************************************************************/

import java.util.*;

public class Voyage {
   private int id;
   private String depart;
   private java.util.Date heureDepart;
   private String arrivee;
   private java.util.Date heureArrivee;
   private String numeroTrain;
   
   public ArrayList<Transport> transport;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getDepart() {
	return depart;
}

public void setDepart(String depart) {
	this.depart = depart;
}

public java.util.Date getHeureDepart() {
	return heureDepart;
}

public void setHeureDepart(java.util.Date heureDepart) {
	this.heureDepart = heureDepart;
}

public String getArrivee() {
	return arrivee;
}

public void setArrivee(String arrivee) {
	this.arrivee = arrivee;
}

public java.util.Date getHeureArrivee() {
	return heureArrivee;
}

public void setHeureArrivee(java.util.Date heureArrivee) {
	this.heureArrivee = heureArrivee;
}

public String getNumeroTrain() {
	return numeroTrain;
}

public void setNumeroTrain(String numeroTrain) {
	this.numeroTrain = numeroTrain;
}

public ArrayList<Transport> getTransport() {
	return transport;
}

public void setTransport(ArrayList<Transport> transport) {
	this.transport = transport;
}
   
   
  

}