package fr.upmc.test;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

import fr.upmc.bean.EvaluationBean;
import fr.upmc.bean.TempUserBean;
import fr.upmc.dao.EvaluationDAO;

public class TestHibernate {

	public static void main(String[] args) {
		
		EvaluationDAO dao = new EvaluationDAO();
		EvaluationBean obj = new EvaluationBean();
		obj.setNote(5);
		obj.setCommentaire("azerazer");
		TempUserBean tmp = new TempUserBean();
		tmp.setMail("mail");
		tmp.setPassword("pass");
		//obj.setTempUser(tmp);
		dao.insert(obj);
		obj.setCommentaire("commentaire 2!");

		dao.update(obj);
		
		dao.delete(obj);

	}

}
