package fr.upmc.test.dao;

import fr.upmc.bean.Transport;
import fr.upmc.dao.TransportDAO;

public class testTensport {

	public static void main(String[] args) {
		
		TransportDAO dao = new TransportDAO();
		
		Transport pojo = new Transport();
		
		pojo.setAccepted(true);
		pojo.setFinished(false);
		
		
		//insert
		dao.insert(pojo);
		
		//update
		pojo.setAccepted(false);
		dao.update(pojo);
		
		//get by id
		
		Transport pojo2 = dao.getById(1);
		
		
		//delete
		
		dao.delete(pojo);
		
	}

}
