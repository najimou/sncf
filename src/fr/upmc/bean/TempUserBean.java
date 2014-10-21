package fr.upmc.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/***********************************************************************
 * Module:  TempUser.java
 * Author:  Nicolas Pigeot
 * Purpose: Defines the Class TempUser
 ***********************************************************************/

@Entity
@Table(name = "TEMPUSER")
public class TempUserBean extends MasterBEAN implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
    private int id;
	
	@Column(name = "MAIL", nullable = false)
	private String mail;
    
	@Column(name = "PASSWORD", nullable = false)
    private String password;
	
	@Column(name = "PUBLISHED", nullable = false)
	private boolean published;
	
	public boolean isRated() {
		return rated;
	}

	public void setRated(boolean rated) {
		this.rated = rated;
	}

	public TransportBean getTransport() {
		return transport;
	}

	public void setTransport(TransportBean transport) {
		this.transport = transport;
	}

	@Column(name = "RATED", nullable = false)
	private boolean rated;
   
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
    private TransportBean transport;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
    private EvaluationBean evaluation;
	
	

    
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
		   
		   
		
}