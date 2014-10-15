package fr.upmc.bean;

/***********************************************************************
 * Module:  Trasporteur.java
 * Author:  Nicolas Pigeot
 * Purpose: Defines the Class Trasporteur
 ***********************************************************************/

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "TRANSPORTEUR")
public class Trasporteur extends MasterBEAN implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;
	
	@Column(name = "NOM", nullable = false)
	private String nom;
	
	@Column(name = "PRENOM", nullable = false)
	private String prenom;
	
	@Column(name = "EMAIL", nullable = false)
	private String mail;
	
	@Column(name = "PASS", nullable = false)
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transporteur")
	public List<Voyage> voyage;
   
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transporteur")
	public List<Evaluation> evaluation;
   
   
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
		public List<Voyage> getVoyage() {
			return voyage;
		}
		public void setVoyage(List<Voyage> voyage) {
			this.voyage = voyage;
		}
		public List<Evaluation> getEvaluation() {
			return evaluation;
		}
		public void setEvaluation(List<Evaluation> evaluation) {
			this.evaluation = evaluation;
		}
		   
		   
  
}