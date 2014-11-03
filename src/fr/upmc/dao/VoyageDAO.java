package fr.upmc.dao;

import java.util.ArrayList;

import org.hibernate.Query;

import fr.upmc.bean.VoyageBean;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

public class VoyageDAO extends MasterDAO{

	public ArrayList<VoyageBean> getByIdTransporteur(int id) {
		session = sf.openSession();
		Query query = session.createQuery("from VoyageBean as v where v.transporteur.id = :id ");
		query.setParameter("id", id);
		 ArrayList<VoyageBean> e =  ( ArrayList<VoyageBean>) query.list();
		 session.close();
		return e;	
	}

	public ArrayList<VoyageBean> getAllActives() {
		session = sf.openSession();
		Query query = session.createQuery("from VoyageBean");
		 ArrayList<VoyageBean> e =  ( ArrayList<VoyageBean>) query.list();
		 session.close();
		return e;
	}

	public ArrayList<VoyageBean> getByGares(String depart, String arrivee) {
		session = sf.openSession();
		Query query = session.createQuery("from VoyageBean where depart='"+depart+"' and arrivee='"+arrivee+"'");
		 ArrayList<VoyageBean> e =  ( ArrayList<VoyageBean>) query.list();
		 session.close();
		return e;
	}

	public ArrayList<VoyageBean> getByIds(String[] ids) {
		session = sf.openSession();
		if (ids.length>0){
			ArrayList<Integer> id = new ArrayList<Integer>();
			for (int i = 0; i < ids.length; i++) {
				id.add(Integer.parseInt(ids[i]));
			}
			
			Query query = session.createQuery("from VoyageBean where id IN (:ids)");
			query.setParameterList("ids", id);
			 ArrayList<VoyageBean> e =  ( ArrayList<VoyageBean>) query.list();
			 session.close();
			return e;
		}else return null;
	}

	public VoyageBean getById(int i) {
		session = sf.openSession();
		Query query = session.createQuery("from VoyageBean where id = :id ");
		query.setParameter("id", i);
		 VoyageBean e =  ( VoyageBean) query.uniqueResult();
		 session.close();
		return e;	
	}

}
