package fr.upmc.bean;

import javax.persistence.*;

/***********************************************************************
 * Module:  Evaluation.java
 * Author:  Nicolas Pigeot
 * Purpose: Defines the Class Evaluation
 ***********************************************************************/


@Entity
@Table(name = "EVALUATION")
public class Evaluation {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int note;

	@Column(name = "COMMENTAIRE", nullable = true)
    private String commentaire;
    
	
	@Column(name = "ID_TRANSPORTEUR", nullable = false)
	private int idTransporteur;

	
	
		public int getNote() {
			return note;
		}
		public void setNote(int note) {
			this.note = note;
		}
		public String getCommentaire() {
			return commentaire;
		}
		public void setCommentaire(String commentaire) {
			this.commentaire = commentaire;
		}
		public int getIdTransporteur() {
			return idTransporteur;
		}
		public void setIdTransporteur(int idTransporteur) {
			this.idTransporteur = idTransporteur;
		}
   
   

}