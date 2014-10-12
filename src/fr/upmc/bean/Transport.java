package fr.upmc.bean;

/***********************************************************************
 * Module:  Transport.java
 * Author:  Nicolas Pigeot
 * Purpose: Defines the Class Transport
 ***********************************************************************/


public class Transport {
   private boolean accepted;
   private int idTransporteur;
   private boolean finished;
public boolean isAccepted() {
	return accepted;
}
public void setAccepted(boolean accepted) {
	this.accepted = accepted;
}
public int getIdTransporteur() {
	return idTransporteur;
}
public void setIdTransporteur(int idTransporteur) {
	this.idTransporteur = idTransporteur;
}
public boolean isFinished() {
	return finished;
}
public void setFinished(boolean finished) {
	this.finished = finished;
}

   
   
}