package fr.upmc.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import fr.upmc.bean.BeanExample;
import fr.upmc.bean.VoyageBean;
import fr.upmc.dao.VoyageDAO;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

			
		request.getParameter( "nomParametre" );
		
		
		BeanExample bean = new BeanExample();
		bean.setId(0);
		bean.setName("Nicolas");
		request.setAttribute( "data", bean );
		
		VoyageDAO dao = new VoyageDAO();
		VoyageBean v = new VoyageBean();
		v.setArrivee("arr");
		v.setDepart("dep");
		v.setHeureArrivee(new Date(0));
		v.setHeureDepart(new Date(0));
		v.setNumeroTrain("1231");
		dao.insert(v);
		
		
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/bonjour.jsp" ).forward( request, response );
		 
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		
		
		
	}
	
	public void doHead(HttpServletRequest request, HttpServletResponse response){}
}
