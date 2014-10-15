package fr.upmc.dao;

import java.util.ArrayList;

import org.hibernate.Query;

import fr.upmc.bean.Transport;

public class TransportDAO extends MasterDAO{
	
	public Transport getById(int id){
		Query query = session.createQuery("from Transport where ID = :id ");
		query.setParameter("id", id);
		Transport e =  (Transport) query.uniqueResult();
		return e;		
	}
	
	public ArrayList<Transport> getByIdTransporteur(int id){
		Query query = session.createQuery("from Transport where idTransporteur = :id ");
		query.setParameter("id", id);
		ArrayList<Transport> e =  (ArrayList<Transport>) query.list();
		return e;		
	}
}
