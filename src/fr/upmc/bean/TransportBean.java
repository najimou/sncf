package fr.upmc.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

@Entity
@Table(name = "TRANSPORT")
public class TransportBean extends MasterBEAN implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "ACCEPTED", nullable = false)
	private boolean accepted;
	
	@Column(name = "ACCEPTEDBY", nullable = true)
	private int acceptedBy;
	
	@Column(name = "PROPOSEDTO", nullable = true)
	private int proposedTo;
	
	@Column(name = "FINISHED", nullable = true)
	private boolean finished;
	
	@Column(name = "COLIS_DESCRIPTION", nullable = true)
	private String colisDescription;
	
	@Column(name = "COUT", nullable = true)
	private String cout;
	
	@Column(name = "COLIS_DIMENSION", nullable = true)
	private String colisDimension;
	
	@Column(name = "MAIL_ENVOI", nullable = true)
	private String mailEnvoi;
	
	@Column(name = "MAIL_RECEPTION", nullable = true)
	private String mailReception;
	
	@Column(name = "LISTE_VOYAGES_PROP_ENVOI", nullable = true)
	private String propositionVoyagesEnvoi;
	
	@Column(name = "TOKEN", nullable = true)
	private String token;
	
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "transport", cascade = CascadeType.ALL)
	private TempUserBean tempUser;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private VoyageBean voyage;
	
	
	
	
	public String getMailEnvoi() {
		return mailEnvoi;
	}

	public void setMailEnvoi(String mailEnvoi) {
		this.mailEnvoi = mailEnvoi;
	}

	public String getMailReception() {
		return mailReception;
	}

	public void setMailReception(String mailReception) {
		this.mailReception = mailReception;
	}

		public VoyageBean getVoyage() {
			return voyage;
		}
		
		public String getCout() {
			return cout;
		}
		
		public void setCout(String cout) {
			this.cout = cout;
		}
		
		public boolean isAccepted() {
			return accepted;
		}
		
		public void setAccepted(boolean accepted) {
			this.accepted = accepted;
		}

		public boolean isFinished() {
			return finished;
		}
		public void setFinished(boolean finished) {
			this.finished = finished;
		}
		public TempUserBean getTempUser() {
			if (tempUser == null) return new TempUserBean();
			return tempUser;
		}
		public String getColisDescription() {
			return colisDescription;
		}
		public void setColisDescription(String colisDescription) {
			this.colisDescription = colisDescription;
		}
		public String getColisDimension() {
			return colisDimension;
		}
		public void setColisDimension(String colisDimension) {
			this.colisDimension = colisDimension;
		}
		public int isAcceptedBy() {
			return acceptedBy;
		}
		public void setAcceptedBy(int acceptedBy) {
			this.acceptedBy = acceptedBy;
		}
		public int getProposedTo() {
			return proposedTo;
		}
		public void setProposedTo(int proposedTo) {
			this.proposedTo = proposedTo;
		}

		public String getPropositionVoyagesEnvoi() {
			return propositionVoyagesEnvoi;
		}

		public void setPropositionVoyagesEnvoi(String propositionVoyagesEnvoi) {
			this.propositionVoyagesEnvoi = propositionVoyagesEnvoi;
		}


		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
}