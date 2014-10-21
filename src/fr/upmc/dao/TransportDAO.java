package fr.upmc.dao;

import java.util.ArrayList;

import org.hibernate.Query;

import fr.upmc.bean.TransportBean;

public class TransportDAO extends MasterDAO{
	
	public TransportBean getById(int id){
		Query query = session.createQuery("from Transport where ID = :id ");
		query.setParameter("id", id);
		TransportBean e =  (TransportBean) query.uniqueResult();
		return e;		
	}
	
	public ArrayList<TransportBean> getByIdTransporteur(int id){
		Query query = session.createQuery("from Transport where idTransporteur = :id ");
		query.setParameter("id", id);
		ArrayList<TransportBean> e =  (ArrayList<TransportBean>) query.list();
		return e;		
	}
}
