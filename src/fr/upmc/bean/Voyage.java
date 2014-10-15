package fr.upmc.bean;

/***********************************************************************
 * Module:  Voyage.java
 * Author:  Nicolas Pigeot
 * Purpose: Defines the Class Voyage
 ***********************************************************************/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "VOYAGE")
public class Voyage extends MasterBEAN implements Serializable{
   
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;
	
	@Column(name = "DEPART", nullable = false)
	private String depart;
	
	@Column(name = "HEUREDEPART", nullable = false)
	private java.util.Date heureDepart;
	
	@Column(name = "ARRIVE", nullable = false)
	private String arrivee;
	
	@Column(name = "HEUREARRIVEE", nullable = false)
	private java.util.Date heureArrivee;
	
	@Column(name = "NBTRAIN", nullable = false)
	private String numeroTrain;  
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Trasporteur transporteur;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "voyage")
    public List<Transport> transport;

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
		
		public List<Transport> getTransport() {
			return transport;
		}
		
		public Trasporteur getTransporteur() {
			return transporteur;
		}

		public void setTransporteur(Trasporteur transporteur) {
			this.transporteur = transporteur;
		}

		public void setTransport(List<Transport> transport) {
			this.transport = transport;
		}
		   
   
  

}