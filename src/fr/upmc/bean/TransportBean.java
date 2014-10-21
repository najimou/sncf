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
	
	@Column(name = "ACCEPTED", nullable = false)
	private boolean accepted;
	
	@Column(name = "ACCEPTEDBY", nullable = true)
	private int acceptedBy;
	
	@Column(name = "FINISHED", nullable = true)
	private boolean finished;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "transport", cascade = CascadeType.ALL)
	private TempUserBean tempUser;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private VoyageBean voyage;
	
	
	
	
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
		public int isAcceptedBy() {
			return acceptedBy;
		}
		public void setAcceptedBy(int acceptedBy) {
			this.acceptedBy = acceptedBy;
		}


   
   
}