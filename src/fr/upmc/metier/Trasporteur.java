package fr.upmc.metier;

import fr.upmc.bean.TransportBean;
import fr.upmc.bean.TrasporteurBean;
import fr.upmc.dao.TransporteurDAO;
import fr.upmc.service.MailService;


/***********************************************************************
 * Module:  Trasporteur.java
 * Author:  Nicols Pigeot
 * Purpose: Defines the Class Trasporteur
 ***********************************************************************/

public class Trasporteur {

   
   public boolean login() {
      // TODO: implement
      return false;
   }
   
   public boolean logout() {
      // TODO: implement
      return false;
   }
   
   public boolean createProfile(TrasporteurBean transporteur){
	   
	   try{
		   TransporteurDAO dao = new TransporteurDAO();
		   dao.insert(transporteur);
		   return true;
	   }catch(Exception e){
		   return false;
	   }
	   
   }
   
   public boolean updateProfile(TrasporteurBean transporteur) {
     
	   try{
		   TransporteurDAO dao = new TransporteurDAO();
		   dao.update(transporteur);
		   return true;
	   }catch(Exception e){
		   return false;
	   }
	   
   }
   
   public boolean accepterTransport() {
      // TODO: implement
      return false;
   }
   
   public boolean ajouterVoyage() {
      // TODO: implement
      return false;
   }
   
   public boolean supprimerVoyage() {
      // TODO: implement
      return false;
   }
   
   public boolean finaliserTrasport() {
	// TODO: implement
      return false;
   }

   public boolean resendMail(String mail) {
	   try{
		   TransporteurDAO dao = new TransporteurDAO();
		   TrasporteurBean pojo = dao.getByMail(mail);
		   MailService.sendMail(pojo.getMail(),"",  "renvoi mail", "hello mail");
		   return true;
	   }catch(Exception e){
		   return false;
	   }
	
	
}
}