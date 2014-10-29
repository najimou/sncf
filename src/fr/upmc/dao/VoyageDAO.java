package fr.upmc.dao;

import java.util.ArrayList;

import org.hibernate.Query;

import fr.upmc.bean.VoyageBean;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

public class VoyageDAO extends MasterDAO{

	public ArrayList<VoyageBean> getByIdTransporteur(int id) {
		Query query = session.createQuery("from VoyageBean as v where v.transporteur.id = :id ");
		query.setParameter("id", id);
		 ArrayList<VoyageBean> e =  ( ArrayList<VoyageBean>) query.list();
		return e;	
	}

	public ArrayList<VoyageBean> getAllActives() {
		Query query = session.createQuery("from VoyageBean");
		 ArrayList<VoyageBean> e =  ( ArrayList<VoyageBean>) query.list();
		return e;
	}

}
