package fr.upmc.test.dao;

import fr.upmc.bean.Evaluation;
import fr.upmc.bean.Trasporteur;
import fr.upmc.dao.EvaluationDAO;
import fr.upmc.dao.TransporteurDAO;

public class testEvaluation {

	
	public static void main(String[] args) {
		
		
		EvaluationDAO dao = new EvaluationDAO();
		
		Evaluation pojo = new Evaluation();
		
		pojo.setNote(5);
		pojo.setCommentaire("commentaire test");
		
		//insert
		dao.insert(pojo);
		
		//update
		pojo.setNote(1);
		Trasporteur tr = new Trasporteur();
		//tr.setId(1);
		tr.setMail("aaa");
		tr.setNom("nom");
		tr.setPassword("p");
		tr.setPrenom("prenom");
		//pojo.setTransporteur(tr);
		
		
		dao.insert(tr);
		
		
		
		dao.update(pojo);
		
		//get by id
		
		Evaluation pojo2 = dao.getById(1);
		tr.setMail("ma");
		//pojo2.setTransporteur(tr);
		pojo2.setNote(3);
		dao.update(pojo2);
		//System.out.println(pojo2.getTransporteur().getId());
		
		//delete
		
		dao.delete(pojo);
		
	}
}
