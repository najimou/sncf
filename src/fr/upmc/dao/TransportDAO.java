package fr.upmc.dao;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

import java.util.ArrayList;

import org.hibernate.Query;

import fr.upmc.bean.TransportBean;

public class TransportDAO extends MasterDAO{
	
	public TransportBean getById(int id){
		Query query = session.createQuery("from TransportBean where ID = :id ");
		query.setParameter("id", id);
		TransportBean e =  (TransportBean) query.uniqueResult();
		return e;		
	}
	
	public ArrayList<TransportBean> getByIdTransporteur(int id){
		Query query = session.createQuery("from TransportBean as b  where b.proposedTo = :id ");
		query.setParameter("id", id);
		ArrayList<TransportBean> e =  (ArrayList<TransportBean>) query.list();
		return e;		
	}

	public ArrayList<TransportBean> getAll() {
		Query query = session.createQuery("from TransportBean");
		ArrayList<TransportBean> e =  (ArrayList<TransportBean>) query.list();
		return e;		
	}

	public TransportBean getByToken(String token) {
		Query query = session.createQuery("from TransportBean where token = :token ");
		query.setParameter("token", token);
		TransportBean e =  (TransportBean) query.uniqueResult();
		return e;
	}

	public TransportBean getByTokenAndMail(String token, String mail) {
		Query query = session.createQuery("from TransportBean where token = :token ");
		query.setParameter("token", token);
		TransportBean e =  (TransportBean) query.uniqueResult();
		if (e.getMailReception().equals(mail))
			return e;
		return null;
	}

	public ArrayList<TransportBean> getByIdTransporteurToAccept(int id) {
		Query query = session.createQuery("from TransportBean as b  where b.voyage.transporteur.id = :id and accepted = false");
		query.setParameter("id", id);
		ArrayList<TransportBean> e =  (ArrayList<TransportBean>) query.list();
		return e;
	}

	public ArrayList<TransportBean> getByIdTransporteurToDo(int id) {
		Query query = session.createQuery("from TransportBean as b  where b.voyage.transporteur.id = :id and accepted = true and finished = false");
		query.setParameter("id", id);
		ArrayList<TransportBean> e =  (ArrayList<TransportBean>) query.list();
		return e;
	}

	public ArrayList<TransportBean> getByIdTransporteurFinished(int id) {
		Query query = session.createQuery("from TransportBean as b  where b.voyage.transporteur.id = :id and finished = true");
		query.setParameter("id", id);
		ArrayList<TransportBean> e =  (ArrayList<TransportBean>) query.list();
		return e;
	}


}
