package fr.upmc.dao;

import java.util.ArrayList;

import org.hibernate.Query;

import fr.upmc.bean.Evaluation;

public class EvaluationDAO extends MasterDAO {
 
	public Evaluation getById(int id){
		Query query = session.createQuery("from Evaluation where ID = :id ");
		query.setParameter("id", id);
		Evaluation e =  (Evaluation) query.uniqueResult();
		return e;		
	}
	
	// DELETE only this class
	
	// LOAD all subtables in lazy, if user not exist send a new empty user
	// and if getter is present
	
	// UPDATE not update transporteur and not update TempUser
	// to add this funtionality (check documentation to mesure impact) 
	// you can generate get/set attributes.

	
	
	
}