package fr.upmc.dao;

import org.hibernate.Session;

import fr.upmc.bean.MasterBEAN;
import fr.upmc.hibernate.HibernateUtil;

public class MasterDAO {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	public boolean insert(MasterBEAN insert){
		
		
		try{
			session.beginTransaction();
			session.save(insert);
			session.getTransaction().commit();
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	

	public boolean update(MasterBEAN update) {
		
		try{
			session.beginTransaction();
			session.update(update);
			session.getTransaction().commit();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}


	public boolean delete(MasterBEAN delete) {
		
		try{
			session.beginTransaction();
			session.delete(delete);
			session.getTransaction().commit();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	


}
