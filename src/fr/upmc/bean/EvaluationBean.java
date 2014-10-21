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
@Table(name = "EVALUATION")
public class EvaluationBean extends MasterBEAN implements Serializable {
   

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;
	
	@Column(name = "NOTE", nullable = false)
	private int note;

	@Column(name = "COMMENTAIRE", nullable = true)
    private String commentaire;
    

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "evaluation", cascade = CascadeType.ALL)
	private TempUserBean tempUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TrasporteurBean transporteur;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
   
   

}