package fr.upmc.dao;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

import org.hibernate.Query;

import fr.upmc.bean.EvaluationBean;

public class EvaluationDAO extends MasterDAO {
 
	public EvaluationBean getById(int id){
		Query query = session.createQuery("from EvaluationBean where ID = :id ");
		query.setParameter("id", id);
		EvaluationBean e =  (EvaluationBean) query.uniqueResult();
		return e;		
	}
	
	// DELETE only this class
	
	// LOAD all subtables in lazy, if user not exist send a new empty user
	// and if getter is present
	
	// UPDATE not update transporteur and not update TempUser
	// to add this funtionality (check documentation to mesure impact) 
	// you can generate get/set attributes.

	
	
	
}
