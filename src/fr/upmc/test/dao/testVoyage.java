package fr.upmc.test.dao;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

import java.util.Date;

import fr.upmc.dao.VoyageDAO;
import fr.upmc.bean.VoyageBean;

public class testVoyage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VoyageDAO dao = new VoyageDAO();
		VoyageBean pojo = new VoyageBean();
		
		pojo.setArrivee("Rome");
		pojo.setDepart("Milan");
		pojo.setHeureArrivee("aa");
		pojo.setHeureDepart("aa");
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
