package fr.upmc.test.dao;

import java.util.Date;

import fr.upmc.dao.VoyageDAO;
import fr.upmc.bean.Voyage;

public class testVoyage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VoyageDAO dao = new VoyageDAO();
		Voyage pojo = new Voyage();
		
		pojo.setArrivee("Rome");
		pojo.setDepart("Milan");
		pojo.setHeureArrivee(new Date());
		pojo.setHeureDepart(new Date());
		pojo.setNumeroTrain("58478");
		
		
		//insert
		dao.insert(pojo);
		
		//update
		pojo.setDepart("Naples");
		dao.update(pojo);
		
		//get by id
		
		//Trasporteur pojo2 = dao.getById(1);
		
		
		//delete
		
		dao.delete(pojo);
	}

}
