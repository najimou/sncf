package fr.upmc.test.dao;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

import fr.upmc.bean.EvaluationBean;
import fr.upmc.bean.TrasporteurBean;
import fr.upmc.dao.EvaluationDAO;

public class testEvaluation {

	
	public static void main(String[] args) {
		
		
		EvaluationDAO dao = new EvaluationDAO();
		
		EvaluationBean pojo = new EvaluationBean();
		
		pojo.setNote(5);
		pojo.setCommentaire("commentaire test");
		
		//insert
		dao.insert(pojo);
		
		//update
		pojo.setNote(1);
		TrasporteurBean tr = new TrasporteurBean();
		//tr.setId(1);
		tr.setMail("aaa");
		tr.setNom("nom");
		tr.setPassword("p");
		tr.setPrenom("prenom");
		//pojo.setTransporteur(tr);
		
		
		dao.insert(tr);
		
		
		
		dao.update(pojo);
		
		//get by id
		
		EvaluationBean pojo2 = dao.getById(1);
		tr.setMail("ma");
		//pojo2.setTransporteur(tr);
		pojo2.setNote(3);
		dao.update(pojo2);
		//System.out.println(pojo2.getTransporteur().getId());
		
		//delete
		
		dao.delete(pojo);
		
	}
}
