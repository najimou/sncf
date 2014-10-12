package fr.upmc.bean;

/***********************************************************************
 * Module:  Trasporteur.java
 * Author:  Nicolas Pigeot
 * Purpose: Defines the Class Trasporteur
 ***********************************************************************/

import java.util.*;

public class Trasporteur {
   private String nom;
   private String prenom;
   private String mail;
   private String password;
   private int id;
   
   public ArrayList<Voyage> voyage;
   public ArrayList<Evaluation> evaluation;
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public ArrayList<Voyage> getVoyage() {
	return voyage;
}
public void setVoyage(ArrayList<Voyage> voyage) {
	this.voyage = voyage;
}
public ArrayList<Evaluation> getEvaluation() {
	return evaluation;
}
public void setEvaluation(ArrayList<Evaluation> evaluation) {
	this.evaluation = evaluation;
}
   
   
  
}