package fr.upmc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import fr.upmc.bean.BeanExample;

public class TestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		//recuperer les données d'un get		
		request.getParameter( "nomParametre" );
		
		// envoyer un objet à la jsp
		BeanExample bean = new BeanExample();
		bean.setId(0);
		bean.setName("Nicolas");
		request.setAttribute( "data", bean );
		
		
		//redirection sur une jsp
		this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/bonjour.jsp" ).forward( request, response );
		 
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		
		
		
	}
	
	public void doHead(HttpServletRequest request, HttpServletResponse response){}
}
