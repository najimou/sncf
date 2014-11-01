package fr.upmc.metier;

import java.util.ArrayList;

import fr.upmc.bean.TransportBean;
import fr.upmc.bean.VoyageBean;
import fr.upmc.dao.TransportDAO;
import fr.upmc.dao.VoyageDAO;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/


public class Voyage {
   

   public boolean accepterTransport(int id) {
      try{
		  TransportDAO dao = new TransportDAO();
		  TransportBean bean = dao.getById(id);
		  bean.setAccepted(true);
		  // TODO mise en place parametres de session
		  bean.setAcceptedBy(1);
		  dao.update(bean);
		  return true;
      }
      catch(Exception e){ 
    	  return false;
      }
   }
   
   public boolean refuserTransport(int id) {
	   try{
			  TransportDAO dao = new TransportDAO();
			  TransportBean bean = dao.getById(id);
			  bean.setAccepted(false);
			  bean.setAcceptedBy(0);
			  dao.update(bean);
			  return true;
	      }
	   catch(Exception e){ 
	    	  return false;
	     }
   }
   
   public boolean finaliserTrasport(int id) {
	   try{
			  TransportDAO dao = new TransportDAO();
			  TransportBean bean = dao.getById(id);
			  bean.setFinished(true);
			  dao.update(bean);
			  return true;
	      }
	   catch(Exception e){ 
	    	  return false;
	     }
   }

   public boolean ajouterVoyage(VoyageBean bean) {
	  VoyageDAO dao = new VoyageDAO();
	  try{
		  // TODO controler si voyage existe deja en base pour cet utilisateur
		  dao.insert(bean);
		  return true;
	  }catch (Exception e){
		  return false;
	  }
   }

public ArrayList<VoyageBean> getVoyagesByGares(String depart, String arrivee) {
	
	VoyageDAO dao = new VoyageDAO();
	ArrayList<VoyageBean> list = dao.getByGares(depart, arrivee);
	if (list.size()<0)	return new ArrayList<VoyageBean>();
	else return list;
}

public ArrayList<VoyageBean> getVoyagesById(String p) {
	String[] ids = p.split(",");
	VoyageDAO dao = new VoyageDAO();
	ArrayList<VoyageBean> list = dao.getByIds(ids);
	return list;
}

}