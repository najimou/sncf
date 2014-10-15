package fr.upmc.test;

import fr.upmc.bean.Evaluation;
import fr.upmc.bean.TempUser;
import fr.upmc.dao.EvaluationDAO;

public class TestHibernate {

	public static void main(String[] args) {
		
		EvaluationDAO dao = new EvaluationDAO();
		Evaluation obj = new Evaluation();
		obj.setNote(5);
		obj.setCommentaire("azerazer");
		TempUser tmp = new TempUser();
		tmp.setMail("mail");
		tmp.setPassword("pass");
		//obj.setTempUser(tmp);
		dao.insert(obj);
		
	

		obj.setCommentaire("commentaire 2!");

		dao.update(obj);
		
		dao.delete(obj);

	}

}
