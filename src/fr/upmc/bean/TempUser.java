package fr.upmc.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/***********************************************************************
 * Module:  TempUser.java
 * Author:  Nicolas Pigeot
 * Purpose: Defines the Class TempUser
 ***********************************************************************/

@Entity
@Table(name = "TEMPUSER")
public class TempUser {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
    private int id;
	
	@Column(name = "MAIL", nullable = false)
	private String mail;
    
	@Column(name = "PASSWORD", nullable = false)
    private String password;
   
 
    public Transport transport;
	
	
    public Evaluation evaluation;
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
public Transport getTransport() {
	return transport;
}
public void setTransport(Transport transport) {
	this.transport = transport;
}
public Evaluation getEvaluation() {
	return evaluation;
}
public void setEvaluation(Evaluation evaluation) {
	this.evaluation = evaluation;
}
   
   

}