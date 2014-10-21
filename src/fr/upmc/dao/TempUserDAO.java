package fr.upmc.dao;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

import org.hibernate.Query;

import fr.upmc.bean.TempUserBean;

public class TempUserDAO extends MasterDAO {

	public TempUserBean getById(int id) {
		Query query = session.createQuery("from TempUserBean where ID = :id ");
		query.setParameter("id", id);
		TempUserBean e =  (TempUserBean) query.uniqueResult();
		return e;	
		
	}
	
	
		
}
