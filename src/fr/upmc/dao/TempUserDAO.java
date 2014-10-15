package fr.upmc.dao;

import org.hibernate.Query;

import fr.upmc.bean.TempUser;

public class TempUserDAO extends MasterDAO {

	public TempUser getById(int id) {
		Query query = session.createQuery("from TempUser where ID = :id ");
		query.setParameter("id", id);
		TempUser e =  (TempUser) query.uniqueResult();
		return e;	
		
	}
	
	
		
}
