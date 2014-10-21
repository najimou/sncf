package fr.upmc.dao;

import java.io.Serializable;

import org.hibernate.Query;

import fr.upmc.bean.TrasporteurBean;

public class TransporteurDAO extends MasterDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	public TrasporteurBean getByMail(String mail){
		Query query = session.createQuery("from Transporteur where MAIL = :mail ");
		query.setParameter("mail", mail);
		TrasporteurBean e =  (TrasporteurBean) query.uniqueResult();
		return e;		
	}
}
