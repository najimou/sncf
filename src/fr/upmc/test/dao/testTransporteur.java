package fr.upmc.test.dao;
import fr.upmc.bean.TrasporteurBean;
import fr.upmc.dao.TransporteurDAO;

public class testTransporteur {

	public static void main(String[] args) {
	
		
TransporteurDAO dao = new TransporteurDAO();
		
		TrasporteurBean pojo = new TrasporteurBean();
		
		pojo.setId(1);
		pojo.setMail("mmaaaailllll");
		pojo.setNom("noooom");
		pojo.setPassword("passss");
		pojo.setPrenom("prenom");
		
		
		//insert
		dao.insert(pojo);
		
		//update
		pojo.setMail("arghhh@lol.fr");
		dao.update(pojo);
		
		//get by id
		
		//Trasporteur pojo2 = dao.getById(1);
		
		
		//delete
		
		dao.delete(pojo);
		
	}

}
