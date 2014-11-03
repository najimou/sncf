package fr.upmc.dao;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

import fr.upmc.bean.MasterBEAN;
import fr.upmc.hibernate.HibernateUtil;

public class MasterDAO {
	public static SessionFactory sf = HibernateUtil.getSessionFactory();
	public Session session;
	
	public boolean insert(MasterBEAN insert){
		 
		
		try{
			session = sf.openSession();
			session.beginTransaction();
			session.save(insert);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	

	public boolean update(MasterBEAN update) {
		
		try{
			session = sf.openSession();
			session.beginTransaction();
			session.update(update);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}


	public boolean delete(MasterBEAN delete) {
		
		try{
			session = sf.openSession();
			session.beginTransaction();
			session.delete(delete);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	


}
