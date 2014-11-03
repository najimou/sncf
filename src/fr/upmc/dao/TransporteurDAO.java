package fr.upmc.dao;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

import java.io.Serializable;

import org.hibernate.Query;

import fr.upmc.bean.TrasporteurBean;

public class TransporteurDAO extends MasterDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	public TrasporteurBean getByMail(String mail){
		session = sf.openSession();
		Query query = session.createQuery("from TrasporteurBean where mail = :mail ");
		query.setParameter("mail", mail);
		TrasporteurBean e =  (TrasporteurBean) query.uniqueResult();
		session.close();
		return e;		
	}
}
