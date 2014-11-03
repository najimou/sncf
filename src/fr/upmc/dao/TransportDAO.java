package fr.upmc.dao;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

import java.util.ArrayList;

import org.hibernate.Query;

import fr.upmc.bean.TransportBean;

public class TransportDAO extends MasterDAO{
	
	public TransportBean getById(int id){
		session = sf.openSession();
		Query query = session.createQuery("from TransportBean where ID = :id ");
		query.setParameter("id", id);
		TransportBean e =  (TransportBean) query.uniqueResult();
		session.close();
		return e;		
	}
	
	public ArrayList<TransportBean> getByIdTransporteur(int id){
		session = sf.openSession();
		Query query = session.createQuery("from TransportBean as b  where b.proposedTo = :id ");
		query.setParameter("id", id);
		ArrayList<TransportBean> e =  (ArrayList<TransportBean>) query.list();
		session.close();
		return e;		
	}

	public ArrayList<TransportBean> getAll() {
		session = sf.openSession();
		Query query = session.createQuery("from TransportBean");
		ArrayList<TransportBean> e =  (ArrayList<TransportBean>) query.list();
		session.close();
		return e;		
	}

	public TransportBean getByToken(String token) {
		session = sf.openSession();
		Query query = session.createQuery("from TransportBean where token = :token ");
		query.setParameter("token", token);
		TransportBean e =  (TransportBean) query.uniqueResult();
		session.close();
		return e;
	}

	public TransportBean getByTokenAndMail(String token, String mail) {
		session = sf.openSession();
		Query query = session.createQuery("from TransportBean where token = :token ");
		query.setParameter("token", token);
		TransportBean e =  (TransportBean) query.uniqueResult();
		session.close();
		if (e.getMailReception().equals(mail))
			return e;
		return null;
	}

	public ArrayList<TransportBean> getByIdTransporteurToAccept(int id) {
		session = sf.openSession();
		Query query = session.createQuery("from TransportBean as b  where b.voyage.transporteur.id = :id and accepted = false");
		query.setParameter("id", id);
		ArrayList<TransportBean> e =  (ArrayList<TransportBean>) query.list();

		return e;
	}

	public ArrayList<TransportBean> getByIdTransporteurToDo(int id) {
		session = sf.openSession();
		Query query = session.createQuery("from TransportBean as b  where b.voyage.transporteur.id = :id and accepted = true and finished = false");
		query.setParameter("id", id);
		ArrayList<TransportBean> e =  (ArrayList<TransportBean>) query.list();

		return e;
	}

	public ArrayList<TransportBean> getByIdTransporteurFinished(int id) {
		session = sf.openSession();
		Query query = session.createQuery("from TransportBean as b  where b.voyage.transporteur.id = :id and finished = true");
		query.setParameter("id", id);
		ArrayList<TransportBean> e =  (ArrayList<TransportBean>) query.list();

		return e;
	}

	public TransportBean getByIdVoyageAndIdTransporteur(int idVoyage, int idTransporteur) {
		session = sf.openSession();
		Query query = session.createQuery("from TransportBean as b  where b.voyage.transporteur.id = :id and b.voyage.id = :idv");
		query.setParameter("id", idTransporteur);
		query.setParameter("idv", idVoyage);
		TransportBean e =  (TransportBean) query.uniqueResult();
		session.close();
		return e;
	}


}
