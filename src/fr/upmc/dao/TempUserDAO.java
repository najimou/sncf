package fr.upmc.dao;

import org.hibernate.Query;

import fr.upmc.bean.TempUserBean;

public class TempUserDAO extends MasterDAO {

	public TempUserBean getById(int id) {
		Query query = session.createQuery("from TempUser where ID = :id ");
		query.setParameter("id", id);
		TempUserBean e =  (TempUserBean) query.uniqueResult();
		return e;	
		
	}
	
	
		
}
