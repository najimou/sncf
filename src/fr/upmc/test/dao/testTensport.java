package fr.upmc.test.dao;

import fr.upmc.bean.TransportBean;
import fr.upmc.dao.TransportDAO;

public class testTensport {

	public static void main(String[] args) {
		
		TransportDAO dao = new TransportDAO();
		
		TransportBean pojo = new TransportBean();
		
		pojo.setAccepted(true);
		pojo.setFinished(false);
		
		
		//insert
		dao.insert(pojo);
		
		//update
		pojo.setAccepted(false);
		dao.update(pojo);
		
		//get by id
		
		TransportBean pojo2 = dao.getById(1);
		
		
		//delete
		
		dao.delete(pojo);
		
	}

}
