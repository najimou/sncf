package fr.upmc.test.dao;

import fr.upmc.bean.TempUser;
import fr.upmc.dao.TempUserDAO;

public class testTempUser {
	
	
	
	
	public static void main(String[] args) {
		
		
		TempUserDAO dao = new TempUserDAO();
		TempUser pojo = new TempUser();
		
		pojo.setId(1);
		pojo.setMail("mailll");
		pojo.setPassword("passssssss");
		
		
		//insert
		dao.insert(pojo);
		
		//update
		pojo.setMail("mail 2 test");
		dao.update(pojo);
		
		//get by id
		TempUser pojo2 = dao.getById(1);

		//delete		
		dao.delete(pojo);
	}
	
	
	
}