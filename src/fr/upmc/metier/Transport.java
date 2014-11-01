package fr.upmc.metier;

import java.util.ArrayList;

import fr.upmc.bean.TransportBean;
import fr.upmc.bean.VoyageBean;
import fr.upmc.dao.TransportDAO;
import fr.upmc.service.TokenGenerator;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

public class Transport {
   public boolean finaliser() {
      // TODO: implement
      return false;
   }
   
   public boolean creer(TransportBean t) {
     TransportDAO dao = new TransportDAO();
     return dao.insert(t);
   }
   
   public boolean supprimer() {
      // TODO: implement
      return false;
   }

public boolean ajouterChoixVoyagesEnvoyeur(int parseInt, String string) {
	 TransportDAO dao = new TransportDAO();
	 TransportBean pojo = dao.getById(parseInt);
	 pojo.setPropositionVoyagesEnvoi(string);
	 return dao.update(pojo);
	
}

public String setToken(int id) {
	 TransportDAO dao = new TransportDAO();
	 TransportBean pojo = dao.getById(id);
	 pojo.setToken(TokenGenerator.getToken());
	 dao.update(pojo);
	 return pojo.getToken();
	
}

public TransportBean getTransportByToken(String token) {
	 TransportDAO dao = new TransportDAO();
	 TransportBean pojo = dao.getByToken(token);
	 return pojo;
}

public TransportBean getTransportByTokenAndMail(String token, String mail) {
	TransportDAO dao = new TransportDAO();
	 TransportBean pojo = dao.getByTokenAndMail(token, mail);
	 return pojo;
}



}