package fr.upmc.bean;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

import java.io.Serializable;
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
public class VoyageBean extends MasterBEAN implements Serializable{
   
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;
	
	@Column(name = "DEPART", nullable = false)
	private String depart;
	
	@Column(name = "DATE", nullable = true)
	private String date;

	@Column(name = "HEUREDEPART", nullable = false)
	private String heureDepart;
	
	@Column(name = "ARRIVE", nullable = false)
	private String arrivee;
	
	@Column(name = "HEUREARRIVEE", nullable = false)
	private String heureArrivee;
	
	@Column(name = "NBTRAIN", nullable = false)
	private String numeroTrain;  
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TrasporteurBean transporteur;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "voyage")
    public List<TransportBean> transport;

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
		
		public String getHeureDepart() {
			return heureDepart;
		}
		
		public void setHeureDepart(String heureDepart) {
			this.heureDepart = heureDepart;
		}
		
		public String getArrivee() {
			return arrivee;
		}
		
		public void setArrivee(String arrivee) {
			this.arrivee = arrivee;
		}
		
		public String getHeureArrivee() {
			return heureArrivee;
		}
		
		public void setHeureArrivee(String heureArrivee) {
			this.heureArrivee = heureArrivee;
		}
		
		public String getNumeroTrain() {
			return numeroTrain;
		}
		
		public void setNumeroTrain(String numeroTrain) {
			this.numeroTrain = numeroTrain;
		}
		
		public List<TransportBean> getTransport() {
			return transport;
		}
		
		public TrasporteurBean getTransporteur() {
			return transporteur;
		}

		public void setTransporteur(TrasporteurBean transporteur) {
			this.transporteur = transporteur;
		}

		public void setTransport(List<TransportBean> transport) {
			this.transport = transport;
		}
		
		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}
		   
   
  

}